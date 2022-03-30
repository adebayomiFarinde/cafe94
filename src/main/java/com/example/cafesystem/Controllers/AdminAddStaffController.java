package com.example.cafesystem;

import com.example.cafesystem.Repository.CustomerRepository;
import com.example.cafesystem.Repository.ICustomerRepository;
import com.example.cafesystem.Repository.IStaffRepository;
import com.example.cafesystem.Repository.StaffRepository;
import com.example.cafesystem.Services.IUserService;
import com.example.cafesystem.Services.UserService;
import com.example.cafesystem.ViewModels.Enum.Portfolio;
import com.example.cafesystem.ViewModels.StaffViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.UUID;

public class AdminAddStaffController {

    private IUserService _userService;
    private IStaffRepository _staffRepository;
    private ICustomerRepository _customerRepository;
    public AdminAddStaffController(){
        _staffRepository = new StaffRepository();
        _customerRepository = new CustomerRepository();
        _userService = new UserService(_customerRepository, _staffRepository);

    }

    @FXML
    private TextField AdminAddStaffEmailText;

    @FXML
    private TextField AdminAddStaffFnameText;

    @FXML
    private TextField AdminAddStaffLnameText;

    @FXML
    private PasswordField AdminAddStaffPassWordText;


    private Stage stage;

    private Scene scene;

    private Parent root;

    public void switchToWelcome(ActionEvent event) throws IOException {

        root = FXMLLoader.load(getClass().getResource("AdminView.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }


    public void register(ActionEvent event) throws IOException {

        String email = AdminAddStaffEmailText.getText();
        String firstName = AdminAddStaffFnameText.getText();
        String lastName = AdminAddStaffLnameText.getText();
        String password = AdminAddStaffPassWordText.getText();

        UUID id = _staffRepository.createStaff(new StaffViewModel(null, firstName,
                lastName, password, "", Portfolio.Driver, email, true,
                false, LocalDate.now(), null));

        Alert alert = null;

        if(!id.equals(null)){
            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Registration");
            alert.setContentText("You have added a staff member successfully");
        }
        else{
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Registration failed");
            alert.setContentText("Staff could not be added to the system");
        }

        if (alert.showAndWait().get() == ButtonType.OK) {
            //back to welcome
            root = FXMLLoader.load(getClass().getResource("AdminView.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

}
