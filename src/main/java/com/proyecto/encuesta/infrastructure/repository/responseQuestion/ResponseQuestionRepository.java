package com.proyecto.encuesta.infrastructure.repository.responseQuestion;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.encuesta.domain.enties.CategoryCatalog;

public interface ResponseQuestionRepository extends JpaRepository<CategoryCatalog,Long> {

}
