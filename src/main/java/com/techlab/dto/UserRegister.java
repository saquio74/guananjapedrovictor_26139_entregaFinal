package com.techlab.dto;

public class UserRegister {
    private String email;
    private String password;

    public UserRegister( String email, String password) {
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
