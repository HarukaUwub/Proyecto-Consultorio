package org.example;

public class Patient extends User {
    private String name;

    public Patient() {}

    public Patient(String identifier, String password) {
        super(identifier, password, null);
        this.name = name;
        this.setRole("Patient");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

