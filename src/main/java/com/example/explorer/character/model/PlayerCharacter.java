package com.example.explorer.character.model;

import com.fasterxml.jackson.annotation.JsonRootName;
import jakarta.persistence.*;

@JsonRootName(value = "player_charter")
@Entity
@Table(name = "player_charter")
public class PlayerCharacter extends BaseCharater{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long charId;
    @Column(nullable = false)
    private String userName;
    @Column
    private String charName;
    @Column
    private Integer wis;
    @Column
    private Integer str;
    @Column
    private Integer charisma;
    @Column
    private Integer con;

    @Column Integer intelligent;

    public PlayerCharacter(String race, Integer intelligent, Integer hitPoints, Integer baseAct, Integer baseSpellPoints, Long charId, String userName, String charName, Integer wis, Integer str, Integer charisma, Integer con) {
        super(race, hitPoints, baseAct, baseSpellPoints);
        this.charId = charId;
        this.userName = userName;
        this.charName = charName;
        this.wis = wis;
        this.str = str;
        this.charisma = charisma;
        this.con = con;
        this.intelligent = intelligent;
    }

    public PlayerCharacter() {
    }

    public Long getCharId() {
        return charId;
    }

    public void setCharId(Long charId) {
        this.charId = charId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public Integer getWis() {
        return wis;
    }

    public void setWis(Integer wis) {
        this.wis = wis;
    }

    public Integer getStr() {
        return str;
    }

    public void setStr(Integer str) {
        this.str = str;
    }

    public Integer getCharisma() {
        return charisma;
    }

    public void setCharisma(Integer charisma) {
        this.charisma = charisma;
    }

    public Integer getCon() {
        return con;
    }

    public void setCon(Integer con) {
        this.con = con;
    }

    public Integer getIntelligent() {
        return intelligent;
    }

    public void setIntelligent(Integer intelligent) {
        this.intelligent = intelligent;
    }
}
