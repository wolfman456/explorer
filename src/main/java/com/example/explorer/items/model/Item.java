package com.example.explorer.items.model;

import com.fasterxml.jackson.annotation.JsonRootName;
import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonRootName("item")
@Entity
@Table(name = "items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemsId;

    @Column(unique = true)
    private String name;
    @Column
    private String description;
    @Column
    private Double weight;
    @Column
    private Boolean stackable;

}
