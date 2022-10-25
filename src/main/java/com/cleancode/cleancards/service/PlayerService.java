package com.cleancode.cleancards.service;

import com.cleancode.cleancards.models.Deck;
import com.cleancode.cleancards.models.Player;
import com.cleancode.cleancards.repository.DeckRepository;
import com.cleancode.cleancards.repository.PlayerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@Service
public class PlayerService {
	private final PlayerRepository playerRepository;
	private final DeckRepository deckRepository;

	public void subscribePlayer(Player player) {
		Player subscribePlayer = new Player(player.getPseudo());
		playerRepository.save(subscribePlayer);
		Deck deck = new Deck();
		deck.setPlayer(subscribePlayer);
		deckRepository.save(deck);
	}

	public Iterable<Player> findAll() {
		return playerRepository.findAll();
	}

	public Player findById(Long id) {
		if (playerRepository.findById(id).isPresent()) {
			return playerRepository.findById(id).get();
		}
		throw new IllegalArgumentException("Player with id " + id + " is not exist.");
	}

}
