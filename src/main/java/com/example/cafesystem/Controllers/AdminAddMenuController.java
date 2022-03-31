package com.example.cafesystem;

import com.example.cafesystem.Repository.*;
import com.example.cafesystem.Services.IUserService;
import com.example.cafesystem.Services.UserService;
import com.example.cafesystem.ViewModels.MenuViewModel;
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

public class AdminAddMenuController {
    private IUserService _userService;
    private IStaffRepository _staffRepository;
    private ICustomerRepository _customerRepository;
    private IMenuRepository _menuRepository;
    public AdminAddMenuController(){
        _staffRepository = new StaffRepository();
        _customerRepository = new CustomerRepository();
        _userService = new UserService(_customerRepository, _staffRepository);
        _menuRepository = new MenuRepository();
    }
    @FXML
    private Stage stage;

    private Scene scene;

    private Parent root;

    @FXML
    private TextField AdminAddMenuDescriptionText;

    @FXML
    private TextField AdminAddMenuNameText;

    public void switchToAdminView(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("AdminView.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void addMenu(ActionEvent event) throws IOException {
        String name = AdminAddMenuNameText.getText();
        String description = AdminAddMenuDescriptionText.getText();

        if(!name.equals("") && !description.equals("")){
            UUID id = _menuRepository.createMenu(new MenuViewModel(null, name, description,
                    true, false, LocalDate.now(), MockData.getStaffId()));

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Add menu");
            alert.setContentText("You have added a menu Item successfully");

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
}
