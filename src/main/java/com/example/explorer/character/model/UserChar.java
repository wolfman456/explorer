package com.example.explorer.character.model;

import com.fasterxml.jackson.annotation.JsonRootName;
import jakarta.persistence.*;

@JsonRootName(value = "player_charter")
@Entity
@Table(name = "userChar")
public class UserChar extends BaseCharater{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long charId;
    @Column(nullable = false)
    private Long userId;
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

    public UserChar(String race, Integer hitPoints, Integer baseAct, Integer baseSpellPoints,
                    Long charId, Long userId, String charName, Integer wis, Integer str, Integer charisma, Integer con) {
        super(race, hitPoints, baseAct, baseSpellPoints);
        this.charId = charId;
        this.userId = userId;
        this.charName = charName;
        this.wis = wis;
        this.str = str;
        this.charisma = charisma;
        this.con = con;
    }

    public UserChar() {
    }

    public UserChar(String race, Integer hitPoints, Integer baseAct, Integer baseSpellPoints) {
        super(race, hitPoints, baseAct, baseSpellPoints);
    }

    public Long getCharId() {
        return charId;
    }

    public void setCharId(Long charId) {
        this.charId = charId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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
}
