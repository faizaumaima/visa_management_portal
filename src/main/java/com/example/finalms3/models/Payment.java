package com.example.finalms3.models;

import java.time.LocalDateTime;
import java.math.BigDecimal;

public class Payment {
    private String id;
    private String applicationId;
    private String applicantName;
    private BigDecimal amount;
    private String paymentMethod;
    private String currency;
    private LocalDateTime paymentDate;
    private String status;
    private String transactionId;
    private String description;
    private String receiptNumber;

    public Payment(String id, String applicationId, String applicantName, BigDecimal amount, String paymentMethod) {
        this.id = id;
        this.applicationId = applicationId;
        this.applicantName = applicantName;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.currency = "USD";
        this.paymentDate = LocalDateTime.now();
        this.status = "PENDING";
    }

    public Payment(String id, String applicationId, String applicantName, BigDecimal amount, String paymentMethod,
                   String currency, String description) {
        this.id = id;
        this.applicationId = applicationId;
        this.applicantName = applicantName;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.currency = currency;
        this.description = description;
        this.paymentDate = LocalDateTime.now();
        this.status = "PENDING";
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getApplicationId() { return applicationId; }
    public void setApplicationId(String applicationId) { this.applicationId = applicationId; }

    public String getApplicantName() { return applicantName; }
    public void setApplicantName(String applicantName) { this.applicantName = applicantName; }

    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }

    public String getPaymentMethod() { return paymentMethod; }
    public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }

    public String getCurrency() { return currency; }
    public void setCurrency(String currency) { this.currency = currency; }

    public LocalDateTime getPaymentDate() { return paymentDate; }
    public void setPaymentDate(LocalDateTime paymentDate) { this.paymentDate = paymentDate; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getTransactionId() { return transactionId; }
    public void setTransactionId(String transactionId) { this.transactionId = transactionId; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getReceiptNumber() { return receiptNumber; }
    public void setReceiptNumber(String receiptNumber) { this.receiptNumber = receiptNumber; }

    public String getFormattedAmount() {
        return currency + " " + amount.toString();
    }
}
