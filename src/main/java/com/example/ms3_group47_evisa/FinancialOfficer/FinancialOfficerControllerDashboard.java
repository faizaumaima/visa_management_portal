package com.example.ms3_group47_evisa.FinancialOfficer;

import java.util.ArrayList;
import java.util.List;

public class FinancialOfficerControllerDashboard {

import java.util.ArrayList;
import java.util.List;

    public class FinancialOfficer {
        private String id;
        private String name;
        private String email;
        private String password;


        private List<Payment> payments;
        private List<RefundRequest> refundRequests;


        public FinancialOfficer(String id, String name, String email, String password) {
            this.id = id;
            this.name = name;
            this.email = email;
            this.password = password;
            this.payments = new ArrayList<>();
            this.refundRequests = new ArrayList<>();
        }

        //
        public static class Payment {
            private String paymentId;
            private double amount;
            private boolean verified;

            public Payment(String paymentId, double amount) {
                this.paymentId = paymentId;
                this.amount = amount;
                this.verified = false;
            }

            public String getPaymentId() { return paymentId; }
            public double getAmount() { return amount; }
            public boolean isVerified() { return verified; }
            public void setVerified(boolean verified) { this.verified = verified; }
        }

        //
        public static class RefundRequest {
            private String requestId;
            private double amount;
            private boolean approved;

            public RefundRequest(String requestId, double amount) {
                this.requestId = requestId;
                this.amount = amount;
                this.approved = false;
            }

            public String getRequestId() { return requestId; }
            public double getAmount() { return amount; }
            public boolean isApproved() { return approved; }
            public void setApproved(boolean approved) { this.approved = approved; }
        }

        //
        public void addPayment(Payment payment) {
            payments.add(payment);
        }

        //
        public boolean verifyPayment(String paymentId) {
            for (Payment payment : payments) {
                if (payment.getPaymentId().equals(paymentId)) {
                    payment.setVerified(true);
                    return true;
                }
            }
            return false;
        }

        //
        public void addRefundRequest(RefundRequest request) {
            refundRequests.add(request);
        }

        //
        public boolean approveRefund(String requestId) {
            for (RefundRequest req : refundRequests) {
                if (req.getRequestId().equals(requestId)) {
                    req.setApproved(true);
                    return true;
                }
            }
            return false;
        }

        //
        public void showPayments() {
            System.out.println("---- All Payments ----");
            for (Payment p : payments) {
                System.out.println(p.getPaymentId() + " | Amount: " + p.getAmount() + " | Verified: " + p.isVerified());
            }
        }


        public void showRefundRequests() {
            System.out.println("---- All Refund Requests ----");
            for (RefundRequest r : refundRequests) {
                System.out.println(r.getRequestId() + " | Amount: " + r.getAmount() + " | Approved: " + r.isApproved());
            }
        }


        public static void main(String[] args) {
            FinancialOfficer officer = new FinancialOfficer("FO001", "Rahim Uddin", "rahim@finance.com", "1234");

            Payment p1 = new Payment("P001", 5000);
            Payment p2 = new Payment("P002", 7500);
            officer.addPayment(p1);
            officer.addPayment(p2);


            officer.verifyPayment("P001");


            RefundRequest r1 = new RefundRequest("R001", 2000);
            RefundRequest r2 = new RefundRequest("R002", 1500);
            officer.addRefundRequest(r1);
            officer.addRefundRequest(r2);


            officer.approveRefund("R002");


            officer.showPayments();
            officer.showRefundRequests();
        }
    }
}
