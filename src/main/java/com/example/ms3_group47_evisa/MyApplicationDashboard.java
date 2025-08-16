package com.example.ms3_group47_evisa;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import com.example.ms3_group47_evisa.utils.NavigationUtil;
import com.example.ms3_group47_evisa.services.DataService;
import com.example.ms3_group47_evisa.models.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.time.LocalDate;

public class MyApplicationDashboard {

    @FXML
    private Label clientmyapplicationLabel;

    @FXML
    private DatePicker dateofanivalDatePicker;

    @FXML
    private DatePicker dateofbirthDatePicker;

    @FXML
    private ComboBox<String> documenttypeComboBox;

    @FXML
    private TextField emailTextField;

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField nationalityTextField;

    @FXML
    private TextField phoneNumberTextField;

    @FXML
    private TextField tourdestiratioTextField;

    @FXML
    private TextField visitofpurposeTextField;

    @FXML
    private TableView<Application> applicationsTableView;

    @FXML
    private TableColumn<Application, String> idColumn;

    @FXML
    private TableColumn<Application, String> nameColumn;

    @FXML
    private TableColumn<Application, String> statusColumn;

    @FXML
    private TableColumn<Application, LocalDate> dateColumn;

    // Additional buttons from FXML
    @FXML
    private Button backButton;
    
    @FXML
    private Button startNewApplicationButton;
    
    @FXML
    private Button interviewScheduleButton;
    
    @FXML
    private Button uploadDocumentButton;
    
    @FXML
    private Button submitButton;

    private DataService dataService;

    @FXML
    public void initialize() {
        dataService = DataService.getInstance();
        
        // Initialize document type combo box
        ObservableList<String> documentTypes = FXCollections.observableArrayList(
            "Passport", "Visa", "Residence Permit", "Work Permit", "Student Visa"
        );
        documenttypeComboBox.setItems(documentTypes);
        
        // Initialize table columns
        idColumn.setCellValueFactory(cellData -> 
            new javafx.beans.property.SimpleStringProperty(cellData.getValue().getId()));
        nameColumn.setCellValueFactory(cellData -> 
            new javafx.beans.property.SimpleStringProperty(cellData.getValue().getName()));
        statusColumn.setCellValueFactory(cellData -> 
            new javafx.beans.property.SimpleStringProperty(cellData.getValue().getStatus()));
        dateColumn.setCellValueFactory(cellData -> 
            new javafx.beans.property.SimpleObjectProperty<>(cellData.getValue().getApplicationDate()));
        
        // Load existing applications
        loadApplications();
    }

    private void loadApplications() {
        applicationsTableView.setItems(dataService.getAllApplications());
    }

    @FXML
    protected void onUploadDocumentClick() {
        // Create file chooser for document upload
        javafx.stage.FileChooser fileChooser = new javafx.stage.FileChooser();
        fileChooser.setTitle("Upload Document");
        fileChooser.getExtensionFilters().addAll(
            new javafx.stage.FileChooser.ExtensionFilter("PDF Files", "*.pdf"),
            new javafx.stage.FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg"),
            new javafx.stage.FileChooser.ExtensionFilter("All Files", "*.*")
        );
        
        Stage stage = (Stage) clientmyapplicationLabel.getScene().getWindow();
        java.io.File selectedFile = fileChooser.showOpenDialog(stage);
        
        if (selectedFile != null) {
            showAlert("Success", "Document uploaded successfully: " + selectedFile.getName());
        }
    }

    @FXML
    protected void onBackClick() {
        Stage currentStage = (Stage) clientmyapplicationLabel.getScene().getWindow();
        NavigationUtil.navigateToClientDashboard(currentStage);
    }

    @FXML
    protected void onInterviewScheduleClick() {
        Application selectedApplication = applicationsTableView.getSelectionModel().getSelectedItem();
        if (selectedApplication != null) {
            showAlert("Interview Scheduling", 
                "Interview scheduled for application " + selectedApplication.getId() + 
                "\nYou will receive a confirmation email with details.");
        } else {
            showAlert("Error", "Please select an application first.");
        }
    }

    @FXML
    protected void onStartNewApplicationClick() {
        clearForm();
    }

    @FXML
    protected void onSubmitClick() {
        if (validateForm()) {
            Application newApplication = new Application(
                nameTextField.getText(),
                emailTextField.getText(),
                phoneNumberTextField.getText(),
                dateofbirthDatePicker.getValue(),
                nationalityTextField.getText(),
                tourdestiratioTextField.getText(),
                dateofanivalDatePicker.getValue(),
                visitofpurposeTextField.getText(),
                documenttypeComboBox.getValue()
            );
            
            dataService.addApplication(newApplication);
            loadApplications();
            clearForm();
            showAlert("Success", "Application submitted successfully!");
        }
    }

    private boolean validateForm() {
        if (nameTextField.getText().isEmpty() || emailTextField.getText().isEmpty() ||
            phoneNumberTextField.getText().isEmpty() || nationalityTextField.getText().isEmpty() ||
            tourdestiratioTextField.getText().isEmpty() || visitofpurposeTextField.getText().isEmpty() ||
            dateofbirthDatePicker.getValue() == null || dateofanivalDatePicker.getValue() == null ||
            documenttypeComboBox.getValue() == null) {
            
            showAlert("Validation Error", "Please fill in all required fields.");
            return false;
        }
        
        if (dateofanivalDatePicker.getValue().isBefore(LocalDate.now())) {
            showAlert("Validation Error", "Date of arrival cannot be in the past.");
            return false;
        }
        
        return true;
    }

    private void clearForm() {
        nameTextField.clear();
        emailTextField.clear();
        phoneNumberTextField.clear();
        nationalityTextField.clear();
        tourdestiratioTextField.clear();
        visitofpurposeTextField.clear();
        dateofbirthDatePicker.setValue(null);
        dateofanivalDatePicker.setValue(null);
        documenttypeComboBox.setValue(null);
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}

