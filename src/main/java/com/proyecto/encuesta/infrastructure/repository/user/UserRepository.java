package com.proyecto.encuesta.infrastructure.repository.user;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.proyecto.encuesta.domain.entities.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity,Long> {
    Optional<UserEntity> findUserEntityByUsername(String username);
}
