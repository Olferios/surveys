package com.proyecto.encuesta.aplication.service.user;

import com.proyecto.encuesta.domain.entities.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    Optional<User> findById(Long id);

    List<User> getAll();

    User save(User user);

    User update(Long id, User user);

    void deleteById(Long id);
}
