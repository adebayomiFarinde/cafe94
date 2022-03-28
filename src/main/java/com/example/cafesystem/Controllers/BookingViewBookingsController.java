package com.example.cafesystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class BookingViewBookingsController implements Initializable {

    @FXML

    private Stage stage;

    private Scene scene;

    private Parent root;

    @FXML
    private ListView<String> BookingViewBookingsList;

    String []  booking = {"Monday","Tuesday","Sunday"};

    String currentStaff;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        BookingViewBookingsList.getItems().addAll(booking);


    }

    public void switchToBookingView(ActionEvent event) throws IOException {


        root = FXMLLoader.load(getClass().getResource("bookingView.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }
}
