package com.example.ms3_group47_evisa.FinancialOfficer;

public class FinancialOfficerDashboardController {
    public class FinancialOfficerDashboard {
        private String transactionId;
        private String customerName;
        private double amount;
        private String paymentMethod;
        private String status;
        private String date;

        public FinancialOfficerDashboard(String transactionId, String customerName, double amount, String paymentMethod, String status, String date) {
            this.transactionId = transactionId;
            this.customerName = customerName;
            this.amount = amount;
            this.paymentMethod = paymentMethod;
            this.status = status;
            this.date = date;
        }


        public String getTransactionId() { return transactionId; }
        public void setTransactionId(String transactionId) { this.transactionId = transactionId; }

        public String getCustomerName() { return customerName; }
        public void setCustomerName(String customerName) { this.customerName = customerName; }

        public double getAmount() { return amount; }
        public void setAmount(double amount) { this.amount = amount; }

        public String getPaymentMethod() { return paymentMethod; }
        public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }

        public String getStatus() { return status; }
        public void setStatus(String status) { this.status = status; }

        public String getDate() { return date; }
        public void setDate(String date) { this.date = date; }
    }
}
