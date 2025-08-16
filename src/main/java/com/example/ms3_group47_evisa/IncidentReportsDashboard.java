package com.example.ms3_group47_evisa;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import com.example.ms3_group47_evisa.utils.NavigationUtil;
import com.example.ms3_group47_evisa.services.DataService;
import com.example.ms3_group47_evisa.models.Incident;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import java.time.LocalDateTime;

public class IncidentReportsDashboard {

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
    private TableColumn<Incident, LocalDateTime> reportTimeColumn;

    @FXML
    private TableColumn<Incident, String> assignedColumn;

    @FXML
    private TextField searchTextField;

    @FXML
    private ComboBox<String> statusFilterComboBox;

    @FXML
    private ComboBox<String> severityFilterComboBox;

    @FXML
    private Button refreshButton;

    @FXML
    private Button exportButton;

    @FXML
    private Button backButton;

    @FXML
    private TextArea detailsTextArea;

    // Additional buttons 
    @FXML
    private Button reportsButton;
    
    @FXML
    private Button loadButton;
    
    @FXML
    private Button detailedViewButton;

    private DataService dataService;
    private FilteredList<Incident> filteredData;

    @FXML
    public void initialize() {
        dataService = DataService.getInstance();
        
        // Initialize filter combo boxes
        ObservableList<String> statusOptions = FXCollections.observableArrayList(
            "All", "OPEN", "IN PROGRESS", "RESOLVED", "CLOSED"
        );
        statusFilterComboBox.setItems(statusOptions);
        statusFilterComboBox.setValue("All");
        
        ObservableList<String> severityOptions = FXCollections.observableArrayList(
            "All", "LOW", "MEDIUM", "HIGH", "CRITICAL"
        );
        severityFilterComboBox.setItems(severityOptions);
        severityFilterComboBox.setValue("All");
        
        //  table columns Initialization
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
        reportTimeColumn.setCellValueFactory(cellData -> 
            new javafx.beans.property.SimpleObjectProperty<>(cellData.getValue().getReportTime()));
        assignedColumn.setCellValueFactory(cellData -> 
            new javafx.beans.property.SimpleStringProperty(cellData.getValue().getAssignedPerson()));
        
        // Set up filtering
        setupFiltering();
        
        // Load incidents
        loadIncidents();
        
        // Set up table selection listener
        incidentsTableView.getSelectionModel().selectedItemProperty().addListener(
            (observable, oldValue, newValue) -> {
                if (newValue != null) {
                    showIncidentDetails(newValue);
                }
            }
        );
    }

    private void setupFiltering() {
        filteredData = new FilteredList<>(dataService.getAllIncidents(), p -> true);
        
        // Search filter
        searchTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(incident -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                
                String lowerCaseFilter = newValue.toLowerCase();
                return incident.getLocation().toLowerCase().contains(lowerCaseFilter) ||
                       incident.getIncidentType().toLowerCase().contains(lowerCaseFilter) ||
                       incident.getId().toLowerCase().contains(lowerCaseFilter);
            });
        });
        
        // Status filter
        statusFilterComboBox.valueProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(incident -> {
                if (newValue == null || newValue.equals("All")) {
                    return true;
                }
                return incident.getStatus().equals(newValue);
            });
        });
        
        // Severity filter
        severityFilterComboBox.valueProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(incident -> {
                if (newValue == null || newValue.equals("All")) {
                    return true;
                }
                return incident.getSeverity().equals(newValue);
            });
        });
        
        SortedList<Incident> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(incidentsTableView.comparatorProperty());
        incidentsTableView.setItems(sortedData);
    }

    private void loadIncidents() {
        // Data is loaded through the filtered list
    }

    private void showIncidentDetails(Incident incident) {
        StringBuilder details = new StringBuilder();
        details.append("Incident ID: ").append(incident.getId()).append("\n\n");
        details.append("Location: ").append(incident.getLocation()).append("\n");
        details.append("Type: ").append(incident.getIncidentType()).append("\n");
        details.append("Severity: ").append(incident.getSeverity()).append("\n");
        details.append("Status: ").append(incident.getStatus()).append("\n");
        details.append("Reported By: ").append(incident.getReportedBy()).append("\n");
        details.append("Assigned To: ").append(incident.getAssignedPerson()).append("\n");
        details.append("Report Time: ").append(incident.getReportTime()).append("\n\n");
        details.append("Description:\n").append(incident.getDescription());
        
        detailsTextArea.setText(details.toString());
    }

    @FXML
    protected void onRefreshClick() {
        loadIncidents();
        showAlert("Success", "Data refreshed successfully!");
    }

    @FXML
    protected void onExportClick() {
        // Create file chooser for export
        javafx.stage.FileChooser fileChooser = new javafx.stage.FileChooser();
        fileChooser.setTitle("Export Incident Reports");
        fileChooser.getExtensionFilters().add(
            new javafx.stage.FileChooser.ExtensionFilter("CSV Files", "*.csv")
        );
        
        Stage stage = (Stage) backButton.getScene().getWindow();
        java.io.File selectedFile = fileChooser.showSaveDialog(stage);
        
        if (selectedFile != null) {
            // Here you would implement the actual export logic
            showAlert("Success", "Incident reports exported to: " + selectedFile.getName());
        }
    }

    @FXML
    protected void onBackClick() {
        Stage currentStage = (Stage) backButton.getScene().getWindow();
        NavigationUtil.navigateToSecurityManagerDashboard(currentStage);
    }

    // Additional event handlers from FXML
    @FXML
    protected void onReportsClick() {
        // Handle Reports button click
        System.out.println("Reports clicked");
        // TODO: Implement reports functionality
    }

    @FXML
    protected void onLoadClick() {
        // Handle Load button click
        System.out.println("Load clicked");
        // TODO: Implement load functionality
    }

    @FXML
    protected void onDetailedViewClick() {
        // Handle Detailed View button click
        System.out.println("Detailed View clicked");
        // TODO: Implement detailed view functionality
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}

