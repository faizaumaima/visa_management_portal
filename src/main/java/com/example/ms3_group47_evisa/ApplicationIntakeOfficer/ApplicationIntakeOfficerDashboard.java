package com.example.ms3_group47_evisa.ApplicationIntakeOfficer;

import com.example.ms3_group47_evisa.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ApplicationIntakeOfficerDashboard
{
    @javafx.fxml.FXML
    public void initialize() {
    }



    @javafx.fxml.FXML
    public void logoutOnAction(ActionEvent actionEvent) {
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
    public void CategorizationApplicationsOnAction(ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ApplicationIntakeOfficer/CategorizeApplications.fxml"));
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
    public void ForwardApplicationOnAction(ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ApplicationIntakeOfficer/ForwardApplication.fxml"));
            Parent root=fxmlLoader.load();
            Scene scene=new Scene(root);
            Stage stage =new Stage();
            stage.setTitle("Hello!");

            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            ///
        }
    }

    @javafx.fxml.FXML
    public void CheckErrosOnAction(ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ApplicationIntakeOfficer/IdentifyErrors.fxml"));
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
    public void viewApplicationOnAction(ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ApplicationIntakeOfficer/Application.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("Hello!");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e){
            ///
        }
    }

    @javafx.fxml.FXML
    public void UpdateStatusOnAtion(ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ApplicationIntakeOfficer/UpdateStatus.fxml"));
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