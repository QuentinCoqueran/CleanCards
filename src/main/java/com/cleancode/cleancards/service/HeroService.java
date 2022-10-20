package com.cleancode.cleancards.service;

import com.cleancode.cleancards.model.Hero;
import com.cleancode.cleancards.repository.HeroRepository;
import lombok.AllArgsConstructor;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class HeroService {
    private HeroRepository repo;

    public List<Hero> findAll() {
        return (List<Hero>) repo.findAll();
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
