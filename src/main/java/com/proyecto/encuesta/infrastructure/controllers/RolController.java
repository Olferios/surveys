package com.proyecto.encuesta.infrastructure.controllers;

import com.proyecto.encuesta.domain.entities.Rol;
import com.proyecto.encuesta.aplication.service.rol.IRolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/rol")
public class RolController {

    @Autowired
    private IRolService rolService;

    @GetMapping
    public ResponseEntity<List<Rol>> list() {
        List<Rol> roles = rolService.getAll();
        return new ResponseEntity<>(roles, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rol> show(@PathVariable Long id) {
        return rolService.findById(id)
                .map(rol -> new ResponseEntity<>(rol, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Rol> create(@RequestBody Rol rol) {
        Rol createdRol = rolService.save(rol);
        return new ResponseEntity<>(createdRol, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Rol> update(@PathVariable Long id, @RequestBody Rol rol) {
        Rol updatedRol = rolService.update(id, rol);
        if (updatedRol != null) {
            return new ResponseEntity<>(updatedRol, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (rolService.findById(id).isPresent()) {
            rolService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
