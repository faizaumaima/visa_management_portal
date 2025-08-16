package com.example.ms3_group47_evisa.ApplicationIntakeOfficer;

import com.example.ms3_group47_evisa.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class CategorizeApplicationsController
{
    @javafx.fxml.FXML
    private TextField visatypeTextfield;
    @javafx.fxml.FXML
    private ComboBox<String> visacategorycombobox;
    @javafx.fxml.FXML
    private TableColumn<ApplicationClass,String> applicantnamecol;
    @javafx.fxml.FXML
    private TableColumn<ApplicationClass,String> visatypecol;
    @javafx.fxml.FXML
    private TextField travelpurposeTextfield;
    @javafx.fxml.FXML
    private TableColumn<ApplicationClass,String> applicationIdcol;
    @javafx.fxml.FXML
    private TableView<ApplicationClass> applicationdataTable;
    @javafx.fxml.FXML
    private TableColumn<ApplicationClass,String> travelpurposecol;
    @javafx.fxml.FXML
    private Label outputlabel;

    @javafx.fxml.FXML
    public void initialize() {
        visacategorycombobox.getItems().addAll("Tourist","Business","Medical","Student");

        applicationIdcol.setCellValueFactory(new PropertyValueFactory<>("applicationId"));
        applicantnamecol.setCellValueFactory(new PropertyValueFactory<>("name"));
        visatypecol.setCellValueFactory(new PropertyValueFactory<>("visatype"));
        travelpurposecol.setCellValueFactory(new PropertyValueFactory<>("travelpurpose"));


    }

    @javafx.fxml.FXML
    public void verifyOnaction(ActionEvent actionEvent) {
        if (visatypeTextfield.getText().trim().isEmpty()){
            outputlabel.setText("Give visa type");
            return;
        }
        if (travelpurposeTextfield.getText().trim().isEmpty()){
            outputlabel.setText("Give travel purpose");
            return;
        }
        outputlabel.setText("verified");
    }

    @javafx.fxml.FXML
    public void updateapplicationOnaction(ActionEvent actionEvent) {
        if (visatypeTextfield.getText().trim().isEmpty()){
            outputlabel.setText("Give visa type");
            return;
        }
        if (travelpurposeTextfield.getText().trim().isEmpty()){
            outputlabel.setText("Give travel purpose");
            return;
        }
        if (visacategorycombobox.getValue()==null) {
            outputlabel.setText("Select visa category");
            return;
        }
        outputlabel.setText("Updated");
    }

    @javafx.fxml.FXML
    public void logoutOnaction(ActionEvent actionEvent) {
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
    public void backOnaction(ActionEvent actionEvent) {
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
    public void assigncategoryOnaction(ActionEvent actionEvent) {
        if (visacategorycombobox.getValue()==null){
            outputlabel.setText("Select visa category");
            return;
        }

    }

    @javafx.fxml.FXML
    public void applicationdataOnaction(ActionEvent actionEvent) {
        ArrayList<ApplicationClass> list = new ArrayList<>();
        File file =new File("applications.bin");
        try{
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            while (true){
                ApplicationClass applications = (ApplicationClass) ois.readObject();
                list.add(applications);
            }
        } catch (Exception e) {
            ///
        }
        applicationdataTable.getItems().clear();
        applicationdataTable.getItems().addAll(list);
    }
}