package com.example.explorer.Character.model;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value = "base_charter")
public class BaseCharater{
    private String race;
    private Integer hitPoints;
    private Integer baseAct;
    private Integer baseSpellPoints;

    public BaseCharater() {
    }

    public BaseCharater(String race, Integer hitPoints, Integer baseAct, Integer baseSpellPoints) {
        this.race = race;
        this.hitPoints = hitPoints;
        this.baseAct = baseAct;
        this.baseSpellPoints = baseSpellPoints;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public Integer getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(Integer hitPoints) {
        this.hitPoints = hitPoints;
    }

    public Integer getBaseAct() {
        return baseAct;
    }

    public void setBaseAct(Integer baseAct) {
        this.baseAct = baseAct;
    }

    public Integer getBaseSpellPoints() {
        return baseSpellPoints;
    }

    public void setBaseSpellPoints(Integer baseSpellPoints) {
        this.baseSpellPoints = baseSpellPoints;
    }
}
