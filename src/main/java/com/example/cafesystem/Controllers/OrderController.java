package com.example.cafesystem;

import com.example.cafesystem.Repository.*;
import com.example.cafesystem.ViewModels.OrderViewModel;
import com.example.cafesystem.ViewModels.TakewayViewModel;
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
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.UUID;

public class OrderController  implements Initializable {
    private IMenuRepository _menuRepository;
    private IOrderRepository _orderRepository;
    private ITakeawayRepository _takeawayRepository;

    public OrderController(){
        _menuRepository = new MenuRepository();
        _orderRepository = new OrderRepository();
        _takeawayRepository = new TakeawayRepository();
    }

    @FXML
    private ListView<String> foodListView;
    @FXML
    private DatePicker timeDatePickerText;

    String currentFood;

    @FXML
    private TextField timeText;

    @FXML
    private Label showOrderLabel;

    private Stage stage;

    private Scene scene;

    private Parent root;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<Menu> list = _menuRepository.getAllMenu();
        ArrayList<String> food = new ArrayList<>();

        list.forEach(x-> food.add(x.getName()));

        foodListView.getItems().addAll(food);

        foodListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
                currentFood = foodListView.getSelectionModel().getSelectedItem();
                showOrderLabel.setText(currentFood);
            }
        });
    }

    public void switchToCustomerView (ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("CustomerView.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToWelcome (ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("welcomeView.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void makeOrder(ActionEvent event) throws IOException {
        String textString = showOrderLabel.getText();
        if(!textString.equals("")) {
            Menu menu = _menuRepository.getMenuByName(showOrderLabel.getText());

            if(menu != null) {

                String referenceCode = "TW"+"-"+ LocalTime.now().getSecond() + "-"+
                        LocalTime.now().getMinute() +"-"+ LocalTime.now().getHour();
                UUID id = _takeawayRepository.createTakeaway(new TakewayViewModel(null,
                        menu.getId(), referenceCode, true,false, LocalDate.now(),
                        MockData.getCustomerId()));

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("TakeAway Order");
                alert.setContentText("New order with reference code " + referenceCode);

                if (alert.showAndWait().get() == ButtonType.OK) {
                    //back to welcome
                    root = FXMLLoader.load(getClass().getResource("customerView.fxml"));
                    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }
            }
        }
    }
}
