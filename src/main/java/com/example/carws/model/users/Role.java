package com.example.carws.model.users;

import jakarta.persistence.*;

@Entity
@Table
public class Role {
    @Id
    @Column
    String id;
    @Column
    String role;

    public Role() {}

    public Role(String id, String role) {
        this.setId(id);
        this.setRole(role);
    }

    public String getId() {
        return this.id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getRole() {
        return this.role;
    }
    public void setRole(String role) {
        this.role = role;
    }

    
}
