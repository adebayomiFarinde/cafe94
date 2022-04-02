package com.example.cafesystem;

import com.example.cafesystem.Repository.IMenuRepository;
import com.example.cafesystem.Repository.MenuRepository;
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
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * This class provides functionality to the AdminViewMenu.fxml.
 */

public class AdminViewMenuController implements Initializable {

    private IMenuRepository _menuRepository;

    /**
     * Menu Repository initialised.
     */
    public AdminViewMenuController(){
        _menuRepository = new MenuRepository();
    }
    @FXML
    private Stage stage;

    private Scene scene;

    private Parent root;


    /** Switch to AdminView.fxml.
     * @param event  represents an action when Back Button is clicked.
     * @throws IOException There may occur an exception.
     */
    public void switchToAdminView(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("AdminView.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private Label AdminViewMenuLabel;

    @FXML
    private ListView<String> AdminViewMenuList;

    String currentMenu;


    /** Set Table columns Name for Menu List. Fetch appropriate attributes in the Table.
     * @param url FXMLLoader handles this automatically.
     * @param resourceBundle FXMLLoader handles this automatically.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<Menu> menu = _menuRepository.getAllMenu();
        ArrayList<String> menuList = new ArrayList<>();
        menu.forEach(x -> menuList.add(x.getName()));
        AdminViewMenuList.getItems().addAll(menuList);
    }

    /** Removes a Menu.
     * @param event  represents an action when Remove Button is clicked.
     * @throws Exception There may occur an exception.
     */
    public void handleDeleteMenu(ActionEvent event) throws Exception {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Delete Menu");
        alert.setContentText("The selected menu will be deleted");

        try {

            if (alert.showAndWait().get() == ButtonType.OK) {
                String menuName = AdminViewMenuList.getSelectionModel().getSelectedItem();
                _menuRepository.deleteMenuByName(menuName);

                root = FXMLLoader.load(getClass().getResource("AdminViewMenu.fxml"));
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
