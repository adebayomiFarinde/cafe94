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
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * This class provides functionality to the CustomerView.fxml.
 */
public class CustomerViewController  implements Initializable {

    @FXML
    Label CustomerViewHelloLabel;

    private Stage stage;

    private Scene scene;

    private Parent root;

    /** Change Customer display Label to "Hello " + customerName.
     * @param url FXMLLoader handles this automatically.
     * @param resourceBundle FXMLLoader handles this automatically.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        CustomerViewHelloLabel.setText("Hello " + MockData.getfName() + " "+ MockData.getlName() );
    }


    /** Customer logs out, switch back to welcomeView.fxml.
     * @param event represents an action when Logout Button is clicked.
     * @throws IOException There may occur an exception.
     */
    public void logOut(ActionEvent event) throws IOException {


        root = FXMLLoader.load(getClass().getResource("welcomeView.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }

    /** Switch to bookingView.fxml.
     * @param event represents an action when Booking Button is clicked.
     * @throws IOException There may occur an exception.
     */
    public void switchToBookingView (ActionEvent event) throws IOException {

        root = FXMLLoader.load(getClass().getResource("bookingView.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }


    /** Switch to orderView.fxml.
     * @param event represents an action when Takeaway Button is clicked.
     * @throws IOException There may occur an exception.
     */
    public void switchToTakeAway (ActionEvent event) throws IOException {

        root = FXMLLoader.load(getClass().getResource("orderView.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    /** Switch to deliveryView.fxml.
     * @param event  represents an action when Delivery Button is clicked.
     * @throws IOException There may occur an exception.
     */
    public void switchToDelivery (ActionEvent event) throws IOException {

        root = FXMLLoader.load(getClass().getResource("deliveryView.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }



}
