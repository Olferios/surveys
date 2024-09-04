package com.proyecto.encuesta.aplication.service.responseQuestion;

import com.proyecto.encuesta.domain.entities.SubQuestion;

import java.util.List;
import java.util.Optional;

public interface IResponseQuestionService {

    Optional<SubQuestion> findById(Long id);

    List<SubQuestion> getAll();

    SubQuestion save(SubQuestion responseQuestion);

    SubQuestion update(Long id, SubQuestion responseQuestion);

    void deleteById(Long id);
}
