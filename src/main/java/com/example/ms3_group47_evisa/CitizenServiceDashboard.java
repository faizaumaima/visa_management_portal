package com.example.ms3_group47_evisa;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import com.example.ms3_group47_evisa.utils.NavigationUtil;

public class CitizenServiceDashboard {

    @FXML
    private Button citizensServicesOptButton;
    
    @FXML
    private Button paymentButton;
    
    @FXML
    private Button applicationStatusUpdatesButton;
    
    @FXML
    private Button backButton;
    
    @FXML
    private Button uploadDocumentButton;
    
    @FXML
    private Button documentTypeButton;
    
    @FXML
    private Button submitButton;
    
    @FXML
    private TextField nameField;
    
    @FXML
    private TextField phoneField;
    
    @FXML
    private TextField nationalityField;
    
    @FXML
    private TextField visitPurposeField;
    
    @FXML
    private TextField idField;
    
    @FXML
    private TextField emailField;
    
    @FXML
    private DatePicker dateOfBirthPicker;

    @FXML
    public void initialize() {
        // Initialize any necessary setup
    }

    @FXML
    protected void onCitizensServicesOptClick() {
        // Handle Citizens Services Opt button click
        System.out.println("Citizens Services Opt clicked");
        // TODO: Implement citizens services functionality
    }

    @FXML
    protected void onPaymentClick() {
        // Handle Payment button click
        System.out.println("Payment clicked");
        // TODO: Implement payment functionality
    }

    @FXML
    protected void onApplicationStatusUpdatesClick() {
        // Handle Application Status Updates button click
        System.out.println("Application Status Updates clicked");
        // TODO: Implement application status updates functionality
    }

    @FXML
    protected void onBackClick() {
        Stage currentStage = (Stage) backButton.getScene().getWindow();
        NavigationUtil.navigateToClientDashboard(currentStage);
    }

    @FXML
    protected void onUploadDocumentClick() {
        // Handle Upload Document button click
        System.out.println("Upload Document clicked");
        // TODO: Implement document upload functionality
    }

    @FXML
    protected void onDocumentTypeClick() {
        // Handle Document Type button click
        System.out.println("Document Type clicked");
        // TODO: Implement document type selection functionality
    }

    @FXML
    protected void onSubmitClick() {
        // Handle Submit button click
        System.out.println("Submit clicked");
        
        // Validate form fields
        if (validateForm()) {
            // Process the form submission
            processFormSubmission();
            showAlert("Success", "Form submitted successfully!");
            clearForm();
        } else {
            showAlert("Error", "Please fill in all required fields.");
        }
    }

    private boolean validateForm() {
        return nameField.getText() != null && !nameField.getText().trim().isEmpty() &&
               phoneField.getText() != null && !phoneField.getText().trim().isEmpty() &&
               nationalityField.getText() != null && !nationalityField.getText().trim().isEmpty() &&
               visitPurposeField.getText() != null && !visitPurposeField.getText().trim().isEmpty() &&
               idField.getText() != null && !idField.getText().trim().isEmpty() &&
               emailField.getText() != null && !emailField.getText().trim().isEmpty() &&
               dateOfBirthPicker.getValue() != null;
    }

    private void processFormSubmission() {
        // TODO: Implement form processing logic
        // This could involve saving to database, sending to service, etc.
        System.out.println("Processing form submission...");
        System.out.println("Name: " + nameField.getText());
        System.out.println("Phone: " + phoneField.getText());
        System.out.println("Nationality: " + nationalityField.getText());
        System.out.println("Visit Purpose: " + visitPurposeField.getText());
        System.out.println("ID: " + idField.getText());
        System.out.println("Email: " + emailField.getText());
        System.out.println("Date of Birth: " + dateOfBirthPicker.getValue());
    }

    private void clearForm() {
        nameField.clear();
        phoneField.clear();
        nationalityField.clear();
        visitPurposeField.clear();
        idField.clear();
        emailField.clear();
        dateOfBirthPicker.setValue(null);
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
