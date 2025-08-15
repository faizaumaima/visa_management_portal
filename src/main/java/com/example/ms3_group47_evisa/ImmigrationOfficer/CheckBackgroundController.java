package com.example.ms3_group47_evisa.ImmigrationOfficer;

import javafx.event.ActionEvent;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class CheckBackgroundController
{
    @javafx.fxml.FXML
    private ToggleGroup result;
    @javafx.fxml.FXML
    private CheckBox visacheckbox;
    @javafx.fxml.FXML
    private CheckBox immigrationcheckbox;
    @javafx.fxml.FXML
    private RadioButton issuesradiobutton;
    @javafx.fxml.FXML
    private RadioButton verifiedradiobutton;
    @javafx.fxml.FXML
    private Label outputlabel;
    @javafx.fxml.FXML
    private CheckBox pastcheckbox;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void clearonaction(ActionEvent actionEvent) {
        visacheckbox.setSelected(false);
        pastcheckbox.setSelected(false);
        immigrationcheckbox.setSelected(false);
        result.selectToggle(null);
        outputlabel.setText(null);
    }

    @javafx.fxml.FXML
    public void saveonaction(ActionEvent actionEvent) {
        if (visacheckbox.isSelected() && pastcheckbox.isSelected() && immigrationcheckbox.isSelected()){
            outputlabel.setText("Backgroung checked");
        }
        if (verifiedradiobutton.isSelected()){
            outputlabel.setText("Background verified");
        } else if (issuesradiobutton.isSelected()) {
            outputlabel.setText("Issues Flagged");
        }else {
            outputlabel.setText("select a result");
        }
    }
}