package com.example.explorer.Chatacter.model;


import jakarta.persistence.*;

@Entity
@Table(name = "race")
public class Race {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String raceName;
    private String raceDescription;
    private Integer strMod;
    private Integer wisMod;
    private Integer intMod;
    private Integer charMod;
    private Integer conMod;

    public Race() {
    }

    public Race(String raceName, String raceDescription, Integer strMod, Integer wisMod, Integer intMod, Integer charMod, Integer conMod) {
        this.raceName = raceName;
        this.raceDescription = raceDescription;
        this.strMod = strMod;
        this.wisMod = wisMod;
        this.intMod = intMod;
        this.charMod = charMod;
        this.conMod = conMod;
    }

    public String getRaceName() {
        return raceName;
    }

    public void setRaceName(String raceName) {
        this.raceName = raceName;
    }

    public String getRaceDescription() {
        return raceDescription;
    }

    public void setRaceDescription(String raceDescription) {
        this.raceDescription = raceDescription;
    }

    public Integer getStrMod() {
        return strMod;
    }

    public void setStrMod(Integer strMod) {
        this.strMod = strMod;
    }

    public Integer getWisMod() {
        return wisMod;
    }

    public void setWisMod(Integer wisMod) {
        this.wisMod = wisMod;
    }

    public Integer getIntMod() {
        return intMod;
    }

    public void setIntMod(Integer intMod) {
        this.intMod = intMod;
    }

    public Integer getCharMod() {
        return charMod;
    }

    public void setCharMod(Integer charMod) {
        this.charMod = charMod;
    }

    public Integer getConMod() {
        return conMod;
    }

    public void setConMod(Integer conMod) {
        this.conMod = conMod;
    }
}
