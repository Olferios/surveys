package com.proyecto.encuesta.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "option_question")
public class OptionQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    private int subresponse_number;
    @Embedded
    Audit audit = new Audit();
     @ManyToOne
    @JoinColumn(name = "subquestion_id")
    private SubQuestion subQuestion ;
    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question ;
    @ManyToOne
    @JoinColumn(name = "option_id")
    private Options options ;
    
}
