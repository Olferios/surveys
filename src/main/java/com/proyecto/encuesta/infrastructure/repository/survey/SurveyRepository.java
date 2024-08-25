package com.proyecto.encuesta.infrastructure.repository.survey;

import com.proyecto.encuesta.domain.entities.Survey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurveyRepository extends JpaRepository<Survey, Long> {
}
