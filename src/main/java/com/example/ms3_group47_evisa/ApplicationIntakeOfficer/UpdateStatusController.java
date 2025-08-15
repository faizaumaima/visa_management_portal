package com.example.ms3_group47_evisa.ApplicationIntakeOfficer;

import com.example.ms3_group47_evisa.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class UpdateStatusController
{
    @javafx.fxml.FXML
    private RadioButton approvedradiobutton;
    @javafx.fxml.FXML
    private RadioButton pendingradiobutton;
    @javafx.fxml.FXML
    private RadioButton rejectedradiobutton;
    @javafx.fxml.FXML
    private TextArea remarksTextarea;
    @javafx.fxml.FXML
    private ToggleGroup status;
    @javafx.fxml.FXML
    private Label outputlabel;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void updateOnaction(ActionEvent actionEvent) {
        if (approvedradiobutton.isSelected()){
            outputlabel.setText("Approved");
        } else if (pendingradiobutton.isSelected()) {
            outputlabel.setText("Pending");
        } else if (rejectedradiobutton.isSelected()) {
            outputlabel.setText("Rejected");
        }else {
            outputlabel.setText("select a button");
            return;
        }
        if (remarksTextarea.getText().trim().isEmpty()){
            outputlabel.setText("enter remarks");
            return;
        }
        outputlabel.setText("submitted");
    }

    @javafx.fxml.FXML
    public void backonaction(ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ApplicationIntakeOfficer/ApplicationIntakeOfficerDashboard.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("Hello!");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            ///
        }
    }
}