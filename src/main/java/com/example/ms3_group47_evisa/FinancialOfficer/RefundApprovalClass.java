package com.example.ms3_group47_evisa.FinancialOfficer;

import javafx.scene.layout.HBox;

public class RefundApprovalClass {
        private String requestId;
        private String customerName;
        private double amount;
        private String status;

        public RefundApprovalRequest(String requestId, String customerName, double amount, String status) {
            this.requestId = requestId;
            this.customerName = customerName;
            this.amount = amount;
            this.status = status;
        }


        public String getRequestId() { return requestId; }
        public void setRequestId(String requestId) { this.requestId = requestId; }

        public String getCustomerName() { return customerName; }
        public void setCustomerName(String customerName) { this.customerName = customerName; }

        public double getAmount() { return amount; }
        public void setAmount(double amount) { this.amount = amount; }

        public String getStatus() { return status; }
        public void setStatus(String status) { this.status = status; }
    }

}
