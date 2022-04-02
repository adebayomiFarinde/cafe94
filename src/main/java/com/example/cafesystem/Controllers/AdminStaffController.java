package com.example.cafesystem;

import com.example.cafesystem.Repository.CustomerRepository;
import com.example.cafesystem.Repository.ICustomerRepository;
import com.example.cafesystem.Repository.IStaffRepository;
import com.example.cafesystem.Repository.StaffRepository;
import com.example.cafesystem.Services.IUserService;
import com.example.cafesystem.Services.UserService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * This class provides functionality to the AdminStaffView.fxml.
 */
public class AdminStaffController implements Initializable {

    private IUserService _userService;
    private IStaffRepository _staffRepository;
    private ICustomerRepository _customerRepository;

    /**
     * Initializes the _staffRepository, _customerRepository and _userService.
     */
    public AdminStaffController() {
        _staffRepository = new StaffRepository();
        _customerRepository = new CustomerRepository();
        _userService = new UserService(_customerRepository, _staffRepository);

    }

    @FXML
    private Stage stage;

    private Scene scene;

    private Parent root;

    @FXML
    private TableView tableViewStaff;

    @FXML
    private Label AdminStaffViewLabel;

    @FXML
    private ListView<String> AdminStaffViewList;

    String currentStaff;


    /**
     * Set Table columns Name for Staff List. Fetch appropriate attributes in the Table.
     * @param url FXMLLoader handles this automatically.
     * @param resourceBundle FXMLLoader handles this automatically.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        List<Staff> staff = _staffRepository.getAllStaff();

        TableColumn firstName = new TableColumn("First Name");
        TableColumn lastName = new TableColumn("Last Name");
        TableColumn email = new TableColumn("Email");
        TableColumn isActive = new TableColumn("Is Active");
        TableColumn isDeleted = new TableColumn("Is Deleted");
        TableColumn createdDate = new TableColumn("Created Date");

        tableViewStaff.getColumns().addAll(firstName, lastName, email, isActive, isDeleted, createdDate);

        ArrayList<StaffVM> staffVMS = new ArrayList<>() {
        };

        staff.forEach(x -> staffVMS
                .add(new StaffVM(x.getfName(), x.getlName(), x.getEmail(), Boolean.toString(x.getActive()),
                        Boolean.toString(x.getIsDeleted()), x.getCreatedDate().toString())));

        final ObservableList<StaffVM> all = FXCollections.observableArrayList(
                staffVMS
        );

        firstName.setCellValueFactory(new PropertyValueFactory<StaffVM, String>("firstName"));
        lastName.setCellValueFactory(new PropertyValueFactory<StaffVM, String>("lastName"));
        email.setCellValueFactory(new PropertyValueFactory<StaffVM, String>("email"));
        isActive.setCellValueFactory(new PropertyValueFactory<StaffVM, String>("isActive"));
        isDeleted.setCellValueFactory(new PropertyValueFactory<StaffVM, String>("isDeleted"));
        createdDate.setCellValueFactory(new PropertyValueFactory<StaffVM, String>("createdDate"));

        tableViewStaff.setColumnResizePolicy(TableView.UNCONSTRAINED_RESIZE_POLICY);

        tableViewStaff.setItems(all);
    }

    /**
     * Switch to AdminView.fxml.
     * @param event  represents an action when Back Button is clicked.
     * @throws IOException There may occur an exception.
     */
    public void switchAdminView(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("AdminView.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    /** Removes a staff member.
     * @param event  represents an action when Remove Button is clicked.
     * @throws Exception There may occur an exception.
     */
    public void handleDeletePerson(ActionEvent event) throws Exception {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Remove a staff member");
        alert.setContentText("The selected staff will be deleted");

        try {

            if (alert.showAndWait().get() == ButtonType.OK) {
                TableSelectionModel<StaffVM> selectedIndex = tableViewStaff.getSelectionModel();
                _staffRepository.deleteStaffByEmail(selectedIndex.getSelectedItem().getEmail());

                root = FXMLLoader.load(getClass().getResource("AdminStaffView.fxml"));
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