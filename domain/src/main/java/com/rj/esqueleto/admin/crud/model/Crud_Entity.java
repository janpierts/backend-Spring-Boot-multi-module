package com.rj.esqueleto.admin.crud.model;

import java.time.LocalDateTime;

public class Crud_Entity {
    private Long id;
    private String name;
    private String email;
    private LocalDateTime created;
    private LocalDateTime updated;
    private Boolean state;

    public Crud_Entity() {
    }

    public Crud_Entity( Long id, String name, String email, LocalDateTime created, LocalDateTime updated, Boolean state) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.created = created;
        this.updated = updated;
        this.state = state;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public LocalDateTime getCreated() {
        return created;
    }
    public void setCreated(LocalDateTime created) {
        this.created = created;
    }
    public LocalDateTime getUpdated() {
        return updated;
    }
    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }
    public Boolean getState() {
        return state;
    }
    public void setState(Boolean state) {
        this.state = state;
    }
}
