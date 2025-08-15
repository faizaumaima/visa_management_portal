package com.example.ms3_group47_evisa.CustomerSupportAgency;

import com.example.ms3_group47_evisa.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MarkAsResolved
{

    @javafx.fxml.FXML
    private TextField ticketIdTextField;
    @javafx.fxml.FXML
    private TextArea resolutionTextArea;
    @javafx.fxml.FXML
    private TextField customerNameTextField;
    @javafx.fxml.FXML
    private TextArea issueDescriptionTextArea;

    @javafx.fxml.FXML
    public void initialize() {

    }

    @javafx.fxml.FXML
    public void handleCancelOnAction(ActionEvent actionEvent) {
    }

    @Deprecated
    public void handleMarkasResolvedOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleMarkAsResolvedOnAction(ActionEvent actionEvent) {
    }
}