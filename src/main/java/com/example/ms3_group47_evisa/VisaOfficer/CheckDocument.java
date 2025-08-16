package com.example.ms3_group47_evisa.VisaOfficer;

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

public class CheckDocument
{
    @javafx.fxml.FXML
    private TableColumn<VisaOfficerClass, String> columnDocumentType;
    @javafx.fxml.FXML
    private TableColumn<VisaOfficerClass, String> columnStatus;
    @javafx.fxml.FXML
    private TableView<VisaOfficerClass> tableViewDocuments;
    @javafx.fxml.FXML
    private TableColumn<VisaOfficerClass, String> columnDocumentName;
    @javafx.fxml.FXML
    private Label outputlabel;

    @javafx.fxml.FXML
    public void initialize() {
        tableViewDocuments.getItems().addAll("documentname", "documenttype", "columnstatus");
        columnDocumentType.setCellValueFactory(new PropertyValueFactory<>("documenttype"));
        columnStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
        columnDocumentName.setCellValueFactory(new PropertyValueFactory<>("documentname"));
    }

    @javafx.fxml.FXML
    public void buttonViewDocument(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void buttonMarkInvalidOnAction(ActionEvent actionEvent) {
        if (columnDocumentName.getText()==null) {
            outputlabel.setText("Invalid: No document selected!")
        }else {
            outputlabel.setText("Please Select a document First");
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

        }
    }
}