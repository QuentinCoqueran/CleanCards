package org.example;

public class Hero {
    private String name;
    private Integer hp;
    private Integer xp;
    private Integer power;
    private Integer armor;
    private String specialty;
    private String rarity;
    private Integer level;

    public Hero(String name, Integer hp, Integer xp, Integer power, Integer armor, String specialty, String rarity, Integer level) {
        this.name = name;
        this.hp = hp;
        this.xp = xp;
        this.power = power;
        this.armor = armor;
        this.specialty = specialty;
        this.rarity = rarity;
        this.level = level;
    }
}
