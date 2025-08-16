package com.example.finalms3.models;

import java.time.LocalDateTime;

public class TrainingModule {
    private String id;
    private String title;
    private String description;
    private String category;
    private String instructor;
    private LocalDateTime scheduledDate;
    private int duration; // in minutes
    private String status;
    private String location;
    private int maxParticipants;
    private int currentParticipants;

    public TrainingModule(String id, String title, String description, String category, String instructor, 
                         LocalDateTime scheduledDate, int duration) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.category = category;
        this.instructor = instructor;
        this.scheduledDate = scheduledDate;
        this.duration = duration;
        this.status = "SCHEDULED";
        this.maxParticipants = 50;
        this.currentParticipants = 0;
    }

    public TrainingModule(String id, String title, String description, String category, String instructor,
                         LocalDateTime scheduledDate, int duration, String location, int maxParticipants) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.category = category;
        this.instructor = instructor;
        this.scheduledDate = scheduledDate;
        this.duration = duration;
        this.location = location;
        this.maxParticipants = maxParticipants;
        this.currentParticipants = 0;
        this.status = "SCHEDULED";
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

    public String getInstructor() { return instructor; }
    public void setInstructor(String instructor) { this.instructor = instructor; }

    public LocalDateTime getScheduledDate() { return scheduledDate; }
    public void setScheduledDate(LocalDateTime scheduledDate) { this.scheduledDate = scheduledDate; }

    public int getDuration() { return duration; }
    public void setDuration(int duration) { this.duration = duration; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public int getMaxParticipants() { return maxParticipants; }
    public void setMaxParticipants(int maxParticipants) { this.maxParticipants = maxParticipants; }

    public int getCurrentParticipants() { return currentParticipants; }
    public void setCurrentParticipants(int currentParticipants) { this.currentParticipants = currentParticipants; }

    public boolean isAvailable() {
        return currentParticipants < maxParticipants && "SCHEDULED".equals(status);
    }
}
