package com.example.ms3_group47_evisa.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ThreatMessage {
    private String id;
    private String sender;
    private String priority;
    private String status;
    private String content;
    private LocalDateTime timestamp;
    private String recipient;

    public ThreatMessage(String id, String sender, String priority, String status, String content) {
        this.id = id;
        this.sender = sender;
        this.priority = priority;
        this.status = status;
        this.content = content;
        this.timestamp = LocalDateTime.now();
    }

    public ThreatMessage(String id, String sender, String priority, String status, String content, String recipient) {
        this.id = id;
        this.sender = sender;
        this.priority = priority;
        this.status = status;
        this.content = content;
        this.recipient = recipient;
        this.timestamp = LocalDateTime.now();
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getSender() { return sender; }
    public void setSender(String sender) { this.sender = sender; }

    public String getPriority() { return priority; }
    public void setPriority(String priority) { this.priority = priority; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public String getTimestamp() { 
        return timestamp.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")); 
    }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }

    public String getRecipient() { return recipient; }
    public void setRecipient(String recipient) { this.recipient = recipient; }
}
