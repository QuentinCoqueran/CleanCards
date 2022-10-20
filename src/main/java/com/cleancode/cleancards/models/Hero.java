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

    public void updateExperience() {
        this.xp += 1;
        if (this.xp == 5) {
            this.xp = 0;
            this.level += 1;
            this.hp += (this.hp * 10) / 100;
            this.power += (this.power * 10) / 100;
            this.armor += (this.armor * 10) / 100;
        }
    }

}
