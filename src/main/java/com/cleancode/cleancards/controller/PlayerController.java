package com.cleancode.cleancards.controller;

import com.cleancode.cleancards.models.Player;
import com.cleancode.cleancards.service.PlayerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
public class PlayerController {
    private final PlayerService playerService;

    @GetMapping("/player")
    public ResponseEntity<Iterable<Player>> findAll() {
        return ResponseEntity.ok(playerService.findAll());
    }

    @GetMapping("/player/{id}")
    public ResponseEntity<Player> findById(@PathVariable Long id) {
        return ResponseEntity.ok(playerService.findById(id));
    }

    @PostMapping("/player")
    public ResponseEntity<String> create(@RequestBody Player player) {
        playerService.subscribePlayer(player);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
