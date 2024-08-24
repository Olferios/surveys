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

public class Question {
 @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
  @ManyToOne
    @JoinColumn(name = "chapter_id")
    private Chapter chapter;

    @Embedded
    Audit audit = new Audit();

    @Column(columnDefinition = "VARCHAR(10)", nullable = false)
    private String question_number;

    @Column(columnDefinition = "VARCHAR(20)", nullable = false)
    private String response_type;
    @Column(columnDefinition = "TEXT", nullable = false)
    private String comment_question;
    @Column(columnDefinition = "TEXT", nullable = false)
    private String question_text;
}
