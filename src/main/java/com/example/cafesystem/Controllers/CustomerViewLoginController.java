package com.example.cafesystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class CustomerViewLoginController {

    @FXML

    TextField CustomerLoginVIewEmailText;


    private Stage stage;

    private Scene scene;

    private Parent root;


    public void login(ActionEvent event) throws IOException {


        String username = CustomerLoginVIewEmailText.getText();


        FXMLLoader loader = new FXMLLoader(getClass().getResource("CustomerView.fxml"));

        root = loader.load();


        CustomerViewController customerViewController = loader.getController();

        customerViewController.displayName(username);


        //root = FXMLLoader.load(getClass().getResource("Scene2.fxml"));

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        scene = new Scene(root);

        stage.setScene(scene);

        stage.show();


    }


    public void switchToWelcome(ActionEvent event) throws IOException {


        root = FXMLLoader.load(getClass().getResource("welcomeView.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }


}
