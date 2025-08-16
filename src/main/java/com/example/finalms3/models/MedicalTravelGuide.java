package com.example.finalms3.models;

import java.time.LocalDateTime;

public class MedicalTravelGuide {
    private String id;
    private String title;
    private String description;
    private String category;
    private String destination;
    private String requirements;
    private String healthTips;
    private String emergencyContacts;
    private LocalDateTime lastUpdated;
    private String status;

    public MedicalTravelGuide(String id, String title, String description, String category, String destination) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.category = category;
        this.destination = destination;
        this.status = "ACTIVE";
        this.lastUpdated = LocalDateTime.now();
    }

    public MedicalTravelGuide(String id, String title, String description, String category, String destination,
                            String requirements, String healthTips, String emergencyContacts) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.category = category;
        this.destination = destination;
        this.requirements = requirements;
        this.healthTips = healthTips;
        this.emergencyContacts = emergencyContacts;
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

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getDestination() { return destination; }
    public void setDestination(String destination) { this.destination = destination; }

    public String getRequirements() { return requirements; }
    public void setRequirements(String requirements) { this.requirements = requirements; }

    public String getHealthTips() { return healthTips; }
    public void setHealthTips(String healthTips) { this.healthTips = healthTips; }

    public String getEmergencyContacts() { return emergencyContacts; }
    public void setEmergencyContacts(String emergencyContacts) { this.emergencyContacts = emergencyContacts; }

    public LocalDateTime getLastUpdated() { return lastUpdated; }
    public void setLastUpdated(LocalDateTime lastUpdated) { this.lastUpdated = lastUpdated; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
