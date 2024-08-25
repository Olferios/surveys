package com.proyecto.encuesta.infrastructure.controllers;

import com.proyecto.encuesta.domain.entities.SubresponseOption;
import com.proyecto.encuesta.aplication.service.subresponseOption.ISubresponseOptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/subresponseOption")
public class SubresponseOptionController {

    @Autowired
    private ISubresponseOptionService subresponseOptionService;

    @GetMapping
    public ResponseEntity<List<SubresponseOption>> list() {
        List<SubresponseOption> subresponseOptions = subresponseOptionService.getAll();
        return new ResponseEntity<>(subresponseOptions, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubresponseOption> show(@PathVariable Long id) {
        return subresponseOptionService.findById(id)
                .map(subresponseOption -> new ResponseEntity<>(subresponseOption, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<SubresponseOption> create(@RequestBody SubresponseOption subresponseOption) {
        SubresponseOption createdSubresponseOption = subresponseOptionService.save(subresponseOption);
        return new ResponseEntity<>(createdSubresponseOption, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SubresponseOption> update(@PathVariable Long id, @RequestBody SubresponseOption subresponseOption) {
        SubresponseOption updatedSubresponseOption = subresponseOptionService.update(id, subresponseOption);
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
