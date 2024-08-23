package com.proyecto.encuesta.infrastructure.repository.usersRoles;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.encuesta.domain.enties.CategoryCatalog;

public interface UserRolesRepository extends JpaRepository<CategoryCatalog,Long> {

}
