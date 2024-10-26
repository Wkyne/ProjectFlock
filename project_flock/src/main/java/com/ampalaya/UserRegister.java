package com.ampalaya;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import com.ampalaya.UserData;

public class UserRegister {

    public UserRegister() {

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
    private TextField studno;

    @FXML
    private Label logmes;


    @FXML
    public void userLogIn(ActionEvent event) throws IOException {
        //checkLogin();
        Main.changeScene("login.fxml");

    }

    @FXML
    public void Register() throws IOException {
        // Check if all fields are filled
        if (!Fname.getText().isBlank() && !pass.getText().isBlank() && !email.getText().isBlank() &&
            !Lname.getText().isBlank() && !studno.getText().isBlank()) {

            // Create a new User instance with form data
            String firstName = Fname.getText();
            String lastName = Lname.getText();
            String userEmail = email.getText();
            String studentNumber = studno.getText();
            String password = pass.getText();

            // Check if the user already exists by email
            if (UserData.checkUser(userEmail) == null) {
                User newUser = new User(firstName, lastName, userEmail, studentNumber, password);

                // Add user to list and save to file
                UserData.users.add(newUser);
                UserData.writeToTextFile();

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

