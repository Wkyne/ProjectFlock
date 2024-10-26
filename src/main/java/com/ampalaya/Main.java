package com.ampalaya;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    private static Stage stg;

    @Override
    public void start(Stage primaryStage) throws Exception{
        stg = primaryStage;
        primaryStage.setResizable(false);
        Parent root = FXMLLoader.load(getClass().getResource("Mainn.fxml"));
        primaryStage.setTitle("Flock Carpool App");
        primaryStage.setScene(new Scene(root, 300, 500));
        primaryStage.show();
    }

    

    public static void changeScene(String fxml) throws IOException {
        Parent pane = FXMLLoader.load(Main.class.getResource(fxml));
        stg.getScene().setRoot(pane);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
  