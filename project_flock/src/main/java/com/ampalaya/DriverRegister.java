package com.ampalaya;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class DriverRegister {

    public DriverRegister() {

    }

    @FXML
    private Button logbtn;
 
    @FXML
    private Button Regbtn;

    @FXML
    private TextField Fname;

    @FXML
    private TextField Lname;

    @FXML
    private TextField email;

    @FXML
    private PasswordField pass;

    @FXML
    private TextField licenseno;

    @FXML
    private Label logmes;


    @FXML
    public void userLogIn(ActionEvent event) throws IOException {
        //checkLogin();
        Main.changeScene("loginDriver.fxml");

    }

    @FXML
    public void Register() throws IOException{
        if (!Fname.getText().isBlank() && !pass.getText().isBlank() && !email.getText().isBlank() &&
        !Lname.getText().isBlank() && !licenseno.getText().isBlank()) {

        // Create a new User instance with form data
        String firstName = Fname.getText();
        String lastName = Lname.getText();
        String userEmail = email.getText();
        String licenseNumber = licenseno.getText();
        String password = pass.getText();

        // Check if the user already exists by email
        if (DriverData.checkDriver(userEmail) == null) {
            Driver newDriver = new Driver(firstName, lastName, userEmail, licenseNumber, password);

            // Add user to list and save to file
            DriverData.drivers.add(newDriver);
            DriverData.writeToTextFile();

            // Update message
            logmes.setText("Register Successful!");
        } else {
            logmes.setText("User already exists!");
        }

    } else {
        logmes.setText("Please Enter the required Information");
    }
    }

    }

