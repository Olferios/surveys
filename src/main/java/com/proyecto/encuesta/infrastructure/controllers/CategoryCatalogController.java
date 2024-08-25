package com.proyecto.encuesta.infrastructure.controllers;

import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.encuesta.aplication.service.categoriesCatalog.ICategoryCatalog;
import com.proyecto.encuesta.domain.entities.*;

@RestController
@RequestMapping("/api/category")
public class CategoryCatalogController {
    @Autowired
    private ICategoryCatalog ICategoryCatalog;

    @GetMapping
    public List<CategoryCatalog> list() {
        return ICategoryCatalog.getAll();
    }

    @GetMapping("/{id}")
    public Optional<CategoryCatalog> show(@PathVariable Long id) {
        return ICategoryCatalog.findById(id);

    }

    @PostMapping
    public ResponseEntity<CategoryCatalog> crearCategory(@RequestBody CategoryCatalog categoryCatalog) {

        ICategoryCatalog.save(categoryCatalog);
        return new ResponseEntity<>(categoryCatalog, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")

    public ResponseEntity<CategoryCatalog> actualizarCategory(@PathVariable Long id,
            @RequestBody CategoryCatalog categoryCatalog) {

        CategoryCatalog categoryUser = ICategoryCatalog.update(id, categoryCatalog);
        return new ResponseEntity<>(categoryUser, HttpStatus.OK);
    };

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        if (ICategoryCatalog.findById(id).isPresent()) {
            ICategoryCatalog.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
