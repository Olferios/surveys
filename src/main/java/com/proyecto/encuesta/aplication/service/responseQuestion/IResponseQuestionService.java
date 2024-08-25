package com.proyecto.encuesta.aplication.service.responseQuestion;

import com.proyecto.encuesta.domain.entities.ResponseQuestion;

import java.util.List;
import java.util.Optional;

public interface IResponseQuestionService {

    Optional<ResponseQuestion> findById(Long id);

    List<ResponseQuestion> getAll();

    ResponseQuestion save(ResponseQuestion responseQuestion);

    ResponseQuestion update(Long id, ResponseQuestion responseQuestion);

    void deleteById(Long id);
}
