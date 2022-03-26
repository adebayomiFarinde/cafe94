package com.example.cafesystem;

import com.example.cafesystem.Repository.CustomerRepository;
import com.example.cafesystem.Repository.ICustomerRepository;
import com.example.cafesystem.Repository.IStaffRepository;
import com.example.cafesystem.Repository.StaffRepository;
import com.example.cafesystem.Services.IUserService;
import com.example.cafesystem.Services.UserService;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.UUID;

public class HelloController {
    private IUserService _userService;
    private IStaffRepository _staffRepository;
    private ICustomerRepository _customerRepository;
    public HelloController(){
        _staffRepository = new StaffRepository();
        _customerRepository = new CustomerRepository();
        _userService = new UserService(_customerRepository, _staffRepository);
    }

    @FXML
    private Label welcomeText;

    @FXML
    protected void onCreateCustomerButtonClick() {
        UUID id = _userService.createCustomer("Adebayomi", "Farinde", "checkschool@example.com");

        welcomeText.setText("New User with id " + id + " created" );
    }
}