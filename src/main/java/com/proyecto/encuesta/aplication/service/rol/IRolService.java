package com.proyecto.encuesta.aplication.service.rol;

import com.proyecto.encuesta.domain.entities.Rol;

import java.util.List;
import java.util.Optional;

public interface IRolService {

    Optional<Rol> findById(Long id);

    List<Rol> getAll();

    Rol save(Rol rol);

    Rol update(Long id, Rol rol);

    void deleteById(Long id);
}
