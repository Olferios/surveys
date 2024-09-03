package com.proyecto.encuesta.infrastructure.controllers;

import com.proyecto.encuesta.domain.entities.SubQuestion;
import com.proyecto.encuesta.aplication.service.responseQuestion.IResponseQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/responseQuestion")
public class ResponseQuestionController {

    @Autowired
    private IResponseQuestionService responseQuestionService;

    @GetMapping
    public ResponseEntity<List<SubQuestion>> list() {
        List<SubQuestion> responseQuestions = responseQuestionService.getAll();
        return new ResponseEntity<>(responseQuestions, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubQuestion> show(@PathVariable Long id) {
        return responseQuestionService.findById(id)
                .map(responseQuestion -> new ResponseEntity<>(responseQuestion, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<SubQuestion> create(@RequestBody SubQuestion responseQuestion) {
        SubQuestion createdResponseQuestion = responseQuestionService.save(responseQuestion);
        return new ResponseEntity<>(createdResponseQuestion, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SubQuestion> update(@PathVariable Long id, @RequestBody SubQuestion responseQuestion) {
        SubQuestion updatedResponseQuestion = responseQuestionService.update(id, responseQuestion);
        if (updatedResponseQuestion != null) {
            return new ResponseEntity<>(updatedResponseQuestion, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (responseQuestionService.findById(id).isPresent()) {
            responseQuestionService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
