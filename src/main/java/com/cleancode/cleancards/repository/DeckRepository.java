package com.cleancode.cleancards.repository;

import com.cleancode.cleancards.models.Deck;
import com.cleancode.cleancards.models.Player;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DeckRepository extends CrudRepository<Deck, Long> {
    List<Deck> findByPlayer(Player player);
    List<Deck> findAllByPlayer_IdPlayerNot(Long id);
}
