package com.proyecto.encuesta.infrastructure.repository.responseOption;

import com.proyecto.encuesta.domain.entities.ResponseOption;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResponseOptionRepository extends JpaRepository<ResponseOption, Long> {
}
