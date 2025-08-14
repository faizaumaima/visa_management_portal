package com.example.ms3_group47_evisa.DataEntryClerk;

import com.example.ms3_group47_evisa.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DataEntryClerkController
{
    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void addnewappicationonaction(ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ApplicationIntakeOffice/ApplicationVerification.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("Hello!");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            ///
        }
    }

    @javafx.fxml.FXML
    public void logoutonaction(ActionEvent actionEvent) {
    }
}