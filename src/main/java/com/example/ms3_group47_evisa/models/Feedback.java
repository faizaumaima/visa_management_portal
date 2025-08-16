package com.example.ms3_group47_evisa.models;

import java.time.LocalDateTime;

public class Feedback {
    private String id;
    private String title;
    private String description;
    private String category;
    private String submittedBy;
    private LocalDateTime submissionDate;
    private String status;
    private String response;
    private LocalDateTime responseDate;
    private String assignedTo;

    public Feedback(String id, String title, String description, String category, String submittedBy) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.category = category;
        this.submittedBy = submittedBy;
        this.submissionDate = LocalDateTime.now();
        this.status = "PENDING";
    }

    public Feedback(String id, String title, String description, String category, String submittedBy,
                   String response, String assignedTo) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.category = category;
        this.submittedBy = submittedBy;
        this.response = response;
        this.assignedTo = assignedTo;
        this.submissionDate = LocalDateTime.now();
        this.status = "IN_PROGRESS";
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

    public String getSubmittedBy() { return submittedBy; }
    public void setSubmittedBy(String submittedBy) { this.submittedBy = submittedBy; }

    public LocalDateTime getSubmissionDate() { return submissionDate; }
    public void setSubmissionDate(LocalDateTime submissionDate) { this.submissionDate = submissionDate; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getResponse() { return response; }
    public void setResponse(String response) { this.response = response; }

    public LocalDateTime getResponseDate() { return responseDate; }
    public void setResponseDate(LocalDateTime responseDate) { this.responseDate = responseDate; }

    public String getAssignedTo() { return assignedTo; }
    public void setAssignedTo(String assignedTo) { this.assignedTo = assignedTo; }
}
