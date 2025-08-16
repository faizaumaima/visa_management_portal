package com.example.ms3_group47_evisa.DataEntryClerk;

public class NewApplicantEntryClass {
    public class NewApplicantEntry {
        private String applicantId;
        private String fullName;
        private String email;
        private String phone;
        private String address;
        private String status;

        public NewApplicantEntry(String applicantId, String fullName, String email, String phone, String address, String status) {
            this.applicantId = applicantId;
            this.fullName = fullName;
            this.email = email;
            this.phone = phone;
            this.address = address;
            this.status = status;
        }

        // Getter & Setter
        public String getApplicantId() { return applicantId; }
        public void setApplicantId(String applicantId) { this.applicantId = applicantId; }

        public String getFullName() { return fullName; }
        public void setFullName(String fullName) { this.fullName = fullName; }

        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }

        public String getPhone() { return phone; }
        public void setPhone(String phone) { this.phone = phone; }

        public String getAddress() { return address; }
        public void setAddress(String address) { this.address = address; }

        public String getStatus() { return status; }
        public void setStatus(String status) { this.status = status; }
    }
}
