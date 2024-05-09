package org.example;

public class Administrator extends User {
    public Administrator() {}

    public Administrator(String identifier, String password) {
        super(identifier, password);
        this.setRole("Administrator");
    }
}

