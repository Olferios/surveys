package com.proyecto.encuesta.aplication.service.subresponseOption;

import com.proyecto.encuesta.domain.entities.OptionQuestion;

import java.util.List;
import java.util.Optional;

public interface ISubresponseOptionService {

    Optional<OptionQuestion> findById(Long id);

    List<OptionQuestion> getAll();

    OptionQuestion save(OptionQuestion subresponseOption);

    OptionQuestion update(Long id, OptionQuestion subresponseOption);

    void deleteById(Long id);
}
