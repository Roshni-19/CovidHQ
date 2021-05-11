package com.example.covidhq.models;

import java.util.ArrayList;

public class PrescriptionModel {

    public ArrayList<PrescriptionListItem> prescription = new ArrayList<>();

    public PrescriptionModel(ArrayList<PrescriptionListItem> prescription) {
        this.prescription = prescription;
    }

    public PrescriptionModel() {
    }

    public ArrayList<PrescriptionListItem> getPrescription() {
        return prescription;
    }

    public void setPrescription(ArrayList<PrescriptionListItem> prescription) {
        this.prescription = prescription;
    }
}
