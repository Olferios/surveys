package com.proyecto.encuesta.aplication.service.responseOption;

import com.proyecto.encuesta.domain.entities.Options;

import java.util.List;
import java.util.Optional;

public interface IResponseOptionService {

    Optional<Options> findById(Long id);

    List<Options> getAll();

    Options save(Options responseOption);

    Options update(Long id, Options responseOption);

    void deleteById(Long id);
}
