package com.besha.v13;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "vitamins")
public class Vitamin {
    @PrimaryKey
    private int vid;

    private String name;
    private String description;
    private String sources;
    private String benefits;
    private String risk;
    private String refrences;

    public Vitamin(int vid, String name, String description, String benefits, String sources, String risk, String refrences) {
        this.vid = vid;
        this.name = name;
                this.description = description;
        this.sources = sources;
        this.benefits = benefits;
        this.risk = risk;
        this.refrences = refrences;
    }

    public int getVid() {
        return vid;
    }

    public void setVid(int id) {
        this.vid = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSources() {
        return sources;
    }

    public void setSources(String sources) {
        this.sources = sources;
    }

    public String getBenefits() {
        return benefits;
    }

    public void setBenefits(String benefits) {
        this.benefits = benefits;
    }

    public String getRisk() {
        return risk;
    }

    public void setRisk(String risk) {
        this.risk = risk;
    }

    public String getRefrences() {
        return refrences;
    }

    public void setRefrences(String refrences) {
        this.refrences = refrences;
    }
}
