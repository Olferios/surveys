package com.proyecto.encuesta.infrastructure.repository.roles;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.encuesta.domain.enties.CategoryCatalog;

public interface RolRepository extends JpaRepository<CategoryCatalog,Long> {

}
