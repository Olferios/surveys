package com.proyecto.encuesta.infrastructure.repository.subresponseOptions;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.encuesta.domain.enties.CategoryCatalog;

public interface SubresponseOptionRepository extends JpaRepository<CategoryCatalog,Long> {

}
