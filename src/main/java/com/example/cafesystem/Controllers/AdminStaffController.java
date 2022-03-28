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
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class AdminStaffController implements Initializable {

    private IUserService _userService;
    private IStaffRepository _staffRepository;
    private ICustomerRepository _customerRepository;
    public AdminStaffController(){
        _staffRepository = new StaffRepository();
        _customerRepository = new CustomerRepository();
        _userService = new UserService(_customerRepository, _staffRepository);

    }
    @FXML
    private Stage stage;

    private Scene scene;

    private Parent root;

    @FXML
    private Label AdminStaffViewLabel;

    @FXML
    private ListView<String> AdminStaffViewList;

    String currentStaff;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        List<Staff> staff = MockData.getStaff();

        ArrayList<String> staffNames = new ArrayList<>();
        staff.forEach(x -> staffNames.add(x.getfName() +  " " +  x.getlName()) );

        AdminStaffViewList.getItems().addAll(staffNames);
    }


    public void switchAdminView(ActionEvent event) throws IOException {


        root = FXMLLoader.load(getClass().getResource("AdminView.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }
}