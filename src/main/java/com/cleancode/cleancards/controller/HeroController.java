package com.cleancode.cleancards.controller;

import com.cleancode.cleancards.model.Hero;
import com.cleancode.cleancards.service.HeroService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.net.URI;
import java.util.List;

@AllArgsConstructor
@RestController
public class HeroController {
    private final HeroService heroService;

    @GetMapping("/hero")
    public ResponseEntity<List<Hero>> findAll() {
        return ResponseEntity.ok(heroService.findAll());
    }

    @GetMapping("/hero/{id}")
    public ResponseEntity<Hero> findById(@PathVariable Long id) {
        return ResponseEntity.ok(heroService.findById(id));
    }

    @PostMapping("/hero")
    public ResponseEntity<String> create(@Validated @RequestBody Hero hero) {
        heroService.createHero(hero);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


}
