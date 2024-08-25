package com.proyecto.encuesta.domain.enties;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
public class UserRol {
    @EmbeddedId
    private UserRolpk id;

    @ManyToOne
    @JoinColumn(name = "role_id", insertable = false, updatable = false)
    private Rol rol;
    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;

}
