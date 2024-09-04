package com.proyecto.encuesta.infrastructure.repository.responseOption;

import com.proyecto.encuesta.domain.entities.Options;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResponseOptionRepository extends JpaRepository<Options, Long> {
}
