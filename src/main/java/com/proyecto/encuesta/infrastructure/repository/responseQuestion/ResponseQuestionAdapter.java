package com.proyecto.encuesta.infrastructure.repository.responseQuestion;

import com.proyecto.encuesta.aplication.service.responseQuestion.IResponseQuestionService;
import com.proyecto.encuesta.domain.entities.SubQuestion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResponseQuestionAdapter implements IResponseQuestionService {

    @Autowired
    private ResponseQuestionRepository responseQuestionRepository;

    @Override
    public Optional<SubQuestion> findById(Long id) {
        return responseQuestionRepository.findById(id);
    }

    @Override
    public List<SubQuestion> getAll() {
        return responseQuestionRepository.findAll();
    }

    @Override
    public SubQuestion save(SubQuestion responseQuestion) {
        return responseQuestionRepository.save(responseQuestion);
    }

    @Override
    public SubQuestion update(Long id, SubQuestion responseQuestion) {
        return responseQuestionRepository.findById(id)
                .map(existingResponseQuestion -> {
                    existingResponseQuestion.setResponsetext(responseQuestion.getResponsetext());
                    return responseQuestionRepository.save(existingResponseQuestion);
                })
                .orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        responseQuestionRepository.deleteById(id);
    }
}
