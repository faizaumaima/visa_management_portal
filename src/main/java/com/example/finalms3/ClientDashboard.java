package com.example.finalms3;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import com.example.finalms3.utils.NavigationUtil;

public class ClientDashboard {
    
    @FXML
    private Button myApplicationButton;
    
    @FXML
    private Button citizenServicesButton;
    
    @FXML
    private Button eventsButton;
    
    @FXML
    private Button medicalTravelGuideButton;
    
    @FXML
    private Button assistanceButton;
    
    @FXML
    private Button passportServicesButton;
    
    @FXML
    private Button signOutButton;
    
    @FXML
    protected void onMyApplicationClick() {
        Stage currentStage = (Stage) myApplicationButton.getScene().getWindow();
        NavigationUtil.navigateToMyApplication(currentStage);
    }
    
    @FXML
    protected void onCitizenServicesClick() {
        Stage currentStage = (Stage) citizenServicesButton.getScene().getWindow();
        NavigationUtil.navigateToCitizenServices(currentStage);
    }
    
    @FXML
    protected void onEventsClick() {
        Stage currentStage = (Stage) eventsButton.getScene().getWindow();
        NavigationUtil.navigateToEvents(currentStage);
    }
    
    @FXML
    protected void onMedicalTravelGuideClick() {
        // TODO: Implement Medical Travel Guide functionality
        System.out.println("Medical Travel Guide clicked");
    }
    
    @FXML
    protected void onAssistanceClick() {
        Stage currentStage = (Stage) assistanceButton.getScene().getWindow();
        NavigationUtil.navigateToAssistance(currentStage);
    }
    
    @FXML
    protected void onPassportServicesClick() {
        Stage currentStage = (Stage) passportServicesButton.getScene().getWindow();
        NavigationUtil.navigateToPassportServices(currentStage);
    }
    
    @FXML
    protected void onSignOutClick() {
        Stage currentStage = (Stage) signOutButton.getScene().getWindow();
        NavigationUtil.navigateTo("/com/example/finalms3/hello-view.fxml", currentStage, "E-Visa Management Portal - Welcome");
    }
}
