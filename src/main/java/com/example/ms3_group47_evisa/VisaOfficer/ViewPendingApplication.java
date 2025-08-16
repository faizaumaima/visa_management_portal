package com.example.ms3_group47_evisa.VisaOfficer;

import com.example.ms3_group47_evisa.CustomerSupportAgency.ApplicantClass;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ViewPendingApplication
{
    @javafx.fxml.FXML
    private TableView pendingTable;
    @javafx.fxml.FXML
    private TableColumn colApplicationDate;
    @javafx.fxml.FXML
    private Button buttonViewDetails;
    @javafx.fxml.FXML
    private TableColumn<VisaOfficerClass, String> colApplicationID;
    @javafx.fxml.FXML
    private TableColumn<VisaOfficerClass, String> colApplicantName;
    @javafx.fxml.FXML
    private TableColumn<ApplicantClass, String> colStatus;
    @javafx.fxml.FXML
    private Button buttonBack;

    @javafx.fxml.FXML
    public void initialize() {
        colApplicantName.setCellValueFactory(new PropertyValueFactory<>("columnName"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
        colApplicationID.setCellValueFactory(new PropertyValueFactory<>("applicationId"));
    }
}