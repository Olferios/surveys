package com.proyecto.encuesta.infrastructure.controllers;

import com.proyecto.encuesta.domain.entities.ResponseOption;
import com.proyecto.encuesta.aplication.service.responseOption.IResponseOptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/responseOption")
public class ResponseOptionController {

    @Autowired
    private IResponseOptionService responseOptionService;

    @GetMapping
    public ResponseEntity<List<ResponseOption>> list() {
        List<ResponseOption> responseOptions = responseOptionService.getAll();
        return new ResponseEntity<>(responseOptions, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseOption> show(@PathVariable Long id) {
        return responseOptionService.findById(id)
                .map(responseOption -> new ResponseEntity<>(responseOption, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<ResponseOption> create(@RequestBody ResponseOption responseOption) {
        ResponseOption createdResponseOption = responseOptionService.save(responseOption);
        return new ResponseEntity<>(createdResponseOption, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseOption> update(@PathVariable Long id, @RequestBody ResponseOption responseOption) {
        ResponseOption updatedResponseOption = responseOptionService.update(id, responseOption);
        if (updatedResponseOption != null) {
            return new ResponseEntity<>(updatedResponseOption, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (responseOptionService.findById(id).isPresent()) {
            responseOptionService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
