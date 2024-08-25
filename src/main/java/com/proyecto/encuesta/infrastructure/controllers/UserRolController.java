package com.proyecto.encuesta.infrastructure.controllers;

import com.proyecto.encuesta.domain.entities.UserRol;
import com.proyecto.encuesta.domain.entities.UserRolpk;
import com.proyecto.encuesta.aplication.service.userRol.IUserRolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/userRol")
public class UserRolController {

    @Autowired
    private IUserRolService userRolService;

    @GetMapping
    public ResponseEntity<List<UserRol>> list() {
        List<UserRol> userRoles = userRolService.getAll();
        return new ResponseEntity<>(userRoles, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserRol> show(@PathVariable UserRolpk userRolpk) {
        return userRolService.findById(userRolpk)
                .map(userRol -> new ResponseEntity<>(userRol, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<UserRol> create(@RequestBody UserRol userRol) {
        UserRol createdUserRol = userRolService.save(userRol);
        return new ResponseEntity<>(createdUserRol, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserRol> update(@PathVariable UserRolpk userRolpk, @RequestBody UserRol userRol) {
        UserRol updatedUserRol = userRolService.update(userRolpk, userRol);
        if (updatedUserRol != null) {
            return new ResponseEntity<>(updatedUserRol, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{userRolpk}")
    public ResponseEntity<Void> delete(@PathVariable UserRolpk userRolpk) {
        if (userRolService.findById( userRolpk).isPresent()) {
            userRolService.deleteById(userRolpk);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
