package com.proyecto.encuesta.infrastructure.repository.rol;

import com.proyecto.encuesta.domain.entities.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolRepository extends JpaRepository<Rol, Long> {
}
