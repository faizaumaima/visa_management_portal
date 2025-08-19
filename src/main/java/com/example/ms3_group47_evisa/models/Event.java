package com.example.ms3_group47_evisa.models;

import java.time.LocalDate;

public class Event {
    private String id;
    private String eventType;
    private LocalDate date;
    private String location;
    private String name;
    private String notification;
    private String description;
    private String status;

    public Event() {
        this.status = "SCHEDULED";
    }

    public Event(String eventType, LocalDate date, String location, String name, String description) {
        this();
        this.eventType = eventType;
        this.date = date;
        this.location = location;
        this.name = name;
        this.description = description;
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getEventType() { return eventType; }
    public void setEventType(String eventType) { this.eventType = eventType; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getNotification() { return notification; }
    public void setNotification(String notification) { this.notification = notification; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return "Event{" +
                "id='" + id + '\'' +
                ", eventType='" + eventType + '\'' +
                ", date=" + date +
                ", location='" + location + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
