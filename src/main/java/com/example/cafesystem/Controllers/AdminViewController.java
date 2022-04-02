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

/**
 * This class provides functionality to the AdminView.fxml.
 */
public class AdminViewController implements Initializable {

    private IUserService _userService;
    private IStaffRepository _staffRepository;
    private ICustomerRepository _customerRepository;

    /**
     * Initializes the _staffRepository, _customerRepository and _userService.
     */
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

    String[] reports = {"Most active customer", "Number of active staff"};
    String currentReport;


    /** Switch to WelcomeView.fxml.
     * @param event represents an action when LogOut Button is clicked.
     * @throws IOException There may occur an exception.
     */
    public void switchToWelcome(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("welcomeView.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /** Set Table columns Name for Report List. Fetch appropriate attributes in the Table.
     * @param url FXMLLoader handles this automatically.
     * @param resourceBundle FXMLLoader handles this automatically.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        AdminViewHelloLabel.setText("Hello " + MockData.getfName() + " "+ MockData.getlName() );
        reportsListView.getItems().addAll(reports);

        reportsListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {

                //based on selection display report
                currentReport = reportsListView.getSelectionModel().getSelectedItem();

                switch (currentReport) {
                    case "Most active customer":
                        AdminViewTextField.setText("Brad Pitt");
                        break;
                    default:
                        Integer result = _staffRepository.numberOfActiveStaff();
                        AdminViewTextField.setText(result.toString());
                       break;
                }

                chosenReport.setText(currentReport);
            }
        });
    }

    /** Switch to AdminAddStaffView.fxml.
     * @param event represents an action when Staff  Add is clicked.
     * @throws IOException There may occur an exception.
     */
    public void switchToAddStaff(ActionEvent event) throws IOException {

        root = FXMLLoader.load(getClass().getResource("AdminAddStaffView.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /** Switch to AdminStaffView.fxml
     * @param event represents an action when Staff - View Button is clicked.
     * @throws IOException There may occur an exception.
     */
    public void switchToViewStaff(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("AdminStaffView.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /** Switch to AdminAddMenu.fxml.
     * @param event represents an action when Menu - Add Button is clicked.
     * @throws IOException There may occur an exception.
     */
    public void switchToAddMenu(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("AdminAddMenu.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /** Switch to AdminViewMenu.fxml.
     * @param event represents an action when Meny - View Button is clicked.
     * @throws IOException There may occur an exception.
     */
    public void switchToViewMenu(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("AdminViewMenu.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /** Switch to BookingViewBookings.fxml.
     * @param event represents an action when Bookings - View Button is clicked.
     * @throws IOException There may occur an exception.
     */
    public void switchToBookings(ActionEvent event) throws IOException {

        root = FXMLLoader.load(getClass().getResource("BookingViewBookings.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /** Switch to AdminTakeawayView.fxml.
     * @param event represents an action when Takeaways - View Button is clicked.
     * @throws IOException There may occur an exception.
     */
    public void switchToTakeAway(ActionEvent event) throws IOException {

        root = FXMLLoader.load(getClass().getResource("AdminTakeawayView.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
