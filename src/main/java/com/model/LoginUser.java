package com.infinityy.infinityy.model;

public class LoginUser {
    private String username;
    private String password;
    private String role; // PARENT or TEACHER

    public LoginUser(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getRole() { return role; }
}
