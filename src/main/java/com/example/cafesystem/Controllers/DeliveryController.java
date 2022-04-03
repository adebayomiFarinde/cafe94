package com.example.cafesystem;

import com.example.cafesystem.Repository.*;
import com.example.cafesystem.Services.IUserService;
import com.example.cafesystem.Services.UserService;
import com.example.cafesystem.ViewModels.MenuViewModel;
import com.example.cafesystem.ViewModels.OrderViewModel;
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
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.UUID;

/**
 * This class provides functionality to the deliveryView.fxml.
 */

public class DeliveryController implements Initializable {
    private IMenuRepository _menuRepository;
    private IOrderRepository _orderRepository;

    /**
     *  Initializes the _menuRepository, and _orderRepository.
     */
    public DeliveryController(){
        _menuRepository = new MenuRepository();
        _orderRepository = new OrderRepository();
    }

    @FXML
    private TextField addressText;

    @FXML
    private ListView<String> foodListViewDelivery;

    @FXML
    private Label showOrderLabelDelivery;

    String currentFood;

    private Stage stage;

    private Scene scene;

    private Parent root;

    /** Switch to CustomerView.fxml.
     * @param event represents an action when Back Button is clicked.
     * @throws IOException There may occur an exception.
     */
    public void switchToCustomerView(ActionEvent event) throws IOException {

        root = FXMLLoader.load(getClass().getResource("CustomerView.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }




    /** Customer makes an Order.
     * @param event represents an action when Make Order Button is clicked.
     * @throws IOException There may occur an exception.
     */
    public void makeOrderDelivery(ActionEvent event) throws IOException {
        String textString = showOrderLabelDelivery.getText();
        if(!textString.equals("")) {
            Menu menu = _menuRepository.getMenuByName(showOrderLabelDelivery.getText());

            if(menu != null) {

                UUID id = _orderRepository.createOrder(new OrderViewModel(null,
                        menu.getId(), MockData.getCustomerId(),
                        LocalDate.now(), false,false, true,
                        false, LocalDate.now(), MockData.getCustomerId()));

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("TakeAway Order");
                alert.setContentText("Your order will be delivered to " + addressText.getText());

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

    /** Set Table columns Name for Select Food List. Fetch appropriate attributes in the Table.
     * @param url FXMLLoader handles this automatically.
     * @param resourceBundle FXMLLoader handles this automatically.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<Menu> list = _menuRepository.getAllMenu();
        ArrayList<String> food = new ArrayList<>();

        list.forEach(x-> food.add(x.getName()));

        foodListViewDelivery.getItems().addAll(food);

        foodListViewDelivery.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
                currentFood = foodListViewDelivery.getSelectionModel().getSelectedItem();
                showOrderLabelDelivery.setText(currentFood);
            }
        });
    }
}
