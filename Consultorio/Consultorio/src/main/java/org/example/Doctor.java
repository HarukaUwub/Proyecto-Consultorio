package org.example;

public class Doctor extends User {
    private String name;
    private String specialty;

    public Doctor() {}

    public Doctor(String identifier, String password, String name, String specialty) {
        super(identifier, password,specialty);
        this.name = name;
        this.specialty = specialty;
        this.setRole("Doctor");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }
}

