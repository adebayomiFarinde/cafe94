package com.example.cafesystem;

import com.example.cafesystem.Repository.BookingRepository;
import com.example.cafesystem.Repository.IBookingRepository;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.UUID;

public class BookingViewBookingsController implements Initializable {

    private IBookingRepository _bookingRepository;
    public BookingViewBookingsController(){
        _bookingRepository = new BookingRepository();
    }

    @FXML
    private Stage stage;

    private Scene scene;

    private Parent root;

    @FXML
    private ListView<String> BookingViewBookingsList;

    String currentStaff;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<Booking> bookings = new ArrayList<>();
        if(MockData.getStaffId().equals(UUID.fromString("00000000-0000-0000-0000-000000000000"))){
            bookings = _bookingRepository.getAllBookingByCustomerId(MockData.getCustomerId());

        }else{
            bookings = _bookingRepository.getAllBookings();
        }

        ArrayList<String>  bookingDetails = new ArrayList<>(){};

        bookings.forEach(x -> bookingDetails
                .add("Booking " + x.getBookingTime().toLocalDate() + " at " + x.getBookingTime().toLocalTime() ));
        BookingViewBookingsList.getItems().addAll(bookingDetails);
    }

    public void switchToBookingView(ActionEvent event) throws IOException {

        root = FXMLLoader.load(getClass().getResource("bookingView.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
