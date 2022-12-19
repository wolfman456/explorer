package com.example.explorer.Character.model;

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
}
