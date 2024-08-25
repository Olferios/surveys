package com.proyecto.encuesta.infrastructure.controllers;

import com.proyecto.encuesta.domain.entities.Survey;
import com.proyecto.encuesta.aplication.service.survey.ISurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/survey")
public class SurveyController {

    @Autowired
    private ISurveyService surveyService;

    @GetMapping
    public ResponseEntity<List<Survey>> list() {
        List<Survey> surveys = surveyService.getAll();
        return new ResponseEntity<>(surveys, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Survey> show(@PathVariable Long id) {
        return surveyService.findById(id)
                .map(survey -> new ResponseEntity<>(survey, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Survey> create(@RequestBody Survey survey) {
        Survey createdSurvey = surveyService.save(survey);
        return new ResponseEntity<>(createdSurvey, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Survey> update(@PathVariable Long id, @RequestBody Survey survey) {
        Survey updatedSurvey = surveyService.update(id, survey);
        if (updatedSurvey != null) {
            return new ResponseEntity<>(updatedSurvey, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (surveyService.findById(id).isPresent()) {
            surveyService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
