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
public class SubresponseOption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    private int subresponse_number;
    @Embedded
    Audit audit = new Audit();
     @ManyToOne
    @JoinColumn(name = "responseoption_id")
    private ResponseOption responseOption ;
    
    @Column(columnDefinition = "VARCHAR(255)", nullable = false)
    private String component_html;
    
    @Column(columnDefinition = "VARCHAR(255)", nullable = false)
    private String subresponse_text;
}
