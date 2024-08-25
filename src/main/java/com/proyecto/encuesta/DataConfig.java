package com.proyecto.encuesta;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.proyecto.encuesta.domain.enties.CategoryCatalog;
import com.proyecto.encuesta.infrastructure.repository.categoriesCatalog.CategoryCatalogRepository;

@Configuration
public class DataConfig {

    @Autowired
    private CategoryCatalogRepository categoriesCatalogRepository;
    @Bean
    public CommandLineRunner initData() {
        return args -> {
  
       CategoryCatalog generalCategory = new CategoryCatalog();
        generalCategory.setName("General");
        categoriesCatalogRepository.save(generalCategory);

        CategoryCatalog productFeedbackCategory = new CategoryCatalog();
        productFeedbackCategory.setName("Product Feedback");
        categoriesCatalogRepository.save(productFeedbackCategory);
    // Otros repositorios...

 
        
        };
    }
}



