package com.proyecto.encuesta.domain.entities;

// import jakarta.persistence.Column;
// import jakarta.persistence.Embedded;
// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import lombok.Getter;
// import lombok.Setter;
// @Getter
// @Setter
// @Entity
// public class Survey {
//        @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private long Id;
// private boolean enable;
//       @Embedded
//     Audit audit = new Audit();
    
//   @Column(columnDefinition = "VARCHAR(100)", nullable = false)
//     private String description;

//     @Column(columnDefinition = "VARCHAR(50)", nullable = false)
//     private String name;
// }


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
public class Survey {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column( nullable = false)
    private boolean enable=true;

    @Embedded
    private Audit audit = new Audit();

    @Column(columnDefinition = "VARCHAR(100)", nullable = false)
    private String description;

    @Column(columnDefinition = "VARCHAR(50)", nullable = false)
    private String name;

    @OneToMany(mappedBy = "survey", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore // Evita el ciclo infinito en la serialización JSON
    private Set<Chapter> chapters;
    

}