package com.proyecto.encuesta.infrastructure.repository.surveyJson;


import com.proyecto.encuesta.aplication.service.surveyjson.ISurveyJsonService;
import com.proyecto.encuesta.domain.entities.SurveyJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SurveyJsonAdapter implements ISurveyJsonService {

    @Autowired
    private SurveyJsonRepository surveyJsonRepository;

    @Override
    public Optional<SurveyJson> findById(Long id) {
        return surveyJsonRepository.findById(id);
    }

    @Override
    public List<SurveyJson> getAll() {
        return surveyJsonRepository.findAll();
    }

    @Override
    public SurveyJson save(SurveyJson surveyJson) {
        return surveyJsonRepository.save(surveyJson);
    }

    @Override
    public SurveyJson update(Long id, SurveyJson surveyJson) {
        return surveyJsonRepository.findById(id)
                .map(existingSurveyJson -> {
                    existingSurveyJson.setSurvey(surveyJson.getSurvey());
                    existingSurveyJson.setPayloadString(surveyJson.getPayloadString());
                    return surveyJsonRepository.save(existingSurveyJson);
                })
                .orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        surveyJsonRepository.deleteById(id);
    }
}
