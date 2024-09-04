package com.proyecto.encuesta.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
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
public class SubQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
 @Embedded
    private Audit audit = new Audit();
    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    @Column(columnDefinition = "VARCHAR(80)", nullable = false)
    private String responsetext;
}
