package com.example.ms3_group47_evisa.services;

import com.example.ms3_group47_evisa.models.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class DataService {
    private static DataService instance;
    private final Map<String, Application> applications;
    private final Map<String, Incident> incidents;
    private final Map<String, Event> events;
    private final Map<String, AssistanceCase> assistanceCases;
    private final Map<String, ThreatMessage> threatMessages;
    private final Map<String, ControlSystem> controlSystems;
    private final Map<String, SecurityAudit> securityAudits;
    private final Map<String, SystemStatus> systemStatuses;
    private final Map<String, CitizenServiceRequest> citizenServiceRequests;
    private final Map<String, MedicalTravelGuide> medicalTravelGuides;
    private final Map<String, TrainingModule> trainingModules;
    private final Map<String, EmergencyPlan> emergencyPlans;
    private final Map<String, AccessControl> accessControls;
    private final Map<String, Evaluation> evaluations;
    private final Map<String, Feedback> feedbacks;
    private final Map<String, Payment> payments;
    
    private int applicationCounter = 1;
    private int incidentCounter = 1;
    private int eventCounter = 1;
    private int caseCounter = 1;
    private int threatMessageCounter = 1;
    private int controlSystemCounter = 1;
    private int securityAuditCounter = 1;
    private int systemStatusCounter = 1;
    private int citizenServiceRequestCounter = 1;
    private int medicalTravelGuideCounter = 1;
    private int trainingModuleCounter = 1;
    private int emergencyPlanCounter = 1;
    private int accessControlCounter = 1;
    private int evaluationCounter = 1;
    private int feedbackCounter = 1;
    private int paymentCounter = 1;

    private DataService() {
        applications = new HashMap<>();
        incidents = new HashMap<>();
        events = new HashMap<>();
        assistanceCases = new HashMap<>();
        threatMessages = new HashMap<>();
        controlSystems = new HashMap<>();
        securityAudits = new HashMap<>();
        systemStatuses = new HashMap<>();
        citizenServiceRequests = new HashMap<>();
        medicalTravelGuides = new HashMap<>();
        trainingModules = new HashMap<>();
        emergencyPlans = new HashMap<>();
        accessControls = new HashMap<>();
        evaluations = new HashMap<>();
        feedbacks = new HashMap<>();
        payments = new HashMap<>();
        initializeSampleData();
    }

    public static DataService getInstance() {
        if (instance == null) {
            instance = new DataService();
        }
        return instance;
    }

    private void initializeSampleData() {
        // Sample Applications
        Application app1 = new Application("Raju", "raju@email.com", "+1234567890", 
            LocalDate.of(1990, 5, 15), "American", "Paris", LocalDate.of(2024, 7, 1), 
            "Tourism", "Passport");
        app1.setId("APP" + String.format("%04d", applicationCounter++));
        app1.setStatus("APPROVED");
        applications.put(app1.getId(), app1);

        Application app2 = new Application("Rafi", "rafi@email.com", "+0987654321", 
            LocalDate.of(1985, 8, 22), "Canadian", "Tokyo", LocalDate.of(2024, 8, 15), 
            "Business", "Visa");
        app2.setId("APP" + String.format("%04d", applicationCounter++));
        app2.setStatus("PENDING");
        applications.put(app2.getId(), app2);

        // Sample Incidents
        Incident inc1 = new Incident("Main Gate", "Security Breach", "HIGH", 
            "Security Officer", "Unauthorized access attempt detected");
        inc1.setId("INC" + String.format("%04d", incidentCounter++));
        inc1.setStatus("RESOLVED");
        inc1.setAssignedPerson("John Security");
        incidents.put(inc1.getId(), inc1);

        Incident inc2 = new Incident("Parking Lot", "Suspicious Activity", "MEDIUM", 
            "CCTV Operator", "Suspicious vehicle parked for extended period");
        inc2.setId("INC" + String.format("%04d", incidentCounter++));
        inc2.setAssignedPerson("Mike Guard");
        incidents.put(inc2.getId(), inc2);

        // Sample Events
        Event evt1 = new Event("Birth Registration", LocalDate.of(2024, 6, 15), 
            "City Hall", "Baby Registration Event", "Annual birth registration event");
        evt1.setId("EVT" + String.format("%04d", eventCounter++));
        events.put(evt1.getId(), evt1);

        Event evt2 = new Event("Marriage Certificate", LocalDate.of(2024, 7, 20), 
            "Registry Office", "Marriage Registration", "Marriage certificate processing");
        evt2.setId("EVT" + String.format("%04d", eventCounter++));
        events.put(evt2.getId(), evt2);

        // Sample Assistance Cases
        AssistanceCase case1 = new AssistanceCase("Sarah Johnson", "Lost Passport", 
            "Passport lost during travel, need emergency replacement");
        case1.setId("CASE" + String.format("%04d", caseCounter++));
        case1.setStatus("IN PROGRESS");
        case1.setAssignedOfficer("Officer Brown");
        assistanceCases.put(case1.getId(), case1);

        AssistanceCase case2 = new AssistanceCase("David Wilson", "Medical Emergency", 
            "Requires medical assistance and travel documentation");
        case2.setId("CASE" + String.format("%04d", caseCounter++));
        case2.setAssignedOfficer("Officer Green");
        assistanceCases.put(case2.getId(), case2);

        // Sample Threat Messages
        ThreatMessage msg1 = new ThreatMessage("MSG001", "Security Officer", "HIGH", "PENDING", 
            "Suspicious activity detected at main entrance", "Security Team");
        threatMessages.put(msg1.getId(), msg1);

        ThreatMessage msg2 = new ThreatMessage("MSG002", "CCTV Operator", "URGENT", "ACKNOWLEDGED", 
            "Unauthorized access attempt at server room", "IT Department");
        threatMessages.put(msg2.getId(), msg2);

        // Sample Control Systems
        ControlSystem cs1 = new ControlSystem("CS001", "Fire Emergency", "Activate sprinklers, evacuate building", 
            "Fire Response Team", LocalDateTime.now().minusDays(2));
        controlSystems.put(cs1.getCode(), cs1);

        ControlSystem cs2 = new ControlSystem("CS002", "Security Breach", "Lock down facility, alert security", 
            "Security Team", LocalDateTime.now().minusDays(1));
        controlSystems.put(cs2.getCode(), cs2);

        // Sample Security Audits
        SecurityAudit audit1 = new SecurityAudit("AUD001", "Access Control", "COMPLETED", 
            LocalDateTime.now().minusDays(30), LocalDateTime.now().plusDays(335));
        securityAudits.put(audit1.getId(), audit1);

        SecurityAudit audit2 = new SecurityAudit("AUD002", "CCTV Systems", "IN_PROGRESS", 
            LocalDateTime.now().minusDays(15), LocalDateTime.now().plusDays(15));
        securityAudits.put(audit2.getId(), audit2);

        // Sample System Statuses
        SystemStatus sys1 = new SystemStatus("Access Control System", "OPERATIONAL", "John Smith");
        systemStatuses.put(sys1.getSystemName(), sys1);

        SystemStatus sys2 = new SystemStatus("CCTV Surveillance", "OPERATIONAL", "Mike Johnson");
        systemStatuses.put(sys2.getSystemName(), sys2);

        // Sample Citizen Service Requests
        CitizenServiceRequest csr1 = new CitizenServiceRequest("CSR001", "Alice Brown", "+1234567890", 
            "alice@email.com", "British", LocalDate.of(1988, 3, 10), "Tourism", "London", 
            LocalDate.of(2024, 9, 1));
        citizenServiceRequests.put(csr1.getId(), csr1);

        // Sample Medical Travel Guides
        MedicalTravelGuide mtg1 = new MedicalTravelGuide("MTG001", "COVID-19 Requirements", 
            "Updated travel requirements for COVID-19", "Health", "Global");
        medicalTravelGuides.put(mtg1.getId(), mtg1);

        // Sample Training Modules
        TrainingModule tm1 = new TrainingModule("TM001", "Security Awareness", 
            "Basic security awareness training for all staff", "Security", "John Security", 
            LocalDateTime.now().plusDays(7), 120);
        trainingModules.put(tm1.getId(), tm1);

        // Sample Emergency Plans
        EmergencyPlan ep1 = new EmergencyPlan("EP001", "Fire Evacuation Plan", 
            "Comprehensive fire evacuation procedures", "Fire", "HIGH");
        emergencyPlans.put(ep1.getId(), ep1);

        // Sample Access Controls
        AccessControl ac1 = new AccessControl("AC001", "Server Room", "RESTRICTED", "Proximity Card");
        accessControls.put(ac1.getId(), ac1);

        // Sample Evaluations
        Evaluation eval1 = new Evaluation("EVAL001", "Security Officer Performance", 
            "Annual performance evaluation", "Manager", "John Security");
        evaluations.put(eval1.getId(), eval1);

        // Sample Feedback
        Feedback fb1 = new Feedback("FB001", "System Improvement", 
            "Suggestions for improving the security system", "System", "User");
        feedbacks.put(fb1.getId(), fb1);

        // Sample Payments
        Payment pay1 = new Payment("PAY001", "APP0001", "John Doe", 
            new java.math.BigDecimal("150.00"), "Credit Card");
        payments.put(pay1.getId(), pay1);
    }

    // Application methods
    public ObservableList<Application> getAllApplications() {
        return FXCollections.observableArrayList(applications.values());
    }

    public Application getApplicationById(String id) {
        return applications.get(id);
    }

    public void addApplication(Application application) {
        application.setId("APP" + String.format("%04d", applicationCounter++));
        applications.put(application.getId(), application);
    }

    public void updateApplication(Application application) {
        applications.put(application.getId(), application);
    }

    public void deleteApplication(String id) {
        applications.remove(id);
    }

    // Incident methods
    public ObservableList<Incident> getAllIncidents() {
        return FXCollections.observableArrayList(incidents.values());
    }

    public Incident getIncidentById(String id) {
        return incidents.get(id);
    }

    public void addIncident(Incident incident) {
        incident.setId("INC" + String.format("%04d", incidentCounter++));
        incidents.put(incident.getId(), incident);
    }

    public void updateIncident(Incident incident) {
        incidents.put(incident.getId(), incident);
    }

    public void deleteIncident(String id) {
        incidents.remove(id);
    }

    // Event methods
    public ObservableList<Event> getAllEvents() {
        return FXCollections.observableArrayList(events.values());
    }

    public Event getEventById(String id) {
        return events.get(id);
    }

    public void addEvent(Event event) {
        event.setId("EVT" + String.format("%04d", eventCounter++));
        events.put(event.getId(), event);
    }

    public void updateEvent(Event event) {
        events.put(event.getId(), event);
    }

    public void deleteEvent(String id) {
        events.remove(id);
    }

    // Assistance Case methods
    public ObservableList<AssistanceCase> getAllAssistanceCases() {
        return FXCollections.observableArrayList(assistanceCases.values());
    }

    public AssistanceCase getAssistanceCaseById(String id) {
        return assistanceCases.get(id);
    }

    public void addAssistanceCase(AssistanceCase assistanceCase) {
        assistanceCase.setId("CASE" + String.format("%04d", caseCounter++));
        assistanceCases.put(assistanceCase.getId(), assistanceCase);
    }

    public void updateAssistanceCase(AssistanceCase assistanceCase) {
        assistanceCases.put(assistanceCase.getId(), assistanceCase);
    }

    public void deleteAssistanceCase(String id) {
        assistanceCases.remove(id);
    }

    //for Search in Applications
    public ObservableList<Application> searchApplications(String query) {
        ObservableList<Application> results = FXCollections.observableArrayList();
        String lowerQuery = query.toLowerCase();
        
        for (Application app : applications.values()) {
            if (app.getName().toLowerCase().contains(lowerQuery) ||
                app.getEmail().toLowerCase().contains(lowerQuery) ||
                app.getStatus().toLowerCase().contains(lowerQuery)) {
                results.add(app);
            }
        }
        return results;
    }

    public ObservableList<Incident> searchIncidents(String query) {
        ObservableList<Incident> results = FXCollections.observableArrayList();
        String lowerQuery = query.toLowerCase();
        
        for (Incident incident : incidents.values()) {
            if (incident.getLocation().toLowerCase().contains(lowerQuery) ||
                incident.getIncidentType().toLowerCase().contains(lowerQuery) ||
                incident.getStatus().toLowerCase().contains(lowerQuery)) {
                results.add(incident);
            }
        }
        return results;
    }
}
