package com.proyecto.encuesta.aplication.service.survey;

import com.proyecto.encuesta.domain.entities.Survey;

import java.util.List;
import java.util.Optional;

public interface ISurveyService {

    Optional<Survey> findById(Long id);

    List<Survey> getAll();

    Survey save(Survey survey);

    Survey update(Long id, Survey survey);
    Survey updateEnable(Long id, Survey survey);
    void deleteById(Long id);
}
