package com.example.cafesystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminAddMenuController {

    @FXML

    private Stage stage;

    private Scene scene;

    private Parent root;

    @FXML
    private TextField AdminAddMenuItemText;

    @FXML
    private TextField AdminAddMenuText;


    public void switchToAdminView(ActionEvent event) throws IOException {


        root = FXMLLoader.load(getClass().getResource("AdminView.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }

    public void addMenu(ActionEvent event) throws IOException {



        //call create method


        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Add menu");
        alert.setContentText("You have added a menu Item successfully");

        if (alert.showAndWait().get() == ButtonType.OK) {
            //back to welcome
            root = FXMLLoader.load(getClass().getResource("AdminView.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }





    }

}
