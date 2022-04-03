package com.example.cafesystem;

import com.example.cafesystem.Repository.CustomerRepository;
import com.example.cafesystem.Repository.ICustomerRepository;
import com.example.cafesystem.Repository.IStaffRepository;
import com.example.cafesystem.Repository.StaffRepository;
import com.example.cafesystem.Services.IUserService;
import com.example.cafesystem.Services.UserService;
import com.example.cafesystem.ViewModels.CustomerViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.UUID;

/**
 * This class provides functionality to the registerView.fxml.
 */

public class RegisterViewController {
    private IUserService _userService;
    private IStaffRepository _staffRepository;
    private ICustomerRepository _customerRepository;

    /**
     * Initializes the _staffRepository, _customerRepository and _userService.
     */
    public RegisterViewController(){
        _staffRepository = new StaffRepository();
        _customerRepository = new CustomerRepository();
        _userService = new UserService(_customerRepository, _staffRepository);

    }

    @FXML
    private Stage stage;

    private Scene scene;

    private Parent root;

    //to be passed as params
    @FXML
    private TextField RegisterViewEmailText;
    @FXML
    private TextField RegisterViewFirstNameText;
    @FXML
    private TextField RegisterViewLastNameText;
    @FXML
    private TextField RegisterViewPasswordText;


    /** Customer registration.
     * @param event represents an action when Submit Button is clicked.
     * @throws IOException There may occur an exception.
     */
    public void register(ActionEvent event) throws IOException {

        String email = RegisterViewEmailText.getText();
        String firstName = RegisterViewFirstNameText.getText();
        String lastName = RegisterViewLastNameText.getText();
        String password = RegisterViewPasswordText.getText();

        UUID id = _customerRepository.createCustomer(new CustomerViewModel(null, firstName, lastName, password, "",
                email, true, false, LocalDate.now(), null));

        Alert alert = null;

        if(!id.equals(null)){
            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Registration");
            alert.setContentText("You have added new customer successfully");
        }
        else{
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Registration failed");
            alert.setContentText("Customer could not be added to the system");
        }

        if (alert.showAndWait().get() == ButtonType.OK) {
            //back to welcome
            root = FXMLLoader.load(getClass().getResource("welcomeView.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }

    }


    /** Switch to WelcomeView.fxml.
     * @param event represents an action when Back Button is clicked.
     * @throws IOException There may occur an exception.
     */
    public void switchToWelcome(ActionEvent event) throws IOException {


        root = FXMLLoader.load(getClass().getResource("welcomeView.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }


}
