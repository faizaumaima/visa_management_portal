package com.example.finalms3.models;

import java.time.LocalDateTime;

public class EmergencyPlan {
    private String id;
    private String title;
    private String description;
    private String emergencyType;
    private String responseLevel;
    private String evacuationRoute;
    private String assemblyPoint;
    private String contactPerson;
    private String phoneNumber;
    private LocalDateTime lastUpdated;
    private String status;

    public EmergencyPlan(String id, String title, String description, String emergencyType, String responseLevel) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.emergencyType = emergencyType;
        this.responseLevel = responseLevel;
        this.status = "ACTIVE";
        this.lastUpdated = LocalDateTime.now();
    }

    public EmergencyPlan(String id, String title, String description, String emergencyType, String responseLevel,
                        String evacuationRoute, String assemblyPoint, String contactPerson, String phoneNumber) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.emergencyType = emergencyType;
        this.responseLevel = responseLevel;
        this.evacuationRoute = evacuationRoute;
        this.assemblyPoint = assemblyPoint;
        this.contactPerson = contactPerson;
        this.phoneNumber = phoneNumber;
        this.status = "ACTIVE";
        this.lastUpdated = LocalDateTime.now();
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getEmergencyType() { return emergencyType; }
    public void setEmergencyType(String emergencyType) { this.emergencyType = emergencyType; }

    public String getResponseLevel() { return responseLevel; }
    public void setResponseLevel(String responseLevel) { this.responseLevel = responseLevel; }

    public String getEvacuationRoute() { return evacuationRoute; }
    public void setEvacuationRoute(String evacuationRoute) { this.evacuationRoute = evacuationRoute; }

    public String getAssemblyPoint() { return assemblyPoint; }
    public void setAssemblyPoint(String assemblyPoint) { this.assemblyPoint = assemblyPoint; }

    public String getContactPerson() { return contactPerson; }
    public void setContactPerson(String contactPerson) { this.contactPerson = contactPerson; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public LocalDateTime getLastUpdated() { return lastUpdated; }
    public void setLastUpdated(LocalDateTime lastUpdated) { this.lastUpdated = lastUpdated; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
