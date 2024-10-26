package com.ampalaya;


import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginUser {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button loginButton;

    @FXML
    private Button adminLoginButton;

  @FXML
   private Hyperlink createAccButton;
    
   @FXML
   private Button DriverLogin;

   @FXML
   private Label messageLabel;

    // JavaFX calls this method automatically after FXML elements are loaded
    @FXML
    public void initialize() {
        UserData.readFromTextFile(); // Load users from text file at the start
    }
    
    @FXML
    public void handleLogin(ActionEvent event) throws IOException{
        String email = usernameField.getText();
        String password = passwordField.getText();

        if (UserData.verifyLogin(email, password)) {
            messageLabel.setText("Login successful!");
            // Proceed to the next scene or functionality
            Main.changeScene("dashboard.fxml");
        } else {
            messageLabel.setText("Invalid email or password.");
        }
    }
    

    @FXML
    public void DriverLogin(ActionEvent event) throws IOException{
       
        Main.changeScene("loginDriver.fxml");
    }

    
   @FXML
    public void handleCreateAcc(ActionEvent event) throws IOException {
    Main.changeScene("userRegister.fxml");
}



}
