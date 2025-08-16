package com.example.ms3_group47_evisa.CustomerSupportAgency;

import java.io.Serializable;

public class ApplicantClass implements Serializable {
        private String applicantId, name, nationality, email, applicationId, visaType, remarks;

        public ApplicantClass(String applicantId, String name, String nationality, String email, String applicationId, String visaType, String remarks) {
            this.applicantId = applicantId;
            this.name = name;
            this.nationality = nationality;
            this.email = email;
            this.applicationId = applicationId;
            this.visaType = visaType;
            this.remarks = remarks;

        }

        public String getApplicantId() {
            return applicantId;
        }

        public void setApplicantId(String applicantId) {
            this.applicantId = applicantId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getNationality() {
            return nationality;
        }

        public void setNationality(String nationality) {
            this.nationality = nationality;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getApplicationId() {
            return applicationId;
        }

        public void setApplicationId(String applicationId) {
            this.applicationId = applicationId;
        }

        public String getVisaType() {
            return visaType;
        }

        public void setVisaType(String visaType) {
            this.visaType = visaType;
        }

        public String getRemarks() {
        return remarks;
    }

        public void setRemarks(String visaType) {
        this.remarks = remarks;
    }

        @Override
        public String toString() {
            return "ApplicantClass{" +
                    "applicantId='" + applicantId + '\'' +
                    ", name='" + name + '\'' +
                    ", nationality='" + nationality + '\'' +
                    ", email='" + email + '\'' +
                    ", applicationId='" + applicationId + '\'' +
                    ", visaType='" + visaType + '\'' +
                    ", remarks='" + remarks + '\'' +
                    '}';
        }
    }
