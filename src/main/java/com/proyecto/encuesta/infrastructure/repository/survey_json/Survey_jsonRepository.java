package com.proyecto.encuesta.infrastructure.repository.survey_json;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.encuesta.domain.enties.CategoryCatalog;

public interface Survey_jsonRepository extends JpaRepository<CategoryCatalog,Long> {

}
