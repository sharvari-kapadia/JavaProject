package com.practice.test;

public class PermissionData {

    private String name;
    private String internalName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInternalName() {
        return internalName;
    }

    public void setInternalName(String internalName) {
        this.internalName = internalName;
    }

    PermissionData(String name, String internalName) {
        this.name = name;
        this.internalName = internalName;
    }

    PermissionData(PermissionData another) {
        another = this;
    }
}
