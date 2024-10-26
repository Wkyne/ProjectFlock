package com.ampalaya;

public class Driver {
    private String firstName;
    private String lastName;
    private String email;
    private String licenseNumber;
    private String password;

    public Driver(String firstName, String lastName, String email, String licenseNumber, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.licenseNumber = licenseNumber;
        this.password = password;
    }

    // Getters
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public String getPassword() {
        return password;
    }

    // Override toString method
    @Override
    public String toString() {
        return firstName + "|" + lastName + "|" + email + "|" + licenseNumber + "|" + password;
    }
}

