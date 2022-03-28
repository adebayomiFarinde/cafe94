package com.example.cafesystem;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {


       try
       {
            //create root Node
           Parent root =  FXMLLoader.load(getClass().getResource("welcomeView.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();


       } catch(Exception e)
       {
           e.printStackTrace();
       }




    }

    public static void main(String[] args) {
        launch();
    }
}