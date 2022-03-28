package com.example.cafesystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;

public class WaiterViewController {



    @FXML
    private CheckBox checkBox;

    @FXML
    private Label yesLabel;



    @FXML
   public  void approve(ActionEvent event) {

        if(checkBox.isSelected())
        {
            yesLabel.setText("Yes");

            //switch to customer view

        }else
        {
            yesLabel.setText("No");
        }



    }



}
