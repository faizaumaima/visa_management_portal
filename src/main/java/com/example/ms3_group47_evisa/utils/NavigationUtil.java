package com.example.ms3_group47_evisa.utils;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Modality;

import java.io.IOException;

public class NavigationUtil {
    
    public static void navigateTo(String fxmlPath, Stage currentStage, String title) {
        try {
            FXMLLoader loader = new FXMLLoader(NavigationUtil.class.getResource(fxmlPath));
            Parent root = loader.load();
            
            Scene scene = new Scene(root);
            currentStage.setTitle(title);
            currentStage.setScene(scene);
            currentStage.show();
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error loading FXML: " + fxmlPath);
        }
    }
    
    public static void navigateToClientDashboard(Stage currentStage) {
        navigateTo("/com/example/ms3_group47_evisa/Client_Dashboard.fxml", currentStage, "E-Visa Management Portal - Client");
    }
    
    public static void navigateToSecurityManagerDashboard(Stage currentStage) {
        navigateTo("/com/example/ms3_group47_evisa/SecurityManager_Dashboard.fxml", currentStage, "E-Visa Management Portal - Security Manager");
    }
    
    public static void navigateToMyApplication(Stage currentStage) {
        navigateTo("/com/example/ms3_group47_evisa/MyApplicationDashboard.fxml", currentStage, "Client - My Application");
    }
    
    public static void navigateToCitizenServices(Stage currentStage) {
        navigateTo("/com/example/ms3_group47_evisa/CitizenServiceDashboard.fxml", currentStage, "Client - Citizen Services");
    }
    
    public static void navigateToEvents(Stage currentStage) {
        navigateTo("/com/example/ms3_group47_evisa/EventsDashboard.fxml", currentStage, "Client - Events");
    }
    
    public static void navigateToAssistance(Stage currentStage) {
        navigateTo("/com/example/ms3_group47_evisa/AssistanceDashboard.fxml", currentStage, "Client - Assistance");
    }
    
    public static void navigateToPassportServices(Stage currentStage) {
        navigateTo("/com/example/ms3_group47_evisa/PassportSevicesDashboard.fxml", currentStage, "Client - Passport Services");
    }
    
    public static void navigateToUpcomingEvents(Stage currentStage) {
        navigateTo("/com/example/ms3_group47_evisa/UpcomingEventsDashboard.fxml", currentStage, "Client - Upcoming Events");
    }
    
    public static void navigateToSecurityOperations(Stage currentStage) {
        navigateTo("/com/example/ms3_group47_evisa/SecurityOperationsDashboard.fxml", currentStage, "Security Manager - Security Operations");
    }
    
    public static void navigateToIncidentReports(Stage currentStage) {
        navigateTo("/com/example/ms3_group47_evisa/IncidentReportsDashboard.fxml", currentStage, "Security Manager - Incident Reports");
    }
    
    public static void navigateToSecurityAudits(Stage currentStage) {
        navigateTo("/com/example/ms3_group47_evisa/SecurityAuditsDashboards.fxml", currentStage, "Security Manager - Security Audits");
    }
    
    public static void navigateToThreatCommunications(Stage currentStage) {
        navigateTo("/com/example/ms3_group47_evisa/ThreatCommunicationsDashboard.fxml", currentStage, "Security Manager - Threat Communications");
    }
    
    public static void navigateToControlSystems(Stage currentStage) {
        navigateTo("/com/example/ms3_group47_evisa/ControlSystemsDashboard.fxml", currentStage, "Security Manager - Control Systems");
    }
    
    public static void showDialog(String fxmlPath, String title) {
        try {
            FXMLLoader loader = new FXMLLoader(NavigationUtil.class.getResource(fxmlPath));
            Parent root = loader.load();
            
            Stage dialogStage = new Stage();
            dialogStage.setTitle(title);
            dialogStage.initModality(Modality.APPLICATION_MODAL);
            dialogStage.setScene(new Scene(root));
            dialogStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error loading dialog FXML: " + fxmlPath);
        }
    }
    
    public static void goBack(Stage currentStage, String previousFxml, String title) {
        navigateTo(previousFxml, currentStage, title);
    }
}
