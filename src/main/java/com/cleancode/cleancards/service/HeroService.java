package com.cleancode.cleancards.service;


import com.cleancode.cleancards.models.Hero;
import com.cleancode.cleancards.repository.HeroRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class HeroService {
    private HeroRepository repo;

    public Iterable<Hero> findAll() {
        return repo.findAll();
    }

    public Hero findById(Long id) {
        if (repo.findById(id).isPresent()) {
            return repo.findById(id).get();
        }
        throw new IllegalArgumentException("hero with id " + id + " is not exist.");
    }

    public void createHero(Hero hero) {
        repo.save(hero);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
