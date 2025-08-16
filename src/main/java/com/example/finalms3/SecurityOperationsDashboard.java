package com.example.finalms3;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import com.example.finalms3.utils.NavigationUtil;
import com.example.finalms3.services.DataService;
import com.example.finalms3.models.Incident;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.time.LocalDateTime;

public class SecurityOperationsDashboard {

    @FXML
    private TableView<Incident> incidentsTableView;

    @FXML
    private TableColumn<Incident, String> idColumn;

    @FXML
    private TableColumn<Incident, String> locationColumn;

    @FXML
    private TableColumn<Incident, String> typeColumn;

    @FXML
    private TableColumn<Incident, String> severityColumn;

    @FXML
    private TableColumn<Incident, String> statusColumn;

    @FXML
    private TableColumn<Incident, String> assignedColumn;

    @FXML
    private TextField locationTextField;

    @FXML
    private ComboBox<String> incidentTypeComboBox;

    @FXML
    private ComboBox<String> severityComboBox;

    @FXML
    private TextArea descriptionTextArea;

    @FXML
    private TextField reportedByTextField;

    @FXML
    private Button addIncidentButton;

    @FXML
    private Button updateStatusButton;

    @FXML
    private Button backButton;

    // Additional buttons from FXML
    @FXML
    private Button liveFeedButton;
    
    @FXML
    private Button incidentReportButton;
    
    @FXML
    private Button loadButton;
    
    @FXML
    private Button respondButton;

    private DataService dataService;

    @FXML
    public void initialize() {
        dataService = DataService.getInstance();
        
        // Initialize combo boxes
        ObservableList<String> incidentTypes = FXCollections.observableArrayList(
            "Security Breach", "Suspicious Activity", "Unauthorized Access", 
            "System Failure", "Emergency", "Other"
        );
        incidentTypeComboBox.setItems(incidentTypes);
        
        ObservableList<String> severityLevels = FXCollections.observableArrayList(
            "LOW", "MEDIUM", "HIGH", "CRITICAL"
        );
        severityComboBox.setItems(severityLevels);
        
        // Initialize table columns
        idColumn.setCellValueFactory(cellData -> 
            new javafx.beans.property.SimpleStringProperty(cellData.getValue().getId()));
        locationColumn.setCellValueFactory(cellData -> 
            new javafx.beans.property.SimpleStringProperty(cellData.getValue().getLocation()));
        typeColumn.setCellValueFactory(cellData -> 
            new javafx.beans.property.SimpleStringProperty(cellData.getValue().getIncidentType()));
        severityColumn.setCellValueFactory(cellData -> 
            new javafx.beans.property.SimpleStringProperty(cellData.getValue().getSeverity()));
        statusColumn.setCellValueFactory(cellData -> 
            new javafx.beans.property.SimpleStringProperty(cellData.getValue().getStatus()));
        assignedColumn.setCellValueFactory(cellData -> 
            new javafx.beans.property.SimpleStringProperty(cellData.getValue().getAssignedPerson()));
        
        // Load incidents
        loadIncidents();
    }

    private void loadIncidents() {
        incidentsTableView.setItems(dataService.getAllIncidents());
    }

    @FXML
    protected void onAddIncidentClick() {
        if (validateIncidentForm()) {
            Incident newIncident = new Incident(
                locationTextField.getText(),
                incidentTypeComboBox.getValue(),
                severityComboBox.getValue(),
                reportedByTextField.getText(),
                descriptionTextArea.getText()
            );
            
            dataService.addIncident(newIncident);
            loadIncidents();
            clearForm();
            showAlert("Success", "Incident reported successfully!");
        }
    }

    @FXML
    protected void onUpdateStatusClick() {
        Incident selectedIncident = incidentsTableView.getSelectionModel().getSelectedItem();
        if (selectedIncident != null) {
            // Create status update dialog
            ChoiceDialog<String> dialog = new ChoiceDialog<>("OPEN", "OPEN", "IN PROGRESS", "RESOLVED", "CLOSED");
            dialog.setTitle("Update Incident Status");
            dialog.setHeaderText("Update status for incident: " + selectedIncident.getId());
            dialog.setContentText("Select new status:");
            
            dialog.showAndWait().ifPresent(newStatus -> {
                selectedIncident.setStatus(newStatus);
                dataService.updateIncident(selectedIncident);
                loadIncidents();
                showAlert("Success", "Incident status updated to: " + newStatus);
            });
        } else {
            showAlert("Error", "Please select an incident first.");
        }
    }

    @FXML
    protected void onBackClick() {
        Stage currentStage = (Stage) backButton.getScene().getWindow();
        NavigationUtil.navigateToSecurityManagerDashboard(currentStage);
    }

    // Additional event handlers from FXML
    @FXML
    protected void onLiveFeedClick() {
        // Handle Live Feed button click
        System.out.println("Live Feed clicked");
        // TODO: Implement live feed functionality
    }

    @FXML
    protected void onIncidentReportClick() {
        // Handle Incident Report button click
        System.out.println("Incident Report clicked");
        // TODO: Implement incident report functionality
    }

    @FXML
    protected void onLoadClick() {
        // Handle Load button click
        System.out.println("Load clicked");
        // TODO: Implement load functionality
    }

    @FXML
    protected void onRespondClick() {
        // Handle Respond button click
        System.out.println("Respond clicked");
        // TODO: Implement respond functionality
    }

    private boolean validateIncidentForm() {
        if (locationTextField.getText().isEmpty() || incidentTypeComboBox.getValue() == null ||
            severityComboBox.getValue() == null || reportedByTextField.getText().isEmpty() ||
            descriptionTextArea.getText().isEmpty()) {
            
            showAlert("Validation Error", "Please fill in all required fields.");
            return false;
        }
        return true;
    }

    private void clearForm() {
        locationTextField.clear();
        incidentTypeComboBox.setValue(null);
        severityComboBox.setValue(null);
        descriptionTextArea.clear();
        reportedByTextField.clear();
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}

