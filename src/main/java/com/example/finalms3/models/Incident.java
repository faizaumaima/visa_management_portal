package com.example.finalms3.models;

import java.time.LocalDateTime;

public class Incident {
    private String id;
    private String location;
    private String incidentType;
    private LocalDateTime reportTime;
    private String status;
    private String assignedPerson;
    private String severity;
    private String reportedBy;
    private String description;

    public Incident() {
        this.reportTime = LocalDateTime.now();
        this.status = "OPEN";
    }

    public Incident(String location, String incidentType, String severity, 
                   String reportedBy, String description) {
        this();
        this.location = location;
        this.incidentType = incidentType;
        this.severity = severity;
        this.reportedBy = reportedBy;
        this.description = description;
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public String getIncidentType() { return incidentType; }
    public void setIncidentType(String incidentType) { this.incidentType = incidentType; }

    public LocalDateTime getReportTime() { return reportTime; }
    public void setReportTime(LocalDateTime reportTime) { this.reportTime = reportTime; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getAssignedPerson() { return assignedPerson; }
    public void setAssignedPerson(String assignedPerson) { this.assignedPerson = assignedPerson; }

    public String getSeverity() { return severity; }
    public void setSeverity(String severity) { this.severity = severity; }

    public String getReportedBy() { return reportedBy; }
    public void setReportedBy(String reportedBy) { this.reportedBy = reportedBy; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    @Override
    public String toString() {
        return "Incident{" +
                "id='" + id + '\'' +
                ", location='" + location + '\'' +
                ", incidentType='" + incidentType + '\'' +
                ", status='" + status + '\'' +
                ", severity='" + severity + '\'' +
                '}';
    }
}
