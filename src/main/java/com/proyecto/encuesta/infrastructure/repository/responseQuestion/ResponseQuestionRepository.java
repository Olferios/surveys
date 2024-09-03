package com.proyecto.encuesta.infrastructure.repository.responseQuestion;

import com.proyecto.encuesta.domain.entities.SubQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResponseQuestionRepository extends JpaRepository<SubQuestion, Long> {
}
