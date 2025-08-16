package com.example.ms3_group47_evisa.ImmigrationOfficer;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class MakeDecisionsController
{
    @javafx.fxml.FXML
    private RadioButton rejectradiobutton;
    @javafx.fxml.FXML
    private ToggleGroup decision;
    @javafx.fxml.FXML
    private Label outputlabel;
    @javafx.fxml.FXML
    private RadioButton approveradiobutton;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void finalizeOnaction(ActionEvent actionEvent) {
        if (rejectradiobutton.isSelected()){
            outputlabel.setText("Rejected");
        }else if (approveradiobutton.isSelected()){
            outputlabel.setText("Approved");
        }else{
            outputlabel.setText("Select a decision");
            return;
        }


    }
}