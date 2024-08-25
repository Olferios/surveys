package com.proyecto.encuesta.infrastructure.controllers;

import com.proyecto.encuesta.domain.entities.SurveyJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.proyecto.encuesta.aplication.service.surveyjson.ISurveyJsonService;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/surveyJson")
public class SurveyJsonController {

    @Autowired
    private ISurveyJsonService surveyJsonService;

    @GetMapping
    public ResponseEntity<List<SurveyJson>> list() {
        List<SurveyJson> surveyJsons = surveyJsonService.getAll();
        return new ResponseEntity<>(surveyJsons, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SurveyJson> show(@PathVariable Long id) {
        return surveyJsonService.findById(id)
                .map(surveyJson -> new ResponseEntity<>(surveyJson, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<SurveyJson> create(@RequestBody SurveyJson surveyJson) {
        SurveyJson createdSurveyJson = surveyJsonService.save(surveyJson);
        return new ResponseEntity<>(createdSurveyJson, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SurveyJson> update(@PathVariable Long id, @RequestBody SurveyJson surveyJson) {
        SurveyJson updatedSurveyJson = surveyJsonService.update(id, surveyJson);
        if (updatedSurveyJson != null) {
            return new ResponseEntity<>(updatedSurveyJson, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (surveyJsonService.findById(id).isPresent()) {
            surveyJsonService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
