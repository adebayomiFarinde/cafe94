package com.example.cafesystem;

import com.example.cafesystem.Repository.*;
import com.example.cafesystem.Services.IUserService;
import com.example.cafesystem.Services.UserService;
import com.example.cafesystem.ViewModels.CreateBooking;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

public class BookingNewBookingController {
    private IUserService _userService;
    private IStaffRepository _staffRepository;
    private ICustomerRepository _customerRepository;
    private IBookingRepository _bookingRepository;
    public BookingNewBookingController(){
        _staffRepository = new StaffRepository();
        _customerRepository = new CustomerRepository();
        _userService = new UserService(_customerRepository, _staffRepository);
        _bookingRepository = new BookingRepository();
    }

    @FXML
    private Stage stage;

    private Scene scene;

    private Parent root;

    @FXML
    private TextField BookingNewGuestsText;

    @FXML
    private DatePicker BookingNewTimePicker;

    @FXML
    private RadioButton BookingNewActive;

    public void switchToBookingView(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("bookingView.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void makeBooking(ActionEvent event) throws IOException {

        if(!BookingNewGuestsText.getText().equals("")){
            String referenceCode = "TW"+"-"+ LocalTime.now().getSecond() + "-"+
                    LocalTime.now().getMinute() +"-"+ LocalTime.now().getHour();


            UUID id = _bookingRepository.createBooking(new CreateBooking(null, referenceCode,
                    BookingNewTimePicker.getValue().atTime(20,16), MockData.getCustomerId(),
                    Integer.parseInt(BookingNewGuestsText.getText()),
                    false, Boolean.parseBoolean(BookingNewActive.getText()), LocalDate.now(), MockData.getCustomerId()));

            //call create method
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("New Booking");
            alert.setContentText("Successfully booked with reference code " + referenceCode);

            if (alert.showAndWait().get() == ButtonType.OK) {
                //back to welcome
                root = FXMLLoader.load(getClass().getResource("bookingView.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
        }
    }
}
