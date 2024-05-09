package org.example;

public class User {
    private String identifier;
    private String password;
    private String role;

    public User() {}

    public User(String identifier, String password) {
        this.identifier = identifier;
        this.password = password;
    }

    public User(String identifier, String password, String name) {
    }

    public String getRole() {
        return role;
    }

    public void setRole(String identifier) {
        this.identifier = identifier;
    }
    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

