package com.proyecto.encuesta.infrastructure.repository.subresponseOption;

import com.proyecto.encuesta.domain.entities.OptionQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubresponseOptionRepository extends JpaRepository<OptionQuestion, Long> {
}
