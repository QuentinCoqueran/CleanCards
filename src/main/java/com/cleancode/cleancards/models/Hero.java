package com.cleancode.cleancards.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Hero {
    private String name;
    private Integer hp;
    private Integer xp;
    private Integer power;
    private Integer armor;
    private Speciality specialty;
    private Rarity rarity;
    private Integer level;

    public Hero(String name, Speciality speciality, Rarity rarity) {
        this.specialty = specialty;
        this.rarity = rarity;
        this.name = name;
        this.level = 1;
        this.xp = 0;
        switch (speciality) {
            case Tank -> {
                this.hp = 1000;
                this.power = 100;
                this.armor = 20;
            }
            case Assassin -> {
                this.hp = 800;
                this.power = 200;
                this.armor = 5;
            }
            case Mage -> {
                this.hp = 700;
                this.power = 150;
                this.armor = 10;
            }
        }
        switch(rarity) {
            case Common:
                break;
            case Rare:
                this.hp += (this.hp * 10) / 100;
                this.power += (this.power * 10) / 100;
                this.armor += (this.armor * 10) / 100;
                break;
            case Legendary:
                this.hp += (this.hp * 20) / 100;
                this.power += (this.power * 20) / 100;
                this.armor += (this.armor * 20) / 100;
                break;
        }
    }

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
