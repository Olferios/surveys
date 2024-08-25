package com.proyecto.encuesta.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
public class ResponseQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    @ManyToOne
    @JoinColumn(name = "response_id")
    private ResponseOption responseOption;
    @ManyToOne
    @JoinColumn(name = "subresponseos_id")
    private SubresponseOption subresponseOption;

    @Column(columnDefinition = "VARCHAR(80)", nullable = false)
    private String responsetext;
}
