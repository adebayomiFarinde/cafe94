package com.example.cafesystem;

import com.example.cafesystem.Repository.BookingRepository;
import com.example.cafesystem.Repository.CustomerRepository;
import com.example.cafesystem.Repository.IBookingRepository;
import com.example.cafesystem.Repository.ICustomerRepository;
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
import java.util.UUID;

public class BookingViewBookingsController implements Initializable {

    private IBookingRepository _bookingRepository;
    private ICustomerRepository _customerRepository;
    public BookingViewBookingsController(){

        _bookingRepository = new BookingRepository();
        _customerRepository = new CustomerRepository();
    }

    @FXML
    private Stage stage;
    @FXML
    private Label bookingsViewHelloLabel;

    private Scene scene;

    private Parent root;

    @FXML
    private TableView tableView;

    @FXML
    private ListView<String> BookingViewBookingsList;

    String currentStaff;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        bookingsViewHelloLabel.setText("Hello " + MockData.getfName() + " "+ MockData.getlName() );

        List<Booking> bookings = new ArrayList<>();
        if(MockData.getStaffId().equals(UUID.fromString("00000000-0000-0000-0000-000000000000"))){
            bookings = _bookingRepository.getAllBookingByCustomerId(MockData.getCustomerId());

        }else{
            bookings = _bookingRepository.getAllBookings();
        }

        TableColumn name = new TableColumn("Name");
        TableColumn isActive = new TableColumn("Is Active");
        TableColumn bookingTime = new TableColumn("Booking Time");
        TableColumn numberOfGuest = new TableColumn("Number Of Guest");
        TableColumn referenceCode = new TableColumn("Reference Code");

        tableView.getColumns().addAll(name, isActive, bookingTime, numberOfGuest, referenceCode);

        ArrayList<BookingVM>  bookingDetails = new ArrayList<>(){};

        for(Booking x : bookings){
            Customer customer = _customerRepository.getCustomerId(x.getCreatedBy());
            if(customer == null){
                bookingDetails.add(new BookingVM("Administrator", x.getActive(),
                        x.getBookingTime(), x.getNumberOfGuest(), x.getReferenceCode()));
            }
            else{
                bookingDetails.add(new BookingVM(customer.getfName() + " " + customer.getlName(),
                        x.getActive(), x.getBookingTime(), x.getNumberOfGuest(), x.getReferenceCode()));
            }
        }

        final ObservableList<BookingVM> all = FXCollections.observableArrayList(
                bookingDetails
        );

        name.setCellValueFactory(new PropertyValueFactory<BookingVM, String>("name"));
        isActive.setCellValueFactory(new PropertyValueFactory<BookingVM, String>("isActive"));
        bookingTime.setCellValueFactory(new PropertyValueFactory<BookingVM, String>("bookingTime"));
        numberOfGuest.setCellValueFactory(new PropertyValueFactory<BookingVM, String>("numberOfGuest"));
        referenceCode.setCellValueFactory(new PropertyValueFactory<BookingVM, String>("referenceCode"));

        tableView.setItems(all);
    }

    public void switchToBookingView(ActionEvent event) throws IOException {

        if(MockData.getStaffId().equals(UUID.fromString("00000000-0000-0000-0000-000000000000"))){
            root = FXMLLoader.load(getClass().getResource("bookingView.fxml"));

        }
        else{
            root = FXMLLoader.load(getClass().getResource("AdminView.fxml"));
        }
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
