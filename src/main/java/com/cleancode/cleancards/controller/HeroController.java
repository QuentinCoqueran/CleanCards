package com.cleancode.cleancards.controller;


import com.cleancode.cleancards.models.Hero;
import com.cleancode.cleancards.service.HeroService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@AllArgsConstructor
@RestController
public class HeroController {
    private final HeroService heroService;

    @GetMapping("/hero")
    public ResponseEntity<Iterable<Hero>> findAll() {
        return ResponseEntity.ok(heroService.findAll());
    }

    @GetMapping("/hero/{id}")
    public ResponseEntity<Hero> findById(@PathVariable Long id) {
        return ResponseEntity.ok(heroService.findById(id));
    }

    @PostMapping("/hero")
    public ResponseEntity<String> create(@RequestBody Hero hero) {
        heroService.createHero(hero);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
