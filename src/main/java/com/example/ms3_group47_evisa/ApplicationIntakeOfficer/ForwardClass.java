package com.example.ms3_group47_evisa.ApplicationIntakeOfficer;

public class ForwardClass {
    private String applicationId, name , status;

    public ForwardClass(String applicationId, String name, String status) {
        this.applicationId = applicationId;
        this.name = name;
        this.status = status;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ForwardClass{" +
                "applicationId='" + applicationId + '\'' +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
