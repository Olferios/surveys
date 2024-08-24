package com.proyecto.encuesta.domain.enties;


import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Chapter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    @ManyToOne
    @JoinColumn(name = "survey_id")
    private Survey id;
    @Embedded
    Audit audit = new Audit();

    @Column(columnDefinition = "VARCHAR(50)", nullable = false)
    private String chapter_number;

    @Column(columnDefinition = "VARCHAR(50)", nullable = false)
    private String chapter_title;


}
