package com.example.covidhq.models;

public class PrescriptionListItem {
    String medicineName, morningbeforefood, morningafterfood, afternoonbeforefood, afternoonafterfood, nightbeforefood, nightafterfood;

    public PrescriptionListItem(String medicineName, String morningbeforefood, String morningafterfood, String afternoonbeforefood, String afternoonafterfood, String nightbeforefood, String nightafterfood) {
        this.medicineName = medicineName;
        this.morningbeforefood = morningbeforefood;
        this.morningafterfood = morningafterfood;
        this.afternoonbeforefood = afternoonbeforefood;
        this.afternoonafterfood = afternoonafterfood;
        this.nightbeforefood = nightbeforefood;
        this.nightafterfood = nightafterfood;
    }

    public PrescriptionListItem() {
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public String getMorningbeforefood() {
        return morningbeforefood;
    }

    public void setMorningbeforefood(String morningbeforefood) {
        this.morningbeforefood = morningbeforefood;
    }

    public String getMorningafterfood() {
        return morningafterfood;
    }

    public void setMorningafterfood(String morningafterfood) {
        this.morningafterfood = morningafterfood;
    }

    public String getAfternoonbeforefood() {
        return afternoonbeforefood;
    }

    public void setAfternoonbeforefood(String afternoonbeforefood) {
        this.afternoonbeforefood = afternoonbeforefood;
    }

    public String getAfternoonafterfood() {
        return afternoonafterfood;
    }

    public void setAfternoonafterfood(String afternoonafterfood) {
        this.afternoonafterfood = afternoonafterfood;
    }

    public String getNightbeforefood() {
        return nightbeforefood;
    }

    public void setNightbeforefood(String nightbeforefood) {
        this.nightbeforefood = nightbeforefood;
    }

    public String getNightafterfood() {
        return nightafterfood;
    }

    public void setNightafterfood(String nightafterfood) {
        this.nightafterfood = nightafterfood;
    }
}
