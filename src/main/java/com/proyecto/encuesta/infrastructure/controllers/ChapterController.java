package com.proyecto.encuesta.infrastructure.controllers;

import com.proyecto.encuesta.domain.entities.Chapter;
import com.proyecto.encuesta.aplication.service.chapter.IChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/chapter")
public class ChapterController {

    @Autowired
    private IChapterService chapterService;

    @GetMapping
    public ResponseEntity<List<Chapter>> list() {
        List<Chapter> chapters = chapterService.getAll();
        return new ResponseEntity<>(chapters, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Chapter> show(@PathVariable Long id) {
        return chapterService.findById(id)
                .map(chapter -> new ResponseEntity<>(chapter, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Chapter> create(@RequestBody Chapter chapter) {
        Chapter createdChapter = chapterService.save(chapter);
        return new ResponseEntity<>(createdChapter, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Chapter> update(@PathVariable Long id, @RequestBody Chapter chapter) {
        Chapter updatedChapter = chapterService.update(id, chapter);
        if (updatedChapter != null) {
            return new ResponseEntity<>(updatedChapter, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (chapterService.findById(id).isPresent()) {
            chapterService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
