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

import java.util.List;

@AllArgsConstructor
@RestController
public class DeckController {
	private final DeckService deckService;
	private final PlayerService playerService;

	@GetMapping("/deck")
	public ResponseEntity<Iterable<Deck>> findAll() {
		return ResponseEntity.ok(deckService.findAll());
	}

	@GetMapping("/deck/player/{id}")
	public ResponseEntity<List<Deck>> findByIdPlayer(@PathVariable Long id) {
		return ResponseEntity.ok(playerService.findDeckByIdPlayer(id));
	}


	@GetMapping("/deck/not/player/{id}")
	public ResponseEntity<List<Deck>> findAllWithPlayer(@PathVariable Long id) {
		return ResponseEntity.ok(deckService.findAllNotPlayer_IdPlayer(id));
	}

	@GetMapping("deck/fight/{idAlly}/{idEnemy}")
	public ResponseEntity<String> fight(@PathVariable Long idAlly, @PathVariable Long idEnemy) {
		return ResponseEntity.ok(deckService.fight(idAlly, idEnemy));
	}
}
