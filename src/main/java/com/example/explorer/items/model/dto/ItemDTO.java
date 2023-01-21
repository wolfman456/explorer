package com.example.explorer.items.model.dto;


import jakarta.persistence.Column;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ItemDTO {
    private String name;
    private String description;
    private Double weight;
    private Integer maxStackAmount;
    private Boolean magic;
    private Boolean uniqueItem;
    private String effect;
}
