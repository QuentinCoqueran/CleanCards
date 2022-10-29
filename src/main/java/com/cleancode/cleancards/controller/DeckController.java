package com.cleancode.cleancards.controller;

import com.cleancode.cleancards.models.Deck;
import com.cleancode.cleancards.models.Player;
import com.cleancode.cleancards.service.DeckService;
import com.cleancode.cleancards.service.PlayerService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class DeckController {
    private final DeckService deckService;
    private final PlayerService playerService;

    @GetMapping("/deck/player/{id}")
    public ResponseEntity<Deck> findByIdPlayer(@PathVariable Long id) {
        return ResponseEntity.ok(playerService.findDeckByIdPlayer(id));
    }
}
