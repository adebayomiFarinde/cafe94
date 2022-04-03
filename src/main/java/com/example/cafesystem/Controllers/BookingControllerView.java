package com.example.cafesystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * This class provides functionality to the CustomerView.fxml.
 */

public class BookingControllerView implements Initializable {

    @FXML
    Label bookingViewHelloLabel;

    @FXML
    private Stage stage;

    private Scene scene;

    private Parent root;

    /** Display customer full name.
     * @param url FXMLLoader handles this automatically.
     * @param resourceBundle FXMLLoader handles this automatically.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        bookingViewHelloLabel.setText("Hello " + MockData.getfName() + " "+ MockData.getlName() );
    }


    /** LogOut - Switch to WelcomeView.fxml.
     * @param event represents an action when LogOut Button is clicked.
     * @throws IOException There may occur an exception.
     */
    public void switchToWelcome(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("welcomeView.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }

    /** Switch to WelcomeView.fxml.
     * @param event represents an action when LogOut Button is clicked.
     * @throws IOException There may occur an exception.
     */
    public void switchToCustomerView(ActionEvent event) throws IOException {


        root = FXMLLoader.load(getClass().getResource("CustomerView.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }

    /** Switch to WelcomeView.fxml.
     * @param event represents an action when LogOut Button is clicked.
     * @throws IOException There may occur an exception.
     */
    public void switchToBookingView(ActionEvent event) throws IOException {


        root = FXMLLoader.load(getClass().getResource("BookingViewBookings.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }

    /** Switch to WelcomeView.fxml.
     * @param event  represents an action when LogOut Button is clicked.
     * @throws IOException There may occur an exception.
     */
    public void switchToNewBooking(ActionEvent event) throws IOException {


        root = FXMLLoader.load(getClass().getResource("BookingNewBooking.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }



}
