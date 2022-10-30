package com.cleancode.cleancards.service;

import com.cleancode.cleancards.models.Deck;
import com.cleancode.cleancards.models.Player;
import com.cleancode.cleancards.repository.DeckRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Service
public class DeckService {
    private final DeckRepository deckRepository;

    public void createDeck(Player subscribePlayer) {
        Deck deck = new Deck(subscribePlayer);
        deckRepository.save(deck);
    }

    public List<Deck> findByPlayer(Player player) {
        return deckRepository.findByPlayer(player);
    }

    public void updateDeck(Deck newDeck) {
        deckRepository.save(newDeck);
    }
}
