package com.example.cafesystem;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

//controller, makes possible the interaction between view and model
public class Main extends Application {

    /**The main entry point for all JavaFX applications.
     * @param stage The stage.
     * @throws IOException Throws an exception which has to be caught if it occurs.
     */
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

    /**
     * Main Method which launches the application.
     * @param args Arguments passed by the command line.
     */
    public static void main(String[] args) {
        launch();
    }
}