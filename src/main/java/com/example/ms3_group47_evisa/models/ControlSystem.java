package com.example.ms3_group47_evisa.models;

import java.time.LocalDateTime;

public class ControlSystem {
    private String code;
    private String emergencySituation;
    private String responseActions;
    private String responseTeam;
    private LocalDateTime lastUpdated;
    private String status;
    private String description;

    public ControlSystem(String code, String emergencySituation, String responseActions, String responseTeam, LocalDateTime lastUpdated) {
        this.code = code;
        this.emergencySituation = emergencySituation;
        this.responseActions = responseActions;
        this.responseTeam = responseTeam;
        this.lastUpdated = lastUpdated;
        this.status = "ACTIVE";
    }

    public ControlSystem(String code, String emergencySituation, String responseActions, String responseTeam, LocalDateTime lastUpdated, String status, String description) {
        this.code = code;
        this.emergencySituation = emergencySituation;
        this.responseActions = responseActions;
        this.responseTeam = responseTeam;
        this.lastUpdated = lastUpdated;
        this.status = status;
        this.description = description;
    }

    // Getters and Setters
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public String getEmergencySituation() { return emergencySituation; }
    public void setEmergencySituation(String emergencySituation) { this.emergencySituation = emergencySituation; }

    public String getResponseActions() { return responseActions; }
    public void setResponseActions(String responseActions) { this.responseActions = responseActions; }

    public String getResponseTeam() { return responseTeam; }
    public void setResponseTeam(String responseTeam) { this.responseTeam = responseTeam; }

    public LocalDateTime getLastUpdated() { return lastUpdated; }
    public void setLastUpdated(LocalDateTime lastUpdated) { this.lastUpdated = lastUpdated; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}
