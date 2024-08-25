package com.proyecto.encuesta.aplication.service.categoriesCatalog;
import java.util.Optional;
import java.util.List;
import com.proyecto.encuesta.domain.enties.*;
public interface ICategoryCatalog {
    Optional<CategoryCatalog> findById(Long id);
    List<CategoryCatalog> getAll();
    CategoryCatalog save(CategoryCatalog categoryCatalog);
    CategoryCatalog update(Long id,CategoryCatalog categoryCatalog);
    void deleteById(Long id); 
}
