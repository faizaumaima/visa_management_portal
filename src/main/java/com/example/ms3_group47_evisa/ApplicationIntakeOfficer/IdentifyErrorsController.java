package com.example.ms3_group47_evisa.ApplicationIntakeOfficer;

import com.example.ms3_group47_evisa.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class IdentifyErrorsController
{
    @javafx.fxml.FXML
    private Label outputlabel;
    @javafx.fxml.FXML
    private TableColumn<ApplicationClass,String> applicantnamecol;
    @javafx.fxml.FXML
    private TableColumn<ApplicationClass,String> applicantIdcol;
    @javafx.fxml.FXML
    private Label resultlabel;
    @javafx.fxml.FXML
    private TableView<ApplicationClass> applicationdatatableview;

    @javafx.fxml.FXML
    public void initialize() {
        applicantIdcol.setCellValueFactory(new PropertyValueFactory<>("applicationId"));
        applicantnamecol.setCellValueFactory(new PropertyValueFactory<>("name"));
    }

    @javafx.fxml.FXML
    public void markasincompleteonaction(ActionEvent actionEvent) {
        outputlabel.setText("Incomplete");


    }

    @javafx.fxml.FXML
    public void backonaction(ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ApplicationIntakeOfficer/ApplicationIntakeOfficerDashbp.fxml"));
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
    public void notifyapplicantonaction(ActionEvent actionEvent) {
        outputlabel.setText("Notified applicant");
    }

    @javafx.fxml.FXML
    public void logoutonaction(ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Login.fxml"));
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
    public void checkerrorOnaction(ActionEvent actionEvent) {

    }
}