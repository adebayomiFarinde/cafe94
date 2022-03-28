package com.example.cafesystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class RegisterViewController {


    @FXML
    private Stage stage;

    private Scene scene;

    private Parent root;

    //to be passed as params
    @FXML
    private TextField RegisterViewEmailText;
    @FXML
    private TextField RegisterViewFirstNameText;
    @FXML
    private TextField RegisterViewLastNameText;
    @FXML
    private TextField RegisterViewPasswordText;


    public void register(ActionEvent event) throws IOException {

        String email = RegisterViewEmailText.getText();
        String firstName = RegisterViewFirstNameText.getText();
        String lastName = RegisterViewLastNameText.getText();
        String password = RegisterViewPasswordText.getText();

        //call create method


        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Registration");
        alert.setContentText("You have registered successfully, now you can log in");

        if (alert.showAndWait().get() == ButtonType.OK) {
            //back to welcome
            root = FXMLLoader.load(getClass().getResource("welcomeView.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }


    }


    public void switchToWelcome(ActionEvent event) throws IOException {


        root = FXMLLoader.load(getClass().getResource("welcomeView.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }


}
