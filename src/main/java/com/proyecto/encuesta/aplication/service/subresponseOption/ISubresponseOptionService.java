package com.proyecto.encuesta.aplication.service.subresponseOption;

import com.proyecto.encuesta.domain.entities.SubresponseOption;

import java.util.List;
import java.util.Optional;

public interface ISubresponseOptionService {

    Optional<SubresponseOption> findById(Long id);

    List<SubresponseOption> getAll();

    SubresponseOption save(SubresponseOption subresponseOption);

    SubresponseOption update(Long id, SubresponseOption subresponseOption);

    void deleteById(Long id);
}
