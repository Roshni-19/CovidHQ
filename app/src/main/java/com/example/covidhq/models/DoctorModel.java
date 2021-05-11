package com.example.covidhq.models;


import java.util.ArrayList;
import java.util.List;

public class DoctorModel {
    public ArrayList<DoctorModelListItem> doctorsList = new ArrayList<>();

    public DoctorModel(ArrayList<DoctorModelListItem> doctorsList) {
        this.doctorsList = doctorsList;
    }

    public DoctorModel() {
    }


}