package com.example.ms3_group47_evisa.ImmigrationOfficer;

public class ImmigrationOfficerClass {
    private String id , name ;

    public ImmigrationOfficerClass(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ImmigrationOfficerClass{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
