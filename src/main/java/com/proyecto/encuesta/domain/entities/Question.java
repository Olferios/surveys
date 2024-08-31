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

    
    public Question() {
    }
    public long getId() {
      return Id;
    }
    public void setId(long id) {
      Id = id;
    }
    public Chapter getChapter() {
      return chapter;
    }
    public void setChapter(Chapter chapter) {
      this.chapter = chapter;
    }
    public Audit getAudit() {
      return audit;
    }
    public void setAudit(Audit audit) {
      this.audit = audit;
    }
    public String getQuestion_number() {
      return question_number;
    }
    public void setQuestion_number(String question_number) {
      this.question_number = question_number;
    }
    public String getResponse_type() {
      return response_type;
    }
    public void setResponse_type(String response_type) {
      this.response_type = response_type;
    }
    public String getComment_question() {
      return comment_question;
    }
    public void setComment_question(String comment_question) {
      this.comment_question = comment_question;
    }
    public String getQuestion_text() {
      return question_text;
    }
    public void setQuestion_text(String question_text) {
      this.question_text = question_text;
    }

    
}
