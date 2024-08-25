package com.proyecto.encuesta.aplication.service.responseOption;

import com.proyecto.encuesta.domain.entities.ResponseOption;

import java.util.List;
import java.util.Optional;

public interface IResponseOptionService {

    Optional<ResponseOption> findById(Long id);

    List<ResponseOption> getAll();

    ResponseOption save(ResponseOption responseOption);

    ResponseOption update(Long id, ResponseOption responseOption);

    void deleteById(Long id);
}
