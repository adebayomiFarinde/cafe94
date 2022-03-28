package com.example.cafesystem;

import com.example.cafesystem.Repository.CustomerRepository;
import com.example.cafesystem.Repository.ICustomerRepository;
import com.example.cafesystem.Repository.IStaffRepository;
import com.example.cafesystem.Repository.StaffRepository;
import com.example.cafesystem.Services.IUserService;
import com.example.cafesystem.Services.UserService;
import com.example.cafesystem.ViewModels.StaffViewModel;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class AdminViewController implements Initializable {

    private IUserService _userService;
    private IStaffRepository _staffRepository;
    private ICustomerRepository _customerRepository;
    public AdminViewController(){
        _staffRepository = new StaffRepository();
        _customerRepository = new CustomerRepository();
        _userService = new UserService(_customerRepository, _staffRepository);

    }

    @FXML
    Label AdminViewHelloLabel;


    private Stage stage;

    private Scene scene;

    private Parent root;


    @FXML
    private Label chooseReportLabel;

    @FXML
    private Label chosenReport;

    @FXML
    private ListView<String> reportsListView;

    @FXML
    private TextField AdminViewTextField;



    String[] reports = {"Most Popular Item", "Most active customer", "Number of active staff"};
    String currentReport;


    private String[] dummy = {"dog", "dog", "cat", "lion"};


    public void displayName(String username) {
        AdminViewHelloLabel.setText("Hello " + username);
    }


    public void switchToWelcome(ActionEvent event) throws IOException {


        root = FXMLLoader.load(getClass().getResource("welcomeView.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        reportsListView.getItems().addAll(reports);

        reportsListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {

                //based on selection display report
                currentReport = reportsListView.getSelectionModel().getSelectedItem();

                switch (currentReport) {
                    case "Most Popular Item":
                        AdminViewTextField.setText(dummy[0]);
                        break;
                    case "Most active customer":
                        AdminViewTextField.setText(dummy[2]);


                }


                chosenReport.setText(currentReport);
            }
        });


    }

    public void switchToAddStaff(ActionEvent event) throws IOException {

        root = FXMLLoader.load(getClass().getResource("AdminAddStaffView.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }

    public void switchToViewStaff(ActionEvent event) throws IOException {


        root = FXMLLoader.load(getClass().getResource("AdminStaffView.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }

    public void switchToAddMenu(ActionEvent event) throws IOException {


        root = FXMLLoader.load(getClass().getResource("AdminAddMenu.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }

    public void switchToViewMenu(ActionEvent event) throws IOException {


        root = FXMLLoader.load(getClass().getResource("AdminViewMenu.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }

}
