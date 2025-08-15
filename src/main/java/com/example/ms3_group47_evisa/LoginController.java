package com.example.ms3_group47_evisa;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {
    @javafx.fxml.FXML
    private TextField userIdTextField;
    @javafx.fxml.FXML
    private TextField passwordTextfield;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @Deprecated
    public void loginOnaction(ActionEvent actionEvent) {
        try {
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

    @Deprecated
    public void createaccountOnaction(ActionEvent actionEvent) {
    }

    @Deprecated
    public void createAccountOnAction(ActionEvent actionEvent) {
    }

    @Deprecated
    public void loginOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleLoginOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleCreateAccountOnAction(ActionEvent actionEvent) {
    }
}