package com.example.ms3_group47_evisa.ImmigrationOfficer;

import javafx.event.ActionEvent;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class ValidateComplianceController
{
    @javafx.fxml.FXML
    private ToggleGroup decision;
    @javafx.fxml.FXML
    private RadioButton rejectradiobutton;
    @javafx.fxml.FXML
    private CheckBox policycheckbox;
    @javafx.fxml.FXML
    private Label outputlabel;
    @javafx.fxml.FXML
    private RadioButton approveradiobutton;
    @javafx.fxml.FXML
    private CheckBox rulescheckbox;
    @javafx.fxml.FXML
    private RadioButton holdradiobutton;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void clearOnaction(ActionEvent actionEvent) {
        policycheckbox.setSelected(false);
        rulescheckbox.setSelected(false);
        decision.selectToggle(null);
        outputlabel.setText(null);
    }

    @javafx.fxml.FXML
    public void submitOnaction(ActionEvent actionEvent) {
        if (rejectradiobutton.isSelected()){
            outputlabel.setText("rejected");
        } else if (approveradiobutton.isSelected()) {
            outputlabel.setText("approved");
        } else if (holdradiobutton.isSelected()) {
            outputlabel.setText("On hold");
        }else{
            outputlabel.setText("select a decision");
        }
        if (rulescheckbox.isSelected() ){
            outputlabel.setText("Submitted");
        }
        if (policycheckbox.isSelected()){
            outputlabel.setText("submitted");
        }
    }
}