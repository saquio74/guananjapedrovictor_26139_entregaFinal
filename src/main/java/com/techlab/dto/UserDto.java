package com.techlab.dto;


public class UserDto {
    private Long Id;
    private String email;
    private String password;
    public UserDto(Long id, String email, String password) {
        Id = id;
        this.email = email;
        this.password = password;
    }
    public Long getId() {
        return Id;
    }
    public void setId(Long id) {
        Id = id;
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
