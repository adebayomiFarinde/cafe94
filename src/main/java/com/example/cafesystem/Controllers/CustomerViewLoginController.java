package com.example.cafesystem;

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
import java.util.UUID;

public class CustomerViewLoginController {
        private IUserService _userService;
        private IStaffRepository _staffRepository;
        private ICustomerRepository _customerRepository;
        public CustomerViewLoginController(){
            _staffRepository = new StaffRepository();
            _customerRepository = new CustomerRepository();
            _userService = new UserService(_customerRepository, _staffRepository);

        }

    @FXML
    TextField CustomerLoginVIewEmailText;
    @FXML
    TextField CustomerLoginVIewPasswordText;

    private Stage stage;

    private Scene scene;

    private Parent root;

    public void login(ActionEvent event) throws IOException {

        String username = CustomerLoginVIewEmailText.getText();
        String password = CustomerLoginVIewPasswordText.getText();
        boolean isLoggedIn = _userService.customerLogin(username, password);

        if(isLoggedIn){

            Customer customer = _customerRepository.getCustomerByEmailPassword(username, password);

            MockData.setEmail(customer.getEmail());
            MockData.setfName(customer.getfName());
            MockData.setlName(customer.getlName());
            MockData.setCustomerId(customer.getId());
            MockData.setStaffId(UUID.fromString("00000000-0000-0000-0000-000000000000"));


            FXMLLoader loader = new FXMLLoader(getClass().getResource("CustomerView.fxml"));

            root = loader.load();

            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            scene = new Scene(root);

            stage.setScene(scene);

            stage.show();
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
