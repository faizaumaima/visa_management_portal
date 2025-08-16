package com.example.ms3_group47_evisa.FinancialOfficer;

public class TransactionHistoryClass {
    public class TransactionHistory {
        private String transactionId;
        private String customerName;
        private String paymentMethod;
        private double amount;
        private String date;
        private String status;

        public TransactionHistory(String transactionId, String customerName, String paymentMethod, double amount, String date, String status) {
            this.transactionId = transactionId;
            this.customerName = customerName;
            this.paymentMethod = paymentMethod;
            this.amount = amount;
            this.date = date;
            this.status = status;
        }


        public String getTransactionId() { return transactionId; }
        public void setTransactionId(String transactionId) { this.transactionId = transactionId; }

        public String getCustomerName() { return customerName; }
        public void setCustomerName(String customerName) { this.customerName = customerName; }

        public String getPaymentMethod() { return paymentMethod; }
        public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }

        public double getAmount() { return amount; }
        public void setAmount(double amount) { this.amount = amount; }

        public String getDate() { return date; }
        public void setDate(String date) { this.date = date; }

        public String getStatus() { return status; }
        public void setStatus(String status) { this.status = status; }
    }
}
