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
public class ResponseOption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    @Column(columnDefinition = "VARCHAR(10)", nullable = false)
    private String option_value;

    @ManyToOne
    @JoinColumn(name = "Categorycatalog_id")
    private CategoryCatalog categoryCatalog;

    @Embedded
    Audit audit = new Audit();

    @ManyToOne
    @JoinColumn(name = "parentresponse_id")
    private ResponseOption responseOption ;
    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question ;
    @Column(columnDefinition = "VARCHAR(30)", nullable = false)
    private String typecomponenthtml;
    @Column(columnDefinition = "TEXT", nullable = false)
    private String comment_response;
    
    @Column(columnDefinition = "TEXT", nullable = false)
    private String option_text;
}
