package com.example.finalms3.models;

import java.time.LocalDate;

public class Application {
    private String id;
    private String name;
    private String email;
    private String phoneNumber;
    private LocalDate dateOfBirth;
    private String nationality;
    private String tourDestination;
    private LocalDate dateOfArrival;
    private String visitPurpose;
    private String documentType;
    private String status;
    private LocalDate applicationDate;
    private String assignedOfficer;

    public Application() {
        this.applicationDate = LocalDate.now();
        this.status = "PENDING";
    }

    public Application(String name, String email, String phoneNumber, LocalDate dateOfBirth,
                       String nationality, String tourDestination, LocalDate dateOfArrival,
                       String visitPurpose, String documentType) {
        this();
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.nationality = nationality;
        this.tourDestination = tourDestination;
        this.dateOfArrival = dateOfArrival;
        this.visitPurpose = visitPurpose;
        this.documentType = documentType;
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public LocalDate getDateOfBirth() { return dateOfBirth; }
    public void setDateOfBirth(LocalDate dateOfBirth) { this.dateOfBirth = dateOfBirth; }

    public String getNationality() { return nationality; }
    public void setNationality(String nationality) { this.nationality = nationality; }

    public String getTourDestination() { return tourDestination; }
    public void setTourDestination(String tourDestination) { this.tourDestination = tourDestination; }

    public LocalDate getDateOfArrival() { return dateOfArrival; }
    public void setDateOfArrival(LocalDate dateOfArrival) { this.dateOfArrival = dateOfArrival; }

    public String getVisitPurpose() { return visitPurpose; }
    public void setVisitPurpose(String visitPurpose) { this.visitPurpose = visitPurpose; }

    public String getDocumentType() { return documentType; }
    public void setDocumentType(String documentType) { this.documentType = documentType; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDate getApplicationDate() { return applicationDate; }
    public void setApplicationDate(LocalDate applicationDate) { this.applicationDate = applicationDate; }

    public String getAssignedOfficer() { return assignedOfficer; }
    public void setAssignedOfficer(String assignedOfficer) { this.assignedOfficer = assignedOfficer; }

    @Override
    public String toString() {
        return "Application{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", applicationDate=" + applicationDate +
                '}';
    }
}
