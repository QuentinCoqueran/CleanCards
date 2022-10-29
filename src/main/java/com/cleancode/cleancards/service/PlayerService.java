package com.cleancode.cleancards.service;

import com.cleancode.cleancards.models.Deck;
import com.cleancode.cleancards.models.Player;
import com.cleancode.cleancards.repository.DeckRepository;
import com.cleancode.cleancards.repository.PlayerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@AllArgsConstructor
@Service
public class PlayerService {
    private final PlayerRepository playerRepository;
    private final DeckService deckService;

    @Transactional
    public void subscribePlayer(Player player) {
        Player subscribePlayer = new Player(player.getPseudo());
        playerRepository.save(subscribePlayer);
        deckService.createDeck(subscribePlayer);
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

    @Transactional
    public Deck findDeckByIdPlayer(Long id) {
        Player player = findById(id);
        Deck deck = deckService.findByPlayer(player);
        if (deck != null) {
            return deck;
        }
        throw new IllegalArgumentException("Deck with id " + id + " is not exist.");
    }

}
