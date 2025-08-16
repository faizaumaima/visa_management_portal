package com.example.finalms3;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import com.example.finalms3.utils.NavigationUtil;
import com.example.finalms3.services.DataService;
import com.example.finalms3.models.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import java.time.LocalDate;

public class PassportSevicesDashboard {

    @FXML
    private TableView<Application> passportApplicationsTableView;

    @FXML
    private TableColumn<Application, String> idColumn;

    @FXML
    private TableColumn<Application, String> nameColumn;

    @FXML
    private TableColumn<Application, String> emailColumn;

    @FXML
    private TableColumn<Application, String> documentTypeColumn;

    @FXML
    private TableColumn<Application, String> statusColumn;

    @FXML
    private TableColumn<Application, LocalDate> applicationDateColumn;

    @FXML
    private TextField searchTextField;

    @FXML
    private ComboBox<String> statusFilterComboBox;

    @FXML
    private ComboBox<String> serviceTypeFilterComboBox;

    @FXML
    private Button processApplicationButton;

    @FXML
    private Button issuePassportButton;

    @FXML
    private Button requestAdditionalDocumentsButton;

    @FXML
    private Button backButton;

    @FXML
    private TextArea applicationDetailsTextArea;

    @FXML
    private Label totalPassportApplicationsLabel;

    @FXML
    private Label processedApplicationsLabel;

    // Additional buttons from FXML
    @FXML
    private Button beginNewApplicationButton;
    
    @FXML
    private Button renewExistingPassportButton;
    
    @FXML
    private Button paymentButton;
    
    @FXML
    private Button passportStatusButton;
    
    @FXML
    private Button uploadDocumentsButton;
    
    @FXML
    private Button scheduleAppointmentButton;
    
    @FXML
    private Button verifyButton;

    private DataService dataService;
    private FilteredList<Application> filteredData;

    @FXML
    public void initialize() {
        dataService = DataService.getInstance();
        
        // Initialize filter combo boxes
        ObservableList<String> statusOptions = FXCollections.observableArrayList(
            "All", "PENDING", "APPROVED", "REJECTED", "UNDER REVIEW", "PROCESSING"
        );
        statusFilterComboBox.setItems(statusOptions);
        statusFilterComboBox.setValue("All");
        
        ObservableList<String> serviceTypes = FXCollections.observableArrayList(
            "All", "New Passport", "Passport Renewal", "Passport Replacement", "Emergency Passport"
        );
        serviceTypeFilterComboBox.setItems(serviceTypes);
        serviceTypeFilterComboBox.setValue("All");
        
        // Initialize table columns
        idColumn.setCellValueFactory(cellData -> 
            new javafx.beans.property.SimpleStringProperty(cellData.getValue().getId()));
        nameColumn.setCellValueFactory(cellData -> 
            new javafx.beans.property.SimpleStringProperty(cellData.getValue().getName()));
        emailColumn.setCellValueFactory(cellData -> 
            new javafx.beans.property.SimpleStringProperty(cellData.getValue().getEmail()));
        documentTypeColumn.setCellValueFactory(cellData -> 
            new javafx.beans.property.SimpleStringProperty(cellData.getValue().getDocumentType()));
        statusColumn.setCellValueFactory(cellData -> 
            new javafx.beans.property.SimpleStringProperty(cellData.getValue().getStatus()));
        applicationDateColumn.setCellValueFactory(cellData -> 
            new javafx.beans.property.SimpleObjectProperty<>(cellData.getValue().getApplicationDate()));
        
        // Set up filtering
        setupFiltering();
        
        // Load applications
        loadPassportApplications();
        
        // Set up table selection listener
        passportApplicationsTableView.getSelectionModel().selectedItemProperty().addListener(
            (observable, oldValue, newValue) -> {
                if (newValue != null) {
                    showApplicationDetails(newValue);
                }
            }
        );
        
        // Update statistics
        updateStatistics();
    }

    private void setupFiltering() {
        // Filter only passport-related applications
        filteredData = new FilteredList<>(
            dataService.getAllApplications().filtered(app -> 
                app.getDocumentType() != null && 
                (app.getDocumentType().contains("Passport") || app.getDocumentType().equals("Passport"))
            ), 
            p -> true
        );
        
        // Search filter
        searchTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(application -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                
                String lowerCaseFilter = newValue.toLowerCase();
                return application.getName().toLowerCase().contains(lowerCaseFilter) ||
                       application.getEmail().toLowerCase().contains(lowerCaseFilter) ||
                       application.getId().toLowerCase().contains(lowerCaseFilter);
            });
        });
        
        // Status filter
        statusFilterComboBox.valueProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(application -> {
                if (newValue == null || newValue.equals("All")) {
                    return true;
                }
                return application.getStatus().equals(newValue);
            });
        });
        
        // Service type filter
        serviceTypeFilterComboBox.valueProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(application -> {
                if (newValue == null || newValue.equals("All")) {
                    return true;
                }
                return application.getDocumentType().equals(newValue);
            });
        });
        
        SortedList<Application> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(passportApplicationsTableView.comparatorProperty());
        passportApplicationsTableView.setItems(sortedData);
    }

    private void loadPassportApplications() {
        // Data is loaded through the filtered list
    }

    private void showApplicationDetails(Application application) {
        StringBuilder details = new StringBuilder();
        details.append("Application ID: ").append(application.getId()).append("\n\n");
        details.append("Name: ").append(application.getName()).append("\n");
        details.append("Email: ").append(application.getEmail()).append("\n");
        details.append("Phone: ").append(application.getPhoneNumber()).append("\n");
        details.append("Date of Birth: ").append(application.getDateOfBirth()).append("\n");
        details.append("Nationality: ").append(application.getNationality()).append("\n");
        details.append("Document Type: ").append(application.getDocumentType()).append("\n");
        details.append("Status: ").append(application.getStatus()).append("\n");
        details.append("Application Date: ").append(application.getApplicationDate()).append("\n");
        details.append("Assigned Officer: ").append(application.getAssignedOfficer()).append("\n\n");
        details.append("Additional Information:\n");
        details.append("Tour Destination: ").append(application.getTourDestination()).append("\n");
        details.append("Date of Arrival: ").append(application.getDateOfArrival()).append("\n");
        details.append("Visit Purpose: ").append(application.getVisitPurpose());
        
        applicationDetailsTextArea.setText(details.toString());
    }

    private void updateStatistics() {
        long totalCount = dataService.getAllApplications().stream()
            .filter(app -> app.getDocumentType() != null && 
                         (app.getDocumentType().contains("Passport") || app.getDocumentType().equals("Passport")))
            .count();
        
        long processedCount = dataService.getAllApplications().stream()
            .filter(app -> app.getDocumentType() != null && 
                         (app.getDocumentType().contains("Passport") || app.getDocumentType().equals("Passport")) &&
                         ("APPROVED".equals(app.getStatus()) || "PROCESSING".equals(app.getStatus())))
            .count();
        
        totalPassportApplicationsLabel.setText("Total Passport Applications: " + totalCount);
        processedApplicationsLabel.setText("Processed Applications: " + processedCount);
    }

    @FXML
    protected void onProcessApplicationClick() {
        Application selectedApplication = passportApplicationsTableView.getSelectionModel().getSelectedItem();
        if (selectedApplication != null) {
            selectedApplication.setStatus("PROCESSING");
            dataService.updateApplication(selectedApplication);
            loadPassportApplications();
            updateStatistics();
            showAlert("Success", "Application " + selectedApplication.getId() + " is now being processed.");
        } else {
            showAlert("Error", "Please select an application first.");
        }
    }

    @FXML
    protected void onIssuePassportClick() {
        Application selectedApplication = passportApplicationsTableView.getSelectionModel().getSelectedItem();
        if (selectedApplication != null) {
            selectedApplication.setStatus("APPROVED");
            dataService.updateApplication(selectedApplication);
            loadPassportApplications();
            updateStatistics();
            showAlert("Success", "Passport issued for application " + selectedApplication.getId() + 
                "\nPassport number will be generated and sent to the applicant.");
        } else {
            showAlert("Error", "Please select an application first.");
        }
    }

    @FXML
    protected void onRequestAdditionalDocumentsClick() {
        Application selectedApplication = passportApplicationsTableView.getSelectionModel().getSelectedItem();
        if (selectedApplication != null) {
            selectedApplication.setStatus("UNDER REVIEW");
            dataService.updateApplication(selectedApplication);
            loadPassportApplications();
            updateStatistics();
            showAlert("Success", "Additional document request sent for application " + selectedApplication.getId());
        } else {
            showAlert("Error", "Please select an application first.");
        }
    }

    @FXML
    protected void onBackClick() {
        Stage currentStage = (Stage) backButton.getScene().getWindow();
        NavigationUtil.navigateToClientDashboard(currentStage);
    }

    // Additional event handlers from FXML
    @FXML
    protected void onBeginNewApplicationClick() {
        // Handle Begin New Application button click
        System.out.println("Begin New Application clicked");
        // TODO: Implement new application functionality
    }

    @FXML
    protected void onRenewExistingPassportClick() {
        // Handle Renew Existing Passport button click
        System.out.println("Renew Existing Passport clicked");
        // TODO: Implement passport renewal functionality
    }

    @FXML
    protected void onPaymentClick() {
        // Handle Payment button click
        System.out.println("Payment clicked");
        // TODO: Implement payment functionality
    }

    @FXML
    protected void onPassportStatusClick() {
        // Handle Passport Status button click
        System.out.println("Passport Status clicked");
        // TODO: Implement passport status functionality
    }

    @FXML
    protected void onUploadDocumentsClick() {
        // Handle Upload Documents button click
        System.out.println("Upload Documents clicked");
        // TODO: Implement document upload functionality
    }

    @FXML
    protected void onScheduleAppointmentClick() {
        // Handle Schedule Appointment button click
        System.out.println("Schedule Appointment clicked");
        // TODO: Implement appointment scheduling functionality
    }

    @FXML
    protected void onVerifyClick() {
        // Handle Verify button click
        System.out.println("Verify clicked");
        // TODO: Implement verification functionality
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}

