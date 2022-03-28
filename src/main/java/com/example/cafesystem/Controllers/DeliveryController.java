package com.example.cafesystem;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DeliveryController implements Initializable {


    @FXML

    private TextField addressText;

    @FXML
    private ListView<String> foodListViewDelivery;

    @FXML
    private Label showOrderLabelDelivery;

    String[] food = {"Big Mac", "Stake", "Chicken Fillet"};

    String currentFood;


    private Stage stage;

    private Scene scene;

    private Parent root;

    public void switchToCustomerView(ActionEvent event) throws IOException {

        root = FXMLLoader.load(getClass().getResource("CustomerView.fxml"));
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


    public void makeOrderDelivery(ActionEvent event) throws IOException {


        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("TakeAway Order");
        alert.setContentText("Your order will be delivered to " + addressText.getText());

        if (alert.showAndWait().get() == ButtonType.OK) {
            //back to welcome
            root = FXMLLoader.load(getClass().getResource("customerView.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }


    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        foodListViewDelivery.getItems().addAll(food);


        foodListViewDelivery.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {


            @Override

            public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {


                currentFood = foodListViewDelivery.getSelectionModel().getSelectedItem();


                showOrderLabelDelivery.setText("Current choice " + currentFood);


            }

        });


    }
}
