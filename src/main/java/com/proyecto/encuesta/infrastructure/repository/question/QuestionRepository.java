package com.proyecto.encuesta.infrastructure.repository.question;

import com.proyecto.encuesta.domain.entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}
