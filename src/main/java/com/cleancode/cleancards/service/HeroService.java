package com.cleancode.cleancards.service;


import com.cleancode.cleancards.models.Hero;
import com.cleancode.cleancards.models.Rarity;
import com.cleancode.cleancards.repository.HeroRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class HeroService {
    private final HeroRepository heroRepository;

    public void createHero(Hero hero) {
        Hero createHero = new Hero(hero.getName(), hero.getSpecialty(), hero.getRarity());
        heroRepository.save(createHero);
    }

    public Iterable<Hero> findAll() {
        return heroRepository.findAll();
    }

    public Hero findById(Long id) {
        if (heroRepository.findById(id).isPresent()) {
            return heroRepository.findById(id).get();
        }
        throw new IllegalArgumentException("hero with id " + id + " is not exist.");
    }

    public Hero findByRarity(Rarity rarity) {
        return heroRepository.findByRarity(rarity);
    }
}
