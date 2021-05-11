package com.example.covidhq.models;


import java.util.ArrayList;

public class OxygenModel {

    public ArrayList<OxygenListItem> oxygens = new ArrayList<>();

    public OxygenModel(ArrayList<OxygenListItem> oxygens) {
        this.oxygens = oxygens;
    }


    public OxygenModel() {
    }

    public ArrayList<OxygenListItem> getOxygens() {
        return oxygens;
    }

    public void setOxygens(ArrayList<OxygenListItem> oxygens) {
        this.oxygens = oxygens;
    }

}
