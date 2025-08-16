package com.example.ms3_group47_evisa.FinancialOfficer;

public class PendingRefundRequestsClass {
    private String requestId,CustomerName,doubleAmount,status;

    public PendingRefundRequestsClass(String requestId, String customerName, String doubleAmount, String status) {
        this.requestId = requestId;
        CustomerName = customerName;
        this.doubleAmount = doubleAmount;
        this.status = status;

    }

    public String getRequestId() {
        return requestId;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public String getDoubleAmount() {
        return doubleAmount;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "PendingRefundRequestsClass{" +
                "requestId='" + requestId + '\'' +
                ", CustomerName='" + CustomerName + '\'' +
                ", doubleAmount='" + doubleAmount + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
