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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminViewLoginController {
    private IUserService _userService;
    private IStaffRepository _staffRepository;
    private ICustomerRepository _customerRepository;
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


    public void login(ActionEvent event) throws IOException {

        String username = AdminLogInViewEmailTextField.getText();
        String password = AdminLogInViewPasswordText.getText();

        boolean isLoggedIn = _userService.adminLogin(username, password);

        if(isLoggedIn){

            Staff staff = _staffRepository.getStaffByEmailPassword(username, password);

            FXMLLoader loader = new FXMLLoader(getClass().getResource("AdminView.fxml"));

            root = loader.load();


            AdminViewController adminViewController = loader.getController();

            adminViewController.displayName(staff.getfName());


            //root = FXMLLoader.load(getClass().getResource("Scene2.fxml"));

            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            scene = new Scene(root);

            stage.setScene(scene);

            stage.show();

            return;
        }
    }


    public void switchToWelcome(ActionEvent event) throws IOException {


        root = FXMLLoader.load(getClass().getResource("welcomeView.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }


}
