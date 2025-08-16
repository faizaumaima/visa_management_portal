package com.example.finalms3.models;

import java.time.LocalDateTime;

public class AssistanceCase {
    private String id;
    private String name;
    private String caseType;
    private String details;
    private LocalDateTime createdDate;
    private String status;
    private String assignedOfficer;

    public AssistanceCase() {
        this.createdDate = LocalDateTime.now();
        this.status = "OPEN";
    }

    public AssistanceCase(String name, String caseType, String details) {
        this();
        this.name = name;
        this.caseType = caseType;
        this.details = details;
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCaseType() { return caseType; }
    public void setCaseType(String caseType) { this.caseType = caseType; }

    public String getDetails() { return details; }
    public void setDetails(String details) { this.details = details; }

    public LocalDateTime getCreatedDate() { return createdDate; }
    public void setCreatedDate(LocalDateTime createdDate) { this.createdDate = createdDate; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getAssignedOfficer() { return assignedOfficer; }
    public void setAssignedOfficer(String assignedOfficer) { this.assignedOfficer = assignedOfficer; }

    @Override
    public String toString() {
        return "AssistanceCase{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", caseType='" + caseType + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
