package com.example.ms3_group47_evisa.FinancialOfficer;

public class PaymentVerificationClass {
    public class PaymentVerification {
        private String transactionId;
        private String customerName;
        private double amount;
        private String paymentMethod;
        private String status;
        private String verificationDate;

        public PaymentVerification(String transactionId, String customerName, double amount, String paymentMethod, String status, String verificationDate) {
            this.transactionId = transactionId;
            this.customerName = customerName;
            this.amount = amount;
            this.paymentMethod = paymentMethod;
            this.status = status;
            this.verificationDate = verificationDate;
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

        public String getVerificationDate() { return verificationDate; }
        public void setVerificationDate(String verificationDate) { this.verificationDate = verificationDate; }
    }
}
