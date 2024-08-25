package com.proyecto.encuesta.aplication.service.userRol;

import com.proyecto.encuesta.domain.entities.UserRol;
import com.proyecto.encuesta.domain.entities.UserRolpk;

import java.util.List;
import java.util.Optional;

public interface IUserRolService {

    Optional<UserRol> findById(UserRolpk userRolpk);

    List<UserRol> getAll();

    UserRol save(UserRol userRol);

    UserRol update(UserRolpk userRolpk, UserRol userRol);

    void deleteById(UserRolpk userRolpk);
}
