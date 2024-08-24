package com.proyecto.encuesta.domain.enties;

import jakarta.persistence.Embeddable;

@Embeddable
public class UserRolpk implements Serializable {
    private Long role_id;
    private Long user_id;

    
    public UserRolpk() {
    }
    public Long getRole_id() {
        return role_id;
    }
    public void setRole_id(Long role_id) {
        this.role_id = role_id;
    }
    public Long getUser_id() {
        return user_id;
    }
    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    
}
