package com.example.cafesystem;

import com.example.cafesystem.Repository.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.UUID;

public class AdminTakeawayViewController implements Initializable {

    private ITakeawayRepository _takeawayRepository;
    private ICustomerRepository _customerRepository;
    private IMenuRepository _menuRepository;
    public AdminTakeawayViewController(){
        _takeawayRepository = new TakeawayRepository();
        _customerRepository = new CustomerRepository();
        _menuRepository = new MenuRepository();
    }

    @FXML
    private TableView adminTakeawayTable;
    @FXML
    private Stage stage;

    private Scene scene;

    private Parent root;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<Takeaway> takeaways = _takeawayRepository.getAllTakeaway();

        TableColumn menuName = new TableColumn("Menu Name");
        TableColumn referenceCode = new TableColumn("Reference Code");
        TableColumn isActive = new TableColumn("Is Active");
        TableColumn isDeleted = new TableColumn("Is Deleted");
        TableColumn createdDate = new TableColumn("Created Date");
        TableColumn createdBy = new TableColumn("Created By");

        adminTakeawayTable.getColumns().addAll(menuName, referenceCode, isActive, isDeleted, createdDate, createdBy);

        ArrayList<TakeawayVM>  takeawayVMS = new ArrayList<>(){};

        for(Takeaway x : takeaways){
            Customer customer = _customerRepository.getCustomerId(x.getCreatedBy());
            Menu menu = _menuRepository.getMenuId(x.getMenuId());

            if(customer == null){
                takeawayVMS.add(new TakeawayVM(menu.getName(), x.getReferenceCode(),
                        Boolean.toString(x.getActive()), Boolean.toString(x.getIsDeleted()), x.getCreatedDate().toString(), "Administrator"));
            }
            else{
                takeawayVMS.add(new TakeawayVM(menu.getName(), x.getReferenceCode(),
                        Boolean.toString(x.getActive()), Boolean.toString(x.getIsDeleted()), x.getCreatedDate().toString(),
                        customer.getfName() + " " + customer.getlName()));
            }
        }

        final ObservableList<TakeawayVM> all = FXCollections.observableArrayList(
                takeawayVMS
        );

        menuName.setCellValueFactory(new PropertyValueFactory<TakeawayVM, String>("menuName"));
        referenceCode.setCellValueFactory(new PropertyValueFactory<TakeawayVM, String>("referenceCode"));
        isActive.setCellValueFactory(new PropertyValueFactory<TakeawayVM, String>("isActive"));
        isDeleted.setCellValueFactory(new PropertyValueFactory<TakeawayVM, String>("isDeleted"));
        createdDate.setCellValueFactory(new PropertyValueFactory<TakeawayVM, String>("createdDate"));
        createdBy.setCellValueFactory(new PropertyValueFactory<TakeawayVM, String>("createdBy"));

        adminTakeawayTable.setItems(all);
    }
    public void switchToAdminView(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("AdminView.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
