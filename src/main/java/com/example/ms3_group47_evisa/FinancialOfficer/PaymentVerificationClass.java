package com.example.ms3_group47_evisa.FinancialOfficer;

public class PaymentVerificationClass {
        private int id;
        private double amount;
        private String status;

        public PaymentVerificationClass(int id, double amount, String status) {
            this.id = id;
            this.amount = amount;
            this.status = status;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }


        @Override
        public String toString() {
            return "Payment{" +
                    "id=" + id +
                    ", amount=" + amount +
                    ", status='" + status + '\'' +
                    '}';
        }
    }
}
