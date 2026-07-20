package com.techlab.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")
public class User extends EntityBase<Long> {
    @Column(unique = true)
    private String email;
    private String password;

    protected User() {
        super();
    }

    public User(Long id, String createdBy, String updatedBy, LocalDateTime createDate, LocalDateTime updateDate,
            String email,
            String password) {
        super(id, createdBy, updatedBy, createDate, updateDate);
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String usuario) {
        this.email = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
