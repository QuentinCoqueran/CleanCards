package com.cleancode.cleancards.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Hero {
    private String name;
    private Integer hp;
    private Integer xp;
    private Integer power;
    private Integer armor;
    private String specialty;
    private String rarity;
    private Integer level;
}
