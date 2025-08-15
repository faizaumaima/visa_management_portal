package com.example.ms3_group47_evisa.ImmigrationOfficer;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class CollaborateWithSecurityController
{
    @javafx.fxml.FXML
    private ToggleGroup result;
    @javafx.fxml.FXML
    private RadioButton clearedradiobutton;
    @javafx.fxml.FXML
    private Label outputlabel;
    @javafx.fxml.FXML
    private RadioButton notclearedradiobutton;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void updateOnaction(ActionEvent actionEvent) {
        if (clearedradiobutton.isSelected()){
            outputlabel.setText("cleared");
        } else if (notclearedradiobutton.isSelected()) {
            outputlabel.setText("not cleared");

        }else {
            outputlabel.setText("select a result");
        }
    }

    @javafx.fxml.FXML
    public void clearOnaction(ActionEvent actionEvent) {
        result.selectToggle(null);
        outputlabel.setText(null);
    }

    @javafx.fxml.FXML
    public void sendtosecurityOnaction(ActionEvent actionEvent) {
    }
}