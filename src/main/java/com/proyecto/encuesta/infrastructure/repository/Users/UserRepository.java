package com.proyecto.encuesta.infrastructure.repository.Users;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.encuesta.domain.enties.CategoryCatalog;

public interface UserRepository extends JpaRepository<CategoryCatalog,Long> {

}
