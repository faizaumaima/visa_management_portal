package com.example.ms3_group47_evisa;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import com.example.ms3_group47_evisa.utils.NavigationUtil;
import com.example.ms3_group47_evisa.services.DataService;
import com.example.ms3_group47_evisa.models.AssistanceCase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import java.time.LocalDateTime;

public class AssistanceDashboard {

    @FXML
    private TableView<AssistanceCase> casesTableView;

    @FXML
    private TableColumn<AssistanceCase, String> idColumn;

    @FXML
    private TableColumn<AssistanceCase, String> nameColumn;

    @FXML
    private TableColumn<AssistanceCase, String> caseTypeColumn;

    @FXML
    private TableColumn<AssistanceCase, String> statusColumn;

    @FXML
    private TableColumn<AssistanceCase, LocalDateTime> createdDateColumn;

    @FXML
    private TableColumn<AssistanceCase, String> assignedOfficerColumn;

    @FXML
    private TextField nameTextField;

    @FXML
    private ComboBox<String> caseTypeComboBox;

    @FXML
    private TextArea detailsTextArea;

    @FXML
    private TextField searchTextField;

    @FXML
    private ComboBox<String> statusFilterComboBox;

    @FXML
    private Button submitCaseButton;

    @FXML
    private Button updateStatusButton;

    @FXML
    private Button backButton;

    @FXML
    private TextArea caseDetailsTextArea;

    // Additional buttons from FXML
    @FXML
    private Button caseDetailsButton;
    
    @FXML
    private Button reportLostPassportButton;
    
    @FXML
    private Button medicalEmergencyButton;
    
    @FXML
    private Button legalAssistanceButton;
    
    @FXML
    private Button loadButton;
    
    @FXML
    private Button addButton;

    private DataService dataService;
    private FilteredList<AssistanceCase> filteredData;

    @FXML
    public void initialize() {
        dataService = DataService.getInstance();
        
        // Initialize case type combo box
        ObservableList<String> caseTypes = FXCollections.observableArrayList(
            "Lost Passport", "Medical Emergency", "Legal Assistance", "Travel Documentation",
            "Visa Issues", "Financial Assistance", "Other"
        );
        caseTypeComboBox.setItems(caseTypes);
        
        // Initialize status filter combo box
        ObservableList<String> statusOptions = FXCollections.observableArrayList(
            "All", "OPEN", "IN PROGRESS", "RESOLVED", "CLOSED"
        );
        statusFilterComboBox.setItems(statusOptions);
        statusFilterComboBox.setValue("All");
        
        // Initialize table columns
        idColumn.setCellValueFactory(cellData -> 
            new javafx.beans.property.SimpleStringProperty(cellData.getValue().getId()));
        nameColumn.setCellValueFactory(cellData -> 
            new javafx.beans.property.SimpleStringProperty(cellData.getValue().getName()));
        caseTypeColumn.setCellValueFactory(cellData -> 
            new javafx.beans.property.SimpleStringProperty(cellData.getValue().getCaseType()));
        statusColumn.setCellValueFactory(cellData -> 
            new javafx.beans.property.SimpleStringProperty(cellData.getValue().getStatus()));
        createdDateColumn.setCellValueFactory(cellData -> 
            new javafx.beans.property.SimpleObjectProperty<>(cellData.getValue().getCreatedDate()));
        assignedOfficerColumn.setCellValueFactory(cellData -> 
            new javafx.beans.property.SimpleStringProperty(cellData.getValue().getAssignedOfficer()));
        
        // Set up filtering
        setupFiltering();
        
        // Load cases
        loadCases();
        
        // Set up table selection listener
        casesTableView.getSelectionModel().selectedItemProperty().addListener(
            (observable, oldValue, newValue) -> {
                if (newValue != null) {
                    showCaseDetails(newValue);
                }
            }
        );
    }

    private void setupFiltering() {
        filteredData = new FilteredList<>(dataService.getAllAssistanceCases(), p -> true);
        
        // Search filter
        searchTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(case_ -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                
                String lowerCaseFilter = newValue.toLowerCase();
                return case_.getName().toLowerCase().contains(lowerCaseFilter) ||
                       case_.getCaseType().toLowerCase().contains(lowerCaseFilter) ||
                       case_.getId().toLowerCase().contains(lowerCaseFilter);
            });
        });
        
        // Status filter
        statusFilterComboBox.valueProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(case_ -> {
                if (newValue == null || newValue.equals("All")) {
                    return true;
                }
                return case_.getStatus().equals(newValue);
            });
        });
        
        SortedList<AssistanceCase> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(casesTableView.comparatorProperty());
        casesTableView.setItems(sortedData);
    }

    private void loadCases() {
        // Data is loaded through the filtered list
    }

    private void showCaseDetails(AssistanceCase case_) {
        StringBuilder details = new StringBuilder();
        details.append("Case ID: ").append(case_.getId()).append("\n\n");
        details.append("Name: ").append(case_.getName()).append("\n");
        details.append("Case Type: ").append(case_.getCaseType()).append("\n");
        details.append("Status: ").append(case_.getStatus()).append("\n");
        details.append("Created Date: ").append(case_.getCreatedDate()).append("\n");
        details.append("Assigned Officer: ").append(case_.getAssignedOfficer()).append("\n\n");
        details.append("Details:\n").append(case_.getDetails());
        
        caseDetailsTextArea.setText(details.toString());
    }

    @FXML
    protected void onSubmitCaseClick() {
        if (validateCaseForm()) {
            AssistanceCase newCase = new AssistanceCase(
                nameTextField.getText(),
                caseTypeComboBox.getValue(),
                detailsTextArea.getText()
            );
            
            dataService.addAssistanceCase(newCase);
            loadCases();
            clearForm();
            showAlert("Success", "Assistance case submitted successfully!\nCase ID: " + newCase.getId());
        }
    }

    @FXML
    protected void onUpdateStatusClick() {
        AssistanceCase selectedCase = casesTableView.getSelectionModel().getSelectedItem();
        if (selectedCase != null) {
            // Create status update dialog
            ChoiceDialog<String> dialog = new ChoiceDialog<>("OPEN", "OPEN", "IN PROGRESS", "RESOLVED", "CLOSED");
            dialog.setTitle("Update Case Status");
            dialog.setHeaderText("Update status for case: " + selectedCase.getId());
            dialog.setContentText("Select new status:");
            
            dialog.showAndWait().ifPresent(newStatus -> {
                selectedCase.setStatus(newStatus);
                dataService.updateAssistanceCase(selectedCase);
                loadCases();
                showAlert("Success", "Case status updated to: " + newStatus);
            });
        } else {
            showAlert("Error", "Please select a case first.");
        }
    }

    @FXML
    protected void onBackClick() {
        Stage currentStage = (Stage) backButton.getScene().getWindow();
        NavigationUtil.navigateToClientDashboard(currentStage);
    }

    // Additional event handlers from FXML
    @FXML
    protected void onCaseDetailsClick() {
        // Handle Case Details button click
        System.out.println("Case Details clicked");
        // TODO: Implement case details functionality
    }

    @FXML
    protected void onReportLostPassportClick() {
        // Handle Report Lost Passport button click
        System.out.println("Report Lost Passport clicked");
        // TODO: Implement lost passport reporting functionality
    }

    @FXML
    protected void onMedicalEmergencyClick() {
        // Handle Medical Emergency button click
        System.out.println("Medical Emergency clicked");
        // TODO: Implement medical emergency functionality
    }

    @FXML
    protected void onLegalAssistanceClick() {
        // Handle Legal Assistance button click
        System.out.println("Legal Assistance clicked");
        // TODO: Implement legal assistance functionality
    }

    @FXML
    protected void onLoadClick() {
        // Handle Load button click
        System.out.println("Load clicked");
        // TODO: Implement load functionality
    }

    @FXML
    protected void onAddClick() {
        // Handle Add button click
        System.out.println("Add clicked");
        // TODO: Implement add functionality
    }

    private boolean validateCaseForm() {
        if (nameTextField.getText().isEmpty() || caseTypeComboBox.getValue() == null ||
            detailsTextArea.getText().isEmpty()) {
            
            showAlert("Validation Error", "Please fill in all required fields.");
            return false;
        }
        return true;
    }

    private void clearForm() {
        nameTextField.clear();
        caseTypeComboBox.setValue(null);
        detailsTextArea.clear();
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}

