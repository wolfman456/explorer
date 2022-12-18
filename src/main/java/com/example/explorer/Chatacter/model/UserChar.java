package com.example.explorer.Chatacter.model;

import jakarta.persistence.*;


@Entity
@Table(name = "userChar")
public class UserChar extends BaseCharater{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long charId;
    @Column
    private Long userId;
    @Column
    private String charName;

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
}
