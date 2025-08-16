package com.example.finalms3;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import com.example.finalms3.utils.NavigationUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ControlSystemsDashboard {

    @FXML
    private Button backButton;
    
    @FXML
    private Button emergencyPlanButton;
    
    @FXML
    private Button accessControlButton;
    
    @FXML
    private Button evaluationButton;
    
    @FXML
    private Button loadButton;
    
    @FXML
    private TableView<ControlSystem> controlSystemsTableView;
    
    @FXML
    private TableColumn<ControlSystem, String> codeColumn;
    
    @FXML
    private TableColumn<ControlSystem, String> emergencySituationColumn;
    
    @FXML
    private TableColumn<ControlSystem, String> responseActionsColumn;
    
    @FXML
    private TableColumn<ControlSystem, String> responseTeamColumn;
    
    @FXML
    private TableColumn<ControlSystem, String> lastUpdatedColumn;
    
    @FXML
    private TextField planCodeField;

    private ObservableList<ControlSystem> controlSystemsData;
    private FilteredList<ControlSystem> filteredData;

    @FXML
    public void initialize() {
        // Initialize control systems data
        controlSystemsData = FXCollections.observableArrayList();
        
        // Add sample control systems
        controlSystemsData.add(new ControlSystem("CS001", "Fire Emergency", "Activate sprinklers, evacuate building", "Fire Response Team", LocalDateTime.now().minusDays(2)));
        controlSystemsData.add(new ControlSystem("CS002", "Security Breach", "Lock down facility, alert security", "Security Team", LocalDateTime.now().minusDays(1)));
        controlSystemsData.add(new ControlSystem("CS003", "Power Failure", "Switch to backup power, notify IT", "IT Support Team", LocalDateTime.now().minusHours(6)));
        
        // Initialize table columns
        codeColumn.setCellValueFactory(cellData -> 
            new javafx.beans.property.SimpleStringProperty(cellData.getValue().getCode()));
        emergencySituationColumn.setCellValueFactory(cellData -> 
            new javafx.beans.property.SimpleStringProperty(cellData.getValue().getEmergencySituation()));
        responseActionsColumn.setCellValueFactory(cellData -> 
            new javafx.beans.property.SimpleStringProperty(cellData.getValue().getResponseActions()));
        responseTeamColumn.setCellValueFactory(cellData -> 
            new javafx.beans.property.SimpleStringProperty(cellData.getValue().getResponseTeam()));
        lastUpdatedColumn.setCellValueFactory(cellData -> 
            new javafx.beans.property.SimpleStringProperty(
                cellData.getValue().getLastUpdated().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))
            ));
        
        // Set up filtering
        setupFiltering();
        
        // Set up table selection listener
        controlSystemsTableView.getSelectionModel().selectedItemProperty().addListener(
            (observable, oldValue, newValue) -> {
                if (newValue != null) {
                    showControlSystemDetails(newValue);
                }
            }
        );
    }

    private void setupFiltering() {
        filteredData = new FilteredList<>(controlSystemsData, p -> true);
        
        // Plan code filter
        planCodeField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(controlSystem -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                return controlSystem.getCode().toLowerCase().contains(newValue.toLowerCase());
            });
        });
        
        SortedList<ControlSystem> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(controlSystemsTableView.comparatorProperty());
        controlSystemsTableView.setItems(sortedData);
    }

    private void showControlSystemDetails(ControlSystem controlSystem) {
        // Display control system details in the form field
        planCodeField.setText(controlSystem.getCode());
    }

    @FXML
    protected void onBackClick() {
        Stage currentStage = (Stage) backButton.getScene().getWindow();
        NavigationUtil.navigateToSecurityManagerDashboard(currentStage);
    }

    @FXML
    protected void onEmergencyPlanClick() {
        System.out.println("Emergency Plan clicked");
        // TODO: Implement emergency plan functionality
    }

    @FXML
    protected void onAccessControlClick() {
        System.out.println("Access Control clicked");
        // TODO: Implement access control functionality
    }

    @FXML
    protected void onEvaluationClick() {
        System.out.println("Evaluation clicked");
        // TODO: Implement evaluation functionality
    }

    @FXML
    protected void onLoadClick() {
        String planCode = planCodeField.getText();
        if (planCode != null && !planCode.isEmpty()) {
            ControlSystem found = controlSystemsData.stream()
                .filter(cs -> cs.getCode().equals(planCode))
                .findFirst()
                .orElse(null);
            
            if (found != null) {
                controlSystemsTableView.getSelectionModel().select(found);
                showAlert("Success", "Control system loaded: " + found.getEmergencySituation());
            } else {
                showAlert("Not Found", "No control system found with code: " + planCode);
            }
        } else {
            showAlert("Error", "Please enter a plan code to load.");
        }
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    // Inner class for control systems
    public static class ControlSystem {
        private String code;
        private String emergencySituation;
        private String responseActions;
        private String responseTeam;
        private LocalDateTime lastUpdated;

        public ControlSystem(String code, String emergencySituation, String responseActions, String responseTeam, LocalDateTime lastUpdated) {
            this.code = code;
            this.emergencySituation = emergencySituation;
            this.responseActions = responseActions;
            this.responseTeam = responseTeam;
            this.lastUpdated = lastUpdated;
        }

        public String getCode() { return code; }
        public void setCode(String code) { this.code = code; }

        public String getEmergencySituation() { return emergencySituation; }
        public void setEmergencySituation(String emergencySituation) { this.emergencySituation = emergencySituation; }

        public String getResponseActions() { return responseActions; }
        public void setResponseActions(String responseActions) { this.responseActions = responseActions; }

        public String getResponseTeam() { return responseTeam; }
        public void setResponseTeam(String responseTeam) { this.responseTeam = responseTeam; }

        public LocalDateTime getLastUpdated() { return lastUpdated; }
        public void setLastUpdated(LocalDateTime lastUpdated) { this.lastUpdated = lastUpdated; }
    }
}

