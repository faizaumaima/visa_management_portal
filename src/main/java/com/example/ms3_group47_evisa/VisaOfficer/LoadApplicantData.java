package com.example.ms3_group47_evisa.VisaOfficer;

import com.example.ms3_group47_evisa.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class LoadApplicantData
{
    @javafx.fxml.FXML
    private Button buttonSearch;
    @javafx.fxml.FXML
    private TextField textFieldApplicationId;
    @javafx.fxml.FXML
    private TextField dobTextField;
    @javafx.fxml.FXML
    private TextField nameTextField;
    @javafx.fxml.FXML
    private TableColumn<VisaOfficerClass, String> documentNameTableColumn;
    @javafx.fxml.FXML
    private TextField nationalityTextField;
    @javafx.fxml.FXML
    private TableColumn<VisaOfficerClass, String> documentStatusTableColumn;

    @javafx.fxml.FXML
    public void initialize() {
        documentNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("documentName"));
        documentStatusTableColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
    }

    @javafx.fxml.FXML
    public void handleBackButton(ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("VisaOfficer/VisaOfficerDashboard.fxml"));
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