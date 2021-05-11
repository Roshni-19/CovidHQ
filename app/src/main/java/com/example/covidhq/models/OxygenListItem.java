package com.example.covidhq.models;

public class OxygenListItem {

    String stateName, link;

    public OxygenListItem(String stateName, String link) {
        this.stateName = stateName;
        this.link = link;
    }

    public OxygenListItem() {
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
