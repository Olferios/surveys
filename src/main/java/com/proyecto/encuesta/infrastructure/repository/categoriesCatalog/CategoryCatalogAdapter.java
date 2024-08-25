package com.proyecto.encuesta.infrastructure.repository.categoriesCatalog;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.proyecto.encuesta.aplication.service.categoriesCatalog.ICategoryCatalog;
import com.proyecto.encuesta.domain.entities.Audit;
import com.proyecto.encuesta.domain.entities.CategoryCatalog;

@Service
public class CategoryCatalogAdapter implements ICategoryCatalog {

    @Autowired
    private CategoryCatalogRepository categoryCatalogRepository;

    @Override
    public Optional<CategoryCatalog> findById(Long id) {
        return categoryCatalogRepository.findById(id);
    }

    @Override
    public List<CategoryCatalog> getAll() {
        return categoryCatalogRepository.findAll();
    }

    @Override
    public CategoryCatalog save(CategoryCatalog categoryCatalog) {
        return categoryCatalogRepository.save(categoryCatalog);
    }

    @Override
    public CategoryCatalog update(Long id, CategoryCatalog categoryCatalog) {
        return categoryCatalogRepository.findById(id)
            .map(existingCategory -> {
                // Mantener el createdAt existente
                existingCategory.setName(categoryCatalog.getName());

                // Actualizar el campo updatedAt en el audit
                Audit audit = existingCategory.getAudit();
                audit.setUpdatedAt(LocalDateTime.now());
                existingCategory.setAudit(audit);

                return categoryCatalogRepository.save(existingCategory);
            })
            .orElse(null); // O manejar el caso en que la categoría no existe
    }

    @Override
    public void deleteById(Long id) {
        categoryCatalogRepository.deleteById(id);
    }


}