package com.proyecto.encuesta.domain.entities;


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
    private Survey survey;
    @Embedded
    Audit audit = new Audit();

    @Column(columnDefinition = "VARCHAR(50)", nullable = false)
    private String chapter_number;

    @Column(columnDefinition = "VARCHAR(50)", nullable = false)
    private String chapter_title;

    public Chapter() {
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public Survey getSurvey() {
        return survey;
    }

    public void setSurvey(Survey survey) {
        this.survey = survey;
    }

    public Audit getAudit() {
        return audit;
    }

    public void setAudit(Audit audit) {
        this.audit = audit;
    }

    public String getChapter_number() {
        return chapter_number;
    }

    public void setChapter_number(String chapter_number) {
        this.chapter_number = chapter_number;
    }

    public String getChapter_title() {
        return chapter_title;
    }

    public void setChapter_title(String chapter_title) {
        this.chapter_title = chapter_title;
    }


}
