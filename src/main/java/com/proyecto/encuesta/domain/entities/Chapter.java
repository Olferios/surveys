package com.proyecto.encuesta.domain.entities;


// import jakarta.persistence.Column;
// import jakarta.persistence.Embedded;
// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.JoinColumn;
// import jakarta.persistence.ManyToOne;
// import lombok.Getter;
// import lombok.Setter;
// @Getter
// @Setter
// @Entity
// public class Chapter {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private long Id;
//     @ManyToOne
//     @JoinColumn(name = "survey_id")
//     private Survey survey;
//     @Embedded
//     Audit audit = new Audit();

//     @Column(columnDefinition = "VARCHAR(50)", nullable = false)
//     private String chapter_number;

//     @Column(columnDefinition = "VARCHAR(50)", nullable = false)
//     private String chapter_title;

   

// }
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
public class Chapter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "survey_id")
    private Survey survey;

    @Embedded
    private Audit audit = new Audit();

    @Column(columnDefinition = "VARCHAR(50)", nullable = false)
    private String chapter_number;

    @Column(columnDefinition = "VARCHAR(50)", nullable = false)
    private String chapter_title;
    
    @OneToMany(mappedBy = "chapter", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private Set<Question> questions;
}