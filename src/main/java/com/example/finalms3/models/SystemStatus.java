package com.example.finalms3.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SystemStatus {
    private String systemName;
    private String status;
    private String operator;
    private LocalDateTime lastUpdate;
    private String description;
    private String location;

    public SystemStatus(String systemName, String status, String operator) {
        this.systemName = systemName;
        this.status = status;
        this.operator = operator;
        this.lastUpdate = LocalDateTime.now();
    }

    public SystemStatus(String systemName, String status, String operator, String description, String location) {
        this.systemName = systemName;
        this.status = status;
        this.operator = operator;
        this.description = description;
        this.location = location;
        this.lastUpdate = LocalDateTime.now();
    }

    // Getters and Setters
    public String getSystemName() { return systemName; }
    public void setSystemName(String systemName) { this.systemName = systemName; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getOperator() { return operator; }
    public void setOperator(String operator) { this.operator = operator; }

    public String getLastUpdate() { 
        return lastUpdate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")); 
    }
    public void updateLastUpdate() { this.lastUpdate = LocalDateTime.now(); }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
}
