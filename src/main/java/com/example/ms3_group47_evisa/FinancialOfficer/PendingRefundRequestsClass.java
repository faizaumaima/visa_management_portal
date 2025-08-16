package com.example.ms3_group47_evisa.FinancialOfficer;

public class PendingRefundRequestsClass{
        private int requestId;
        private String customerName;
        private double refundAmount;
        private String reason;
        private String status;


        public void PendingRefundRequest(int requestId, String customerName, double refundAmount, String reason, String status) {
            this.requestId = requestId;
            this.customerName = customerName;
            this.refundAmount = refundAmount;
            this.reason = reason;
            this.status = status;
        }


        public int getRequestId() {
            return requestId;
        }

        public void setRequestId(int requestId) {
            this.requestId = requestId;
        }

        public String getCustomerName() {
            return customerName;
        }

        public void setCustomerName(String customerName) {
            this.customerName = customerName;
        }

        public double getRefundAmount() {
            return refundAmount;
        }

        public void setRefundAmount(double refundAmount) {
            this.refundAmount = refundAmount;
        }

        public String getReason() {
            return reason;
        }

        public void setReason(String reason) {
            this.reason = reason;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
        @Override
        public String toString() {
            return "PendingRefundRequest{" +
                    "requestId=" + requestId +
                    ", customerName='" + customerName + '\'' +
                    ", refundAmount=" + refundAmount +
                    ", reason='" + reason + '\'' +
                    ", status='" + status + '\'' +
                    '}';
        }
    }
    
}
