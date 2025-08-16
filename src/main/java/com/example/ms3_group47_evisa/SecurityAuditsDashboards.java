package com.example.ms3_group47_evisa;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import com.example.ms3_group47_evisa.utils.NavigationUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SecurityAuditsDashboards {

    @FXML
    private Button backButton;
    
    @FXML
    private Button auditReportButton;
    
    @FXML
    private Button systemStatusButton;
    
    @FXML
    private Button protocolUpdatesButton;
    
    @FXML
    private Button loadButton;
    
    @FXML
    private TableView<SecurityAudit> securityAuditsTableView;
    
    @FXML
    private TableColumn<SecurityAudit, String> idColumn;
    
    @FXML
    private TableColumn<SecurityAudit, String> securityAreaColumn;
    
    @FXML
    private TableColumn<SecurityAudit, String> statusColumn;
    
    @FXML
    private TableColumn<SecurityAudit, String> lastInspectionDateColumn;
    
    @FXML
    private TableColumn<SecurityAudit, String> nextScheduledAuditDateColumn;

    private ObservableList<SecurityAudit> securityAuditsData;
    private FilteredList<SecurityAudit> filteredData;

    @FXML
    public void initialize() {
        // Initialize security audits data
        securityAuditsData = FXCollections.observableArrayList();
        
        // Add sample security audits
        securityAuditsData.add(new SecurityAudit("AUD001", "Access Control", "COMPLETED", LocalDateTime.now().minusDays(30), LocalDateTime.now().plusDays(335)));
        securityAuditsData.add(new SecurityAudit("AUD002", "CCTV Systems", "IN_PROGRESS", LocalDateTime.now().minusDays(15), LocalDateTime.now().plusDays(15)));
        securityAuditsData.add(new SecurityAudit("AUD003", "Fire Safety", "PENDING", LocalDateTime.now().minusDays(45), LocalDateTime.now().plusDays(320)));
        securityAuditsData.add(new SecurityAudit("AUD004", "Network Security", "COMPLETED", LocalDateTime.now().minusDays(7), LocalDateTime.now().plusDays(358)));
        securityAuditsData.add(new SecurityAudit("AUD005", "Physical Security", "SCHEDULED", LocalDateTime.now().minusDays(60), LocalDateTime.now().plusDays(5)));
        
        // Initialize table columns
        idColumn.setCellValueFactory(cellData -> 
            new javafx.beans.property.SimpleStringProperty(cellData.getValue().getId()));
        securityAreaColumn.setCellValueFactory(cellData -> 
            new javafx.beans.property.SimpleStringProperty(cellData.getValue().getSecurityArea()));
        statusColumn.setCellValueFactory(cellData -> 
            new javafx.beans.property.SimpleStringProperty(cellData.getValue().getStatus()));
        lastInspectionDateColumn.setCellValueFactory(cellData -> 
            new javafx.beans.property.SimpleStringProperty(
                cellData.getValue().getLastInspectionDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
            ));
        nextScheduledAuditDateColumn.setCellValueFactory(cellData -> 
            new javafx.beans.property.SimpleStringProperty(
                cellData.getValue().getNextScheduledAuditDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
            ));
        
        // Set up filtering
        setupFiltering();
        
        // Set up table selection listener
        securityAuditsTableView.getSelectionModel().selectedItemProperty().addListener(
            (observable, oldValue, newValue) -> {
                if (newValue != null) {
                    showAuditDetails(newValue);
                }
            }
        );
    }

    private void setupFiltering() {
        filteredData = new FilteredList<>(securityAuditsData, p -> true);
        
        SortedList<SecurityAudit> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(securityAuditsTableView.comparatorProperty());
        securityAuditsTableView.setItems(sortedData);
    }

    private void showAuditDetails(SecurityAudit audit) {
        // Display audit details
        System.out.println("Selected audit: " + audit.getId() + " - " + audit.getSecurityArea());
    }

    @FXML
    protected void onBackClick() {
        Stage currentStage = (Stage) backButton.getScene().getWindow();
        NavigationUtil.navigateToSecurityManagerDashboard(currentStage);
    }

    @FXML
    protected void onAuditReportClick() {
        System.out.println("Audit Report clicked");
        // TODO: Implement audit report generation
    }

    @FXML
    protected void onSystemStatusClick() {
        System.out.println("System Status clicked");
        // TODO: Implement system status monitoring
    }

    @FXML
    protected void onProtocolUpdatesClick() {
        System.out.println("Protocol Updates clicked");
        // TODO: Implement protocol update functionality
    }

    @FXML
    protected void onLoadClick() {
        System.out.println("Load clicked");
        // TODO: Implement data loading from database
        showAlert("Success", "Security audits data loaded successfully!");
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    // Inner class for security audits
    public static class SecurityAudit {
        private String id;
        private String securityArea;
        private String status;
        private LocalDateTime lastInspectionDate;
        private LocalDateTime nextScheduledAuditDate;

        public SecurityAudit(String id, String securityArea, String status, LocalDateTime lastInspectionDate, LocalDateTime nextScheduledAuditDate) {
            this.id = id;
            this.securityArea = securityArea;
            this.status = status;
            this.lastInspectionDate = lastInspectionDate;
            this.nextScheduledAuditDate = nextScheduledAuditDate;
        }

        public String getId() { return id; }
        public void setId(String id) { this.id = id; }

        public String getSecurityArea() { return securityArea; }
        public void setSecurityArea(String securityArea) { this.securityArea = securityArea; }

        public String getStatus() { return status; }
        public void setStatus(String status) { this.status = status; }

        public LocalDateTime getLastInspectionDate() { return lastInspectionDate; }
        public void setLastInspectionDate(LocalDateTime lastInspectionDate) { this.lastInspectionDate = lastInspectionDate; }

        public LocalDateTime getNextScheduledAuditDate() { return nextScheduledAuditDate; }
        public void setNextScheduledAuditDate(LocalDateTime nextScheduledAuditDate) { this.nextScheduledAuditDate = nextScheduledAuditDate; }
    }
}

