package com.example.ms3_group47_evisa.VisaOfficer;

import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ViewPendingApplication
{
    @javafx.fxml.FXML
    private TableView pendingTable;
    @javafx.fxml.FXML
    private TableColumn colApplicationDate;
    @javafx.fxml.FXML
    private Button buttonViewDetails;
    @javafx.fxml.FXML
    private TableColumn colApplicationID;
    @javafx.fxml.FXML
    private TableColumn colApplicantName;
    @javafx.fxml.FXML
    private TableColumn colStatus;
    @javafx.fxml.FXML
    private Button buttonBack;

    @javafx.fxml.FXML
    public void initialize() {
    }
}