package com.proyecto.encuesta.infrastructure.controllers;

import com.proyecto.encuesta.domain.entities.OptionQuestion;
import com.proyecto.encuesta.aplication.service.subresponseOption.ISubresponseOptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/OptionQuestion")
public class SubresponseOptionController {

    @Autowired
    private ISubresponseOptionService subresponseOptionService;

    @GetMapping
    public ResponseEntity<List<OptionQuestion>> list() {
        List<OptionQuestion> subresponseOptions = subresponseOptionService.getAll();
        return new ResponseEntity<>(subresponseOptions, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OptionQuestion> show(@PathVariable Long id) {
        return subresponseOptionService.findById(id)
                .map(subresponseOption -> new ResponseEntity<>(subresponseOption, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<OptionQuestion> create(@RequestBody OptionQuestion subresponseOption) {
        OptionQuestion createdSubresponseOption = subresponseOptionService.save(subresponseOption);
        return new ResponseEntity<>(createdSubresponseOption, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OptionQuestion> update(@PathVariable Long id, @RequestBody OptionQuestion subresponseOption) {
        OptionQuestion updatedSubresponseOption = subresponseOptionService.update(id, subresponseOption);
        if (updatedSubresponseOption != null) {
            return new ResponseEntity<>(updatedSubresponseOption, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (subresponseOptionService.findById(id).isPresent()) {
            subresponseOptionService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
