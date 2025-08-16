package com.example.ms3_group47_evisa.VisaOfficer;

import com.example.ms3_group47_evisa.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class CheckDocument
{
    @javafx.fxml.FXML
    private TableColumn columnDocumentType;
    @javafx.fxml.FXML
    private TableColumn columnStatus;
    @javafx.fxml.FXML
    private TableView tableViewDocuments;
    @javafx.fxml.FXML
    private TableColumn columnDocumentName;
    @javafx.fxml.FXML
    private Label outputlabel;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void buttonViewDocument(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void buttonMarkInvalidOnAction(ActionEvent actionEvent) {
        if (columnDocumentName.isVisible()){
            outputlabel.setText("Rejecte");
        }else if (columnDocumentType.isVisible()){
            outputlabel.setText("Approved");
        }else{
            outputlabel.setText("Select a decision");
            return;
        }
    }

    @javafx.fxml.FXML
    public void buttonBackOnAction(ActionEvent actionEvent) {
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

    @javafx.fxml.FXML
    public void markasValidOnAction(ActionEvent actionEvent) {
        if (columnDocumentName.isVisible() && columnDocumentType.isVisible() && columnStatus.isVisible()){
            outputlabel.setText("Valid");
        }
    }
}