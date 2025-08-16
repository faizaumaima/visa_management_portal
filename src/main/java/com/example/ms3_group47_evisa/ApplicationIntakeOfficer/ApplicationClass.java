package com.example.ms3_group47_evisa.ApplicationIntakeOfficer;

import java.io.Serializable;

public class ApplicationClass implements Serializable {
    private String applicationid, name, nationality, email, travelpurpose, visatype;

    public ApplicationClass(String applicationid, String name, String nationality, String email, String travelpurpose, String visatype) {
        this.applicationid = applicationid;
        this.name = name;
        this.nationality = nationality;
        this.email = email;
        this.travelpurpose = travelpurpose;
        this.visatype = visatype;
    }

    public String getApplicationid() {
        return applicationid;
    }

    public void setApplicationid(String applicationid) {
        this.applicationid = applicationid;
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

    public String getTravelpurpose() {
        return travelpurpose;
    }

    public void setTravelpurpose(String travelpurpose) {
        this.travelpurpose = travelpurpose;
    }

    public String getVisatype() {
        return visatype;
    }

    public void setVisatype(String visatype) {
        this.visatype = visatype;
    }

    @Override
    public String toString() {
        return "ApplicationClass{" +
                "applicationid='" + applicationid + '\'' +
                ", name='" + name + '\'' +
                ", nationality='" + nationality + '\'' +
                ", email='" + email + '\'' +
                ", travelpurpose='" + travelpurpose + '\'' +
                ", visatype='" + visatype + '\'' +
                '}';
    }
}
