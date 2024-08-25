package com.proyecto.encuesta.infrastructure.repository.surveyJson;

import com.proyecto.encuesta.domain.entities.SurveyJson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurveyJsonRepository extends JpaRepository<SurveyJson, Long> {
}
