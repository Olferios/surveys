package com.proyecto.encuesta.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
public class Survey {
       @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

      @Embedded
    Audit audit = new Audit();
    
  @Column(columnDefinition = "VARCHAR(50)", nullable = false)
    private String description;

    @Column(columnDefinition = "VARCHAR(50)", nullable = false)
    private String name;
}
