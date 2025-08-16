package com.example.finalms3;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import com.example.finalms3.utils.NavigationUtil;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
    
    @FXML
    protected void onClientButtonClick() {
        Stage currentStage = (Stage) welcomeText.getScene().getWindow();
        NavigationUtil.navigateToClientDashboard(currentStage);
    }
    
    @FXML
    protected void onSecurityManagerButtonClick() {
        Stage currentStage = (Stage) welcomeText.getScene().getWindow();
        NavigationUtil.navigateToSecurityManagerDashboard(currentStage);
    }
}