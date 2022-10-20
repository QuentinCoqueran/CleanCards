package com.cleancode.cleancards;

import com.cleancode.cleancards.models.Hero;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class HeroTests {

    @Test
    void updateExperience() {
        Hero hero = new Hero("Toto", 100, 0, 10, 10, "Specialty", "Rarity", 0);
        hero.updateExperience();
        assertEquals(1, hero.getXp());
        assertEquals(0, hero.getLevel());
        assertEquals(100, hero.getHp());
        assertEquals(10, hero.getPower());
        assertEquals(10, hero.getArmor());
    }

    @Test
    void levelup() {
        Hero hero = new Hero("Toto2", 100, 4, 10, 10, "Specialty", "Rarity", 0);
        hero.updateExperience();
        assertEquals(0, hero.getXp());
        assertEquals(1, hero.getLevel());
        assertEquals(110, hero.getHp());
        assertEquals(11, hero.getPower());
        assertEquals(11, hero.getArmor());
    }
}
