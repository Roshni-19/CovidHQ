package com.example.covidhq.models;

public class SymptomsModel {
    String Normal, RunningNose, BodyAche, Feverish, LossOfTaste, Nausia, BreathingDifficulty, Temp;

    public SymptomsModel(String normal, String runningNose, String bodyAche, String feverish, String lossOfTaste, String nausia, String breathingDifficulty, String temp) {
        Normal = normal;
        RunningNose = runningNose;
        BodyAche = bodyAche;
        Feverish = feverish;
        LossOfTaste = lossOfTaste;
        Nausia = nausia;
        BreathingDifficulty = breathingDifficulty;
        Temp = temp;
    }

    public SymptomsModel() {
    }

    public String getNormal() {
        return Normal;
    }

    public void setNormal(String normal) {
        Normal = normal;
    }

    public String getRunningNose() {
        return RunningNose;
    }

    public void setRunningNose(String runningNose) {
        RunningNose = runningNose;
    }

    public String getBodyAche() {
        return BodyAche;
    }

    public void setBodyAche(String bodyAche) {
        BodyAche = bodyAche;
    }

    public String getFeverish() {
        return Feverish;
    }

    public void setFeverish(String feverish) {
        Feverish = feverish;
    }

    public String getLossOfTaste() {
        return LossOfTaste;
    }

    public void setLossOfTaste(String lossOfTaste) {
        LossOfTaste = lossOfTaste;
    }

    public String getNausia() {
        return Nausia;
    }

    public void setNausia(String nausia) {
        Nausia = nausia;
    }

    public String getBreathingDifficulty() {
        return BreathingDifficulty;
    }

    public void setBreathingDifficulty(String breathingDifficulty) {
        BreathingDifficulty = breathingDifficulty;
    }

    public String getTemp() {
        return Temp;
    }

    public void setTemp(String temp) {
        Temp = temp;
    }
}
