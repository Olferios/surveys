package com.proyecto.encuesta.aplication.service.question;

import com.proyecto.encuesta.domain.entities.Question;

import java.util.List;
import java.util.Optional;

public interface IQuestionService {

    Optional<Question> findById(Long id);

    List<Question> getAll();

    Question save(Question question);

    Question update(Long id, Question question);

    void deleteById(Long id);
}
