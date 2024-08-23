package com.proyecto.encuesta.infrastructure.repository.questions;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.encuesta.domain.enties.CategoryCatalog;

public interface QuestionRepository extends JpaRepository<CategoryCatalog,Long> {

}
