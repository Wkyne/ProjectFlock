package com.ampalaya;

public class User {
    private String firstName;
    private String lastName;
    private String email;
    private String studentNumber;
    private String password;

    // Constructor
    public User(String firstName, String lastName, String email, String studentNumber, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.studentNumber = studentNumber;
        this.password = password;
    }

    // Getters and Setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    // To String for saving to text file
    @Override
    public String toString() {
        return firstName + "|" + lastName + "|" + email + "|" + studentNumber + "|" + password;
    }
}

