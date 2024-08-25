package com.proyecto.encuesta.domain.enties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    @Column(columnDefinition = "BOOL", nullable = false)
    private boolean enable;
    @Column(columnDefinition = "VARCHAR(12)", nullable = false)
    private String username;
    
    @Column(columnDefinition = "VARCHAR(255)", nullable = false)
    private String password;
}
