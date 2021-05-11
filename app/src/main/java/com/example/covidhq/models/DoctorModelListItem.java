package com.example.covidhq.models;

public class DoctorModelListItem {

    String doctorName, doctorDept, doctNumber;

    public DoctorModelListItem(String doctorName, String doctorDept, String doctNumber) {
        this.doctorName = doctorName;
        this.doctorDept = doctorDept;
        this.doctNumber = doctNumber;
    }

    public DoctorModelListItem() {
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDoctorDept() {
        return doctorDept;
    }

    public void setDoctorDept(String doctorDept) {
        this.doctorDept = doctorDept;
    }

    public String getDoctNumber() {
        return doctNumber;
    }

    public void setDoctNumber(String doctNumber) {
        this.doctNumber = doctNumber;
    }
}

