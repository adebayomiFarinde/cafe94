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

public class AdminAddStaffController {



    @FXML
    private TextField AdminAddStaffEmailText;

    @FXML
    private TextField AdminAddStaffFnameText;

    @FXML
    private TextField AdminAddStaffLnameText;

    @FXML
    private PasswordField AdminAddStaffPassWordText;


    private Stage stage;

    private Scene scene;

    private Parent root;

    public void switchToWelcome(ActionEvent event) throws IOException {


        root = FXMLLoader.load(getClass().getResource("AdminView.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }


    public void register(ActionEvent event) throws IOException {

        String email = AdminAddStaffEmailText.getText();
        String firstName = AdminAddStaffFnameText.getText();
        String lastName = AdminAddStaffLnameText.getText();
        String password = AdminAddStaffPassWordText.getText();

        //call create method


        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Registration");
        alert.setContentText("You have added a staff member successfully");

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
