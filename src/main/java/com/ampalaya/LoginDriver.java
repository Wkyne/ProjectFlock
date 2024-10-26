package com.ampalaya;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginDriver {


    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Hyperlink createaccdriver;

    @FXML
    private Button userLoginButton;

    @FXML
    private Button LoginDriver;

    @FXML
    private Label logdrivmes;


    @FXML
    public void initialize() {
        DriverData.readFromTextFile(); // Load users from text file at the start
    }

    @FXML
    public void handleAdminLogin(ActionEvent event) throws IOException{
        String email = usernameField.getText();
        String password = passwordField.getText();

        if (DriverData.verifyLogin(email, password)) {
            logdrivmes.setText("Login successful!");
            // Proceed to the next scene or functionality
            Main.changeScene("dashboard.fxml");
        } else {
            logdrivmes.setText("Invalid email or password.");
        }
    }


    @FXML
    public void handleBacktoUserLogin(ActionEvent event) throws IOException {
        Main.changeScene("login.fxml");
    }

    @FXML
    public void createaccdriverButton(ActionEvent event) throws IOException {
        Main.changeScene("driverRegister.fxml");
    }


    
}
