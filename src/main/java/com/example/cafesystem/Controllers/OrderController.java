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

public class OrderController  implements Initializable {

    @FXML
    private ListView<String> foodListView;

    @FXML
    private Label orderViewLabel;

    String[] food = {"Big Mac","Stake","Chicken Fillet"};

    String currentFood;

    @FXML
    private TextField timeText;

    @FXML
    private Label showOrderLabel;

    private Stage stage;

    private Scene scene;

    private Parent root;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        foodListView.getItems().addAll(food);



        foodListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {



            @Override

            public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {



                currentFood = foodListView.getSelectionModel().getSelectedItem();



                showOrderLabel.setText("Current choice " + currentFood);



            }

        });



    }




    public void switchToCustomerView (ActionEvent event) throws IOException {

        root = FXMLLoader.load(getClass().getResource("CustomerView.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void switchToWelcome (ActionEvent event) throws IOException {

        root = FXMLLoader.load(getClass().getResource("welcomeView.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }



    public void makeOrder(ActionEvent event) throws IOException {



        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("TakeAway Order");
        alert.setContentText("Your order will be ready by " + timeText.getText());

        if(alert.showAndWait().get() == ButtonType.OK)
        {
            //back to welcome
            root = FXMLLoader.load(getClass().getResource("customerView.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }


    }



}
