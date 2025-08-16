package com.example.ms3_group47_evisa.models;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class CitizenServiceRequest {
    private String id;
    private String name;
    private String phoneNumber;
    private String email;
    private String nationality;
    private LocalDate dateOfBirth;
    private String visitPurpose;
    private String tourDestination;
    private LocalDate dateOfArrival;
    private String documentType;
    private String status;
    private LocalDateTime requestDate;
    private String notes;

    public CitizenServiceRequest(String id, String name, String phoneNumber, String email, String nationality, 
                               LocalDate dateOfBirth, String visitPurpose, String tourDestination, LocalDate dateOfArrival) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.nationality = nationality;
        this.dateOfBirth = dateOfBirth;
        this.visitPurpose = visitPurpose;
        this.tourDestination = tourDestination;
        this.dateOfArrival = dateOfArrival;
        this.status = "PENDING";
        this.requestDate = LocalDateTime.now();
    }

    public CitizenServiceRequest(String id, String name, String phoneNumber, String email, String nationality, 
                               LocalDate dateOfBirth, String visitPurpose, String tourDestination, LocalDate dateOfArrival,
                               String documentType, String status, String notes) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.nationality = nationality;
        this.dateOfBirth = dateOfBirth;
        this.visitPurpose = visitPurpose;
        this.tourDestination = tourDestination;
        this.dateOfArrival = dateOfArrival;
        this.documentType = documentType;
        this.status = status;
        this.notes = notes;
        this.requestDate = LocalDateTime.now();
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getNationality() { return nationality; }
    public void setNationality(String nationality) { this.nationality = nationality; }

    public LocalDate getDateOfBirth() { return dateOfBirth; }
    public void setDateOfBirth(LocalDate dateOfBirth) { this.dateOfBirth = dateOfBirth; }

    public String getVisitPurpose() { return visitPurpose; }
    public void setVisitPurpose(String visitPurpose) { this.visitPurpose = visitPurpose; }

    public String getTourDestination() { return tourDestination; }
    public void setTourDestination(String tourDestination) { this.tourDestination = tourDestination; }

    public LocalDate getDateOfArrival() { return dateOfArrival; }
    public void setDateOfArrival(LocalDate dateOfArrival) { this.dateOfArrival = dateOfArrival; }

    public String getDocumentType() { return documentType; }
    public void setDocumentType(String documentType) { this.documentType = documentType; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDateTime getRequestDate() { return requestDate; }
    public void setRequestDate(LocalDateTime requestDate) { this.requestDate = requestDate; }

    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }
}
