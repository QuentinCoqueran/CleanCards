package com.cleancode.cleancards;

import com.cleancode.cleancards.models.Hero;
import com.cleancode.cleancards.models.Rarity;
import com.cleancode.cleancards.models.Speciality;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class HeroTests {

    @Test
    void updateExperience() {
        Hero hero = new Hero("Hero1", Speciality.Tank, Rarity.Common);
        hero.updateExperience();
        assertEquals(1, hero.getXp());
        assertEquals(1, hero.getLevel());
        assertEquals(1000, hero.getHp());
        assertEquals(100, hero.getPower());
        assertEquals(20, hero.getArmor());
    }

    @Test
    void levelup() {
        Hero hero2 = new Hero("Hero2", Speciality.Tank, Rarity.Common);
        hero2.setXp(4);
        hero2.updateExperience();
        assertEquals(0, hero2.getXp());
        assertEquals(2, hero2.getLevel());
        assertEquals(1100, hero2.getHp());
        assertEquals(110, hero2.getPower());
        assertEquals(22, hero2.getArmor());
    }
}
