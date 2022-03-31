package com.example.cafesystem;

import com.example.cafesystem.Repository.BookingRepository;
import com.example.cafesystem.Repository.IBookingRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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
    public BookingViewBookingsController(){
        _bookingRepository = new BookingRepository();
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

        TableColumn isActive = new TableColumn("Is Active");
        TableColumn bookingTime = new TableColumn("Booking Time");
        TableColumn numberOfGuest = new TableColumn("Number Of Guest");

        tableView.getColumns().addAll(isActive, bookingTime, numberOfGuest);

        ArrayList<BookingVM>  bookingDetails = new ArrayList<>(){};

        bookings.forEach(x -> bookingDetails
                .add(new BookingVM(x.getActive(), x.getBookingTime(), x.getNumberOfGuest())));

        final ObservableList<BookingVM> all = FXCollections.observableArrayList(
                bookingDetails
        );

        isActive.setCellValueFactory(new PropertyValueFactory<BookingVM, String>("isActive"));
        bookingTime.setCellValueFactory(new PropertyValueFactory<BookingVM, String>("bookingTime"));
        numberOfGuest.setCellValueFactory(new PropertyValueFactory<BookingVM, String>("numberOfGuest"));

        tableView.setItems(all);
    }

    public void switchToBookingView(ActionEvent event) throws IOException {

        root = FXMLLoader.load(getClass().getResource("bookingView.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
