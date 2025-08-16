package com.example.ms3_group47_evisa.ImmigrationOfficer;

import javafx.event.ActionEvent;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;

public class DetectFraudController
{
    @javafx.fxml.FXML
    private CheckBox documentcheckbox;
    @javafx.fxml.FXML
    private CheckBox suspiciouscheckbox;
    @javafx.fxml.FXML
    private CheckBox personaldetailcheckbox;
    @javafx.fxml.FXML
    private CheckBox backgroundcheckbox;
    @javafx.fxml.FXML
    private Label outputlabel;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void checkedOnaction(ActionEvent actionEvent) {
        if (personaldetailcheckbox.isSelected() && backgroundcheckbox.isSelected() && documentcheckbox.isSelected()){
            outputlabel.setText("Checked");
        }
        if (suspiciouscheckbox.isSelected()){
            outputlabel.setText("Forward to Security");
        }
    }

    @javafx.fxml.FXML
    public void forwardtosecurityOnaction(ActionEvent actionEvent) {
        if (suspiciouscheckbox.isSelected()){
            outputlabel.setText("Forwarded to security");
        }
        if (personaldetailcheckbox.isSelected() && backgroundcheckbox.isSelected() && documentcheckbox.isSelected()){
            outputlabel.setText("Not Needed");
        }

    }
}