package com.example.cafesystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * This class provides functionality to the welcomeView.fxml.
 */
public class WelcomeController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    /** Switch to AdminLogInView.fxml.
     * @param event represents an action when Admin Login Button is clicked.
     * @throws IOException There may occur an exception.
     */
    public void switchToAdminLogin(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("AdminLogInView.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /** Switch to CustomerLogInView.fxml.
     * @param event represents an action when Customer Login Button is clicked.
     * @throws IOException There may occur an exception.
     */
    public void switchToCustomerLogin(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("CustomerLogInView.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /** Switch to registerView.fxml.
     * @param event represents an action when Register Button is clicked.
     * @throws IOException There may occur an exception.
     */
    public void switchToRegister(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("registerView.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
