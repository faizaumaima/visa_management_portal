package com.example.ms3_group47_evisa.DataEntryClerk;

public class UploadDocumentsClass  {
    public class UploadDocument {
        private String documentId;
        private String applicantId;
        private String documentName;
        private String documentType;
        private String uploadDate;
        private String status;

        public UploadDocument(String documentId, String applicantId, String documentName, String documentType, String uploadDate, String status) {
            this.documentId = documentId;
            this.applicantId = applicantId;
            this.documentName = documentName;
            this.documentType = documentType;
            this.uploadDate = uploadDate;
            this.status = status;
        }

        public String getDocumentId() { return documentId; }
        public void setDocumentId(String documentId) { this.documentId = documentId; }

        public String getApplicantId() { return applicantId; }
        public void setApplicantId(String applicantId) { this.applicantId = applicantId; }

        public String getDocumentName() { return documentName; }
        public void setDocumentName(String documentName) { this.documentName = documentName; }

        public String getDocumentType() { return documentType; }
        public void setDocumentType(String documentType) { this.documentType = documentType; }

        public String getUploadDate() { return uploadDate; }
        public void setUploadDate(String uploadDate) { this.uploadDate = uploadDate; }

        public String getStatus() { return status; }
        public void setStatus(String status) { this.status = status; }
    }
}
