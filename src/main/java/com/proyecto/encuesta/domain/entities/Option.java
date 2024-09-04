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
public class Option {

        @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
  @Embedded
    private Audit audit = new Audit();

    @Column(columnDefinition = "VARCHAR(10)", nullable = false)
    private String optiontext;
}
