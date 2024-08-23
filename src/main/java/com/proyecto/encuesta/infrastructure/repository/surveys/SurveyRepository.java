package com.proyecto.encuesta.infrastructure.repository.surveys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.encuesta.domain.enties.CategoryCatalog;

public interface SurveyRepository extends JpaRepository<CategoryCatalog,Long> {

}
