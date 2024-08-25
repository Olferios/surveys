package com.proyecto.encuesta.aplication.service.categoriesCatalog;
import java.util.Optional;

import com.proyecto.encuesta.domain.entities.*;

import java.util.List;
public interface ICategoryCatalog {
    Optional<CategoryCatalog> findById(Long id);
    List<CategoryCatalog> getAll();
    CategoryCatalog save(CategoryCatalog categoryCatalog);
    CategoryCatalog update(Long id,CategoryCatalog categoryCatalog);
    void deleteById(Long id); 
 
}
