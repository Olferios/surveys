package com.proyecto.encuesta.aplication.service.surveyjson;

import com.proyecto.encuesta.domain.entities.SurveyJson;

import java.util.List;
import java.util.Optional;

public interface ISurveyJsonService {

    Optional<SurveyJson> findById(Long id);

    List<SurveyJson> getAll();

    SurveyJson save(SurveyJson surveyJson);

    SurveyJson update(Long id, SurveyJson surveyJson);

    void deleteById(Long id);
}
