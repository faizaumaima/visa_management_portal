package com.example.ms3_group47_evisa.FinancialOfficer;

import com.example.ms3_group47_evisa.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FinancialOfficerDashboardController {
    @javafx.fxml.FXML
    public void initialize() {

    }

    @javafx.fxml.FXML
    public void updatefinancialstatusonaction(ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("FinancialOfficer/UpdateFinancialStatus.fxml"));
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
    public void generatefinancialreportsonaction(ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("FinancialOfficer/GenerateFinancialReport.fxml"));
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

    @javafx.fxml.FXML
    public void logoutonaction(ActionEvent actionEvent) {
    try{
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("FinancialOfficer/Logout.fxml"));
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
    public void aprproverefindsonaction(ActionEvent actionEvent) {
    try{
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("FinancialOfficer/ApproveRefinds.fxml"));
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
    public void verifytranscationsonaction(ActionEvent actionEvent) {
    try{
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("FinancialOfficer/VerifyTransaction.fxml"));
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