package com.proyecto.encuesta.infrastructure.repository.survey;

import com.proyecto.encuesta.aplication.service.survey.ISurveyService;
import com.proyecto.encuesta.domain.entities.Survey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SurveyAdapter implements ISurveyService {

    @Autowired
    private SurveyRepository surveyRepository;

    @Override
    public Optional<Survey> findById(Long id) {
        return surveyRepository.findById(id);
    }

    @Override
    public List<Survey> getAll() {
        return surveyRepository.findAll();
    }

    @Override
    public Survey save(Survey survey) {
        return surveyRepository.save(survey);
    }

    @Override
    public Survey update(Long id, Survey survey) {
        return surveyRepository.findById(id)
                .map(existingSurvey -> {
                    existingSurvey.setName(survey.getName());
                    existingSurvey.setDescription(survey.getDescription());
                    
                    return surveyRepository.save(existingSurvey);
                })
                .orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        surveyRepository.deleteById(id);
    }

    @Override
    public Survey updateEnable(Long id, Survey survey) {
        return surveyRepository.findById(id)
                .map(existingSurvey -> {
                    existingSurvey.setEnable(survey.isEnable());
                    return surveyRepository.save(existingSurvey);
                })
                .orElse(null);
    }
}
