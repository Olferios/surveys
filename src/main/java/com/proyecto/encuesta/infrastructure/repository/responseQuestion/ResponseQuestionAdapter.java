package com.proyecto.encuesta.infrastructure.repository.responseQuestion;

import com.proyecto.encuesta.aplication.service.responseQuestion.IResponseQuestionService;
import com.proyecto.encuesta.domain.entities.ResponseQuestion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResponseQuestionAdapter implements IResponseQuestionService {

    @Autowired
    private ResponseQuestionRepository responseQuestionRepository;

    @Override
    public Optional<ResponseQuestion> findById(Long id) {
        return responseQuestionRepository.findById(id);
    }

    @Override
    public List<ResponseQuestion> getAll() {
        return responseQuestionRepository.findAll();
    }

    @Override
    public ResponseQuestion save(ResponseQuestion responseQuestion) {
        return responseQuestionRepository.save(responseQuestion);
    }

    @Override
    public ResponseQuestion update(Long id, ResponseQuestion responseQuestion) {
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
