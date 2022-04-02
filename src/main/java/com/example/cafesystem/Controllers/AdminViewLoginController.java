package com.example.cafesystem;

import com.example.cafesystem.AdminViewController;
import com.example.cafesystem.Repository.CustomerRepository;
import com.example.cafesystem.Repository.ICustomerRepository;
import com.example.cafesystem.Repository.IStaffRepository;
import com.example.cafesystem.Repository.StaffRepository;
import com.example.cafesystem.Services.IUserService;
import com.example.cafesystem.Services.UserService;
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
import java.util.UUID;

/**
 * This class provides functionality to the AdminLoginView.fxml.
 */
public class AdminViewLoginController {
    private IUserService _userService;
    private IStaffRepository _staffRepository;
    private ICustomerRepository _customerRepository;

    /**
     * Initializes the _staffRepository, _customerRepository and _userService.
     */
    public AdminViewLoginController(){
        _staffRepository = new StaffRepository();
        _customerRepository = new CustomerRepository();
        _userService = new UserService(_customerRepository, _staffRepository);
    }

    @FXML
    TextField AdminLogInViewEmailTextField;

    @FXML
    TextField AdminLogInViewPasswordText;

    private Stage stage;

    private Scene scene;

    private Parent root;

    /** Admin Log In verification.
     * @param event  represents an action when Submit Button is clicked.
     * @throws IOException There may occur an exception.
     */
    public void login(ActionEvent event) throws IOException {

        String username = AdminLogInViewEmailTextField.getText();
        String password = AdminLogInViewPasswordText.getText();

        boolean isLoggedIn = _userService.adminLogin(username, password);

        if(isLoggedIn){

            Staff staff = _staffRepository.getStaffByEmailPassword(username, password);

            MockData.setEmail(staff.getEmail());
            MockData.setfName(staff.getfName());
            MockData.setlName(staff.getlName());
            MockData.setStaffId(staff.getId());
            MockData.setCustomerId(UUID.fromString("00000000-0000-0000-0000-000000000000"));

            FXMLLoader loader = new FXMLLoader(getClass().getResource("AdminView.fxml"));

            root = loader.load();

            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            scene = new Scene(root);

            stage.setScene(scene);

            stage.show();
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Failed Login");
            alert.setContentText("Email/Password is incorrect");

            try{
                if (alert.showAndWait().get() == ButtonType.OK) {
                    root = FXMLLoader.load(getClass().getResource("AdminLoginView.fxml"));
                    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }
            }catch (Exception ex){
                alert.close();
            }

        }
    }


    /** Switch to Welcome View.
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
