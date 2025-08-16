package com.example.finalms3.models;

import java.time.LocalDateTime;

public class AccessControl {
    private String id;
    private String areaName;
    private String accessLevel;
    private String cardType;
    private String timeRestrictions;
    private String authorizedPersonnel;
    private LocalDateTime lastAccess;
    private String status;
    private String notes;

    public AccessControl(String id, String areaName, String accessLevel, String cardType) {
        this.id = id;
        this.areaName = areaName;
        this.accessLevel = accessLevel;
        this.cardType = cardType;
        this.status = "ACTIVE";
        this.lastAccess = LocalDateTime.now();
    }

    public AccessControl(String id, String areaName, String accessLevel, String cardType,
                         String timeRestrictions, String authorizedPersonnel, String notes) {
        this.id = id;
        this.areaName = areaName;
        this.accessLevel = accessLevel;
        this.cardType = cardType;
        this.timeRestrictions = timeRestrictions;
        this.authorizedPersonnel = authorizedPersonnel;
        this.notes = notes;
        this.status = "ACTIVE";
        this.lastAccess = LocalDateTime.now();
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getAreaName() { return areaName; }
    public void setAreaName(String areaName) { this.areaName = areaName; }

    public String getAccessLevel() { return accessLevel; }
    public void setAccessLevel(String accessLevel) { this.accessLevel = accessLevel; }

    public String getCardType() { return cardType; }
    public void setCardType(String cardType) { this.cardType = cardType; }

    public String getTimeRestrictions() { return timeRestrictions; }
    public void setTimeRestrictions(String timeRestrictions) { this.timeRestrictions = timeRestrictions; }

    public String getAuthorizedPersonnel() { return authorizedPersonnel; }
    public void setAuthorizedPersonnel(String authorizedPersonnel) { this.authorizedPersonnel = authorizedPersonnel; }

    public LocalDateTime getLastAccess() { return lastAccess; }
    public void setLastAccess(LocalDateTime lastAccess) { this.lastAccess = lastAccess; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }
}
