package com.proyecto.encuesta.infrastructure.repository.user;

import com.proyecto.encuesta.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
