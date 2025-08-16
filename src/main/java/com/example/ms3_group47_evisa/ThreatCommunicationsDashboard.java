package com.example.ms3_group47_evisa;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import com.example.ms3_group47_evisa.utils.NavigationUtil;

public class ThreatCommunicationsDashboard {

    @FXML
    private Button backButton;
    
    @FXML
    private Button sendAlertButton;
    
    @FXML
    private Button updateThreatLevelButton;
    
    @FXML
    private Button broadcastMessageButton;

    @FXML
    public void initialize() {
        // Initialize any necessary setup
    }

    @FXML
    protected void onBackClick() {
        Stage currentStage = (Stage) backButton.getScene().getWindow();
        NavigationUtil.navigateToSecurityManagerDashboard(currentStage);
    }

    @FXML
    protected void onSendAlertClick() {
        // Handle Send Alert button click
        System.out.println("Send Alert clicked");
        // TODO: Implement alert sending functionality
    }

    @FXML
    protected void onUpdateThreatLevelClick() {
        // Handle Update Threat Level button click
        System.out.println("Update Threat Level clicked");
        // TODO: Implement threat level update functionality
    }

    @FXML
    protected void onBroadcastMessageClick() {
        // Handle Broadcast Message button click
        System.out.println("Broadcast Message clicked");
        // TODO: Implement message broadcasting functionality
    }
}
