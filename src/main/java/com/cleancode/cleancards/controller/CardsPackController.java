package com.cleancode.cleancards.controller;

import com.cleancode.cleancards.models.CardsPack;
import com.cleancode.cleancards.service.CardsPackService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
public class CardsPackController {
    private final CardsPackService cardsPackService;

    @GetMapping("/cardsPack")
    public ResponseEntity<Iterable<CardsPack>> findAll() {
        return ResponseEntity.ok(cardsPackService.findAll());
    }

    @GetMapping("/cardsPack/{id}")
    public ResponseEntity<CardsPack> findById(@PathVariable Long id) {
        return ResponseEntity.ok(cardsPackService.findById(id));
    }

    @PostMapping("/cardsPack")
    public ResponseEntity<String> create(@RequestBody CardsPack cardsPack) {
        cardsPackService.createCardsPack(cardsPack);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/cardsPack/{idCardsPack}/player/{idPlayer}/open")
    public ResponseEntity<String> openCardsPack(@PathVariable Long idCardsPack, @PathVariable Long idPlayer) {
        cardsPackService.openCardsPack(idCardsPack, idPlayer);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
