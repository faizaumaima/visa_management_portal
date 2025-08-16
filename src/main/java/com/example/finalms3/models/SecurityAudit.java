package com.example.finalms3.models;

import java.time.LocalDateTime;

public class SecurityAudit {
    private String id;
    private String securityArea;
    private String status;
    private LocalDateTime lastInspectionDate;
    private LocalDateTime nextScheduledAuditDate;
    private String auditor;
    private String findings;
    private String recommendations;

    public SecurityAudit(String id, String securityArea, String status, LocalDateTime lastInspectionDate, LocalDateTime nextScheduledAuditDate) {
        this.id = id;
        this.securityArea = securityArea;
        this.status = status;
        this.lastInspectionDate = lastInspectionDate;
        this.nextScheduledAuditDate = nextScheduledAuditDate;
        this.auditor = "System";
    }

    public SecurityAudit(String id, String securityArea, String status, LocalDateTime lastInspectionDate, LocalDateTime nextScheduledAuditDate, String auditor, String findings, String recommendations) {
        this.id = id;
        this.securityArea = securityArea;
        this.status = status;
        this.lastInspectionDate = lastInspectionDate;
        this.nextScheduledAuditDate = nextScheduledAuditDate;
        this.auditor = auditor;
        this.findings = findings;
        this.recommendations = recommendations;
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getSecurityArea() { return securityArea; }
    public void setSecurityArea(String securityArea) { this.securityArea = securityArea; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDateTime getLastInspectionDate() { return lastInspectionDate; }
    public void setLastInspectionDate(LocalDateTime lastInspectionDate) { this.lastInspectionDate = lastInspectionDate; }

    public LocalDateTime getNextScheduledAuditDate() { return nextScheduledAuditDate; }
    public void setNextScheduledAuditDate(LocalDateTime nextScheduledAuditDate) { this.nextScheduledAuditDate = nextScheduledAuditDate; }

    public String getAuditor() { return auditor; }
    public void setAuditor(String auditor) { this.auditor = auditor; }

    public String getFindings() { return findings; }
    public void setFindings(String findings) { this.findings = findings; }

    public String getRecommendations() { return recommendations; }
    public void setRecommendations(String recommendations) { this.recommendations = recommendations; }
}
