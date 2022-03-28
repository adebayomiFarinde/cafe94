package com.example.cafesystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class BookingNewBookingController {


    @FXML


    private Stage stage;

    private Scene scene;

    private Parent root;



    @FXML
    private TextField BookingNewDayText;

    @FXML
    private TextField BookingNewGuestsText;

    @FXML
    private DatePicker BookingNewTimePicker;

    public void switchToBookingView(ActionEvent event) throws IOException {


        root = FXMLLoader.load(getClass().getResource("bookingView.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }



    public void makeBooking(ActionEvent event) throws IOException {



        //call create method


        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("New Booking");
        alert.setContentText("You have booked successfully");

        if (alert.showAndWait().get() == ButtonType.OK) {
            //back to welcome
            root = FXMLLoader.load(getClass().getResource("bookingView.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }





    }



}
