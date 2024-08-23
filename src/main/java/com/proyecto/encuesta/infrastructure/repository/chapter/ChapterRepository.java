package com.proyecto.encuesta.infrastructure.repository.chapter;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.encuesta.domain.enties.CategoryCatalog;

public interface ChapterRepository extends JpaRepository<CategoryCatalog,Long> {

}
