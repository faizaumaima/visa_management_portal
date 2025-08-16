package com.example.finalms3;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import com.example.finalms3.utils.NavigationUtil;

public class SecurityManagerDashboard {
    
    @FXML
    private Button securityOperationsButton;
    
    @FXML
    private Button incidentReportsButton;
    
    @FXML
    private Button trainingModulesButton;
    
    @FXML
    private Button securityAuditsButton;
    
    @FXML
    private Button threatCommunicationButton;
    
    @FXML
    private Button emergencyPlansButton;
    
    @FXML
    private Button evaluationButton;
    
    @FXML
    private Button accessControlButton;
    
    @FXML
    private Button controlSystemsButton;
    
    @FXML
    private Button signOutButton;
    
    @FXML
    protected void onSecurityOperationsClick() {
        Stage currentStage = (Stage) securityOperationsButton.getScene().getWindow();
        NavigationUtil.navigateToSecurityOperations(currentStage);
    }
    
    @FXML
    protected void onIncidentReportsClick() {
        Stage currentStage = (Stage) incidentReportsButton.getScene().getWindow();
        NavigationUtil.navigateToIncidentReports(currentStage);
    }
    
    @FXML
    protected void onTrainingModulesClick() {
        // Handle Training Modules button click
        System.out.println("Training Modules clicked");
        // TODO: Implement training modules functionality
    }
    
    @FXML
    protected void onSecurityAuditsClick() {
        Stage currentStage = (Stage) securityAuditsButton.getScene().getWindow();
        NavigationUtil.navigateToSecurityAudits(currentStage);
    }
    
    @FXML
    protected void onThreatCommunicationClick() {
        Stage currentStage = (Stage) threatCommunicationButton.getScene().getWindow();
        NavigationUtil.navigateToThreatCommunications(currentStage);
    }
    
    @FXML
    protected void onEmergencyPlansClick() {
        // Handle Emergency Plans button click
        System.out.println("Emergency Plans clicked");
        // TODO: Implement emergency plans functionality
    }
    
    @FXML
    protected void onEvaluationClick() {
        // Handle Evaluation button click
        System.out.println("Evaluation clicked");
        // TODO: Implement evaluation functionality
    }
    
    @FXML
    protected void onAccessControlClick() {
        // Handle Access Control button click
        System.out.println("Access Control clicked");
        // TODO: Implement access control functionality
    }
    
    @FXML
    protected void onControlSystemsClick() {
        Stage currentStage = (Stage) controlSystemsButton.getScene().getWindow();
        NavigationUtil.navigateToControlSystems(currentStage);
    }
    
    @FXML
    protected void onSignOutClick() {
        Stage currentStage = (Stage) signOutButton.getScene().getWindow();
        NavigationUtil.navigateTo("/com/example/finalms3/hello-view.fxml", currentStage, "E-Visa Management Portal - Welcome");
    }
}


