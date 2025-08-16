package com.example.ms3_group47_evisa.CustomerSupportAgency;

import com.example.ms3_group47_evisa.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
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
    private Label outputlabel;

    @javafx.fxml.FXML
    public void initialize() {

    }

    @javafx.fxml.FXML
    public void handleMarkAsResolvedOnAction(ActionEvent actionEvent) {
        if (ticketIdTextField.getText().trim().isEmpty()){
            outputlabel.setText("Give Ticket ID");
            return;
        }
    }

    @javafx.fxml.FXML
    public void handleBackOnAction(ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("CustomerSupportAgency/CustomerSupportAgencyDashboard.fxml"));
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