package com.example.cafesystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminStaffController implements Initializable {

    @FXML
    private Stage stage;

    private Scene scene;

    private Parent root;

    @FXML
    private Label AdminStaffViewLabel;

    @FXML
    private ListView<String> AdminStaffViewList;

    String []  staff = {"John","Joe","Dave","Rom"};

    String currentStaff;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        AdminStaffViewList.getItems().addAll(staff);


    }


    public void switchAdminView(ActionEvent event) throws IOException {


        root = FXMLLoader.load(getClass().getResource("AdminView.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }
}