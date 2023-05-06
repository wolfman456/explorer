package com.example.explorer.items.model;

import com.fasterxml.jackson.annotation.JsonRootName;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "inventory")
@Entity
@JsonRootName("inventory")
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long inventoryId;
    @Column
    private String name;
    @Column
    private int maxCapacity;
    private int maxWeight;

}
