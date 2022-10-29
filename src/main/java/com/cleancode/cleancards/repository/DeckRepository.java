package com.cleancode.cleancards.repository;

import com.cleancode.cleancards.models.Deck;
import com.cleancode.cleancards.models.Player;
import org.springframework.data.repository.CrudRepository;

public interface DeckRepository extends CrudRepository<Deck, Long> {
    Deck findByPlayer(Player player);
}
