package com.example.ms3_group47_evisa.ApplicationIntakeOfficer;

import com.example.ms3_group47_evisa.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class ForwardApplicationController
{
    @javafx.fxml.FXML
    private TableView<ForwardClass> applicationTable;
    @javafx.fxml.FXML
    private Label resultlabel;
    @javafx.fxml.FXML
    private TableColumn<ForwardClass,String> colApplicationID;
    @javafx.fxml.FXML
    private TableColumn<ForwardClass,String> colApplicantName;
    @javafx.fxml.FXML
    private TableColumn<ForwardClass,String> colStatus;
    @javafx.fxml.FXML
    private Button backonaction;
    @javafx.fxml.FXML
    private Button logoutonaction;

    @javafx.fxml.FXML
    public void initialize() {
        colApplicationID.setCellValueFactory(new PropertyValueFactory<>("ID"));
        colApplicantName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
    }

    @javafx.fxml.FXML
    public void backbutton(ActionEvent actionEvent) {
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

    @javafx.fxml.FXML
    public void forwardButton(ActionEvent actionEvent) {
        resultlabel.setText("Forwarded");
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ImmigrationOfficer/ImmigrationOfficerDashboard.fxml"));
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
    public void logoutbutton(ActionEvent actionEvent) {
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
}