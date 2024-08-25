package com.proyecto.encuesta.infrastructure.repository.categoriesCatalog;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.encuesta.domain.entities.CategoryCatalog;

public interface CategoryCatalogRepository extends JpaRepository<CategoryCatalog,Long> {

}
