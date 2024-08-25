package com.proyecto.encuesta.infrastructure.repository.userRol;

import com.proyecto.encuesta.domain.entities.UserRol;
import com.proyecto.encuesta.domain.entities.UserRolpk;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRolRepository extends JpaRepository<UserRol, UserRolpk> {
}
