package com.cleancode.cleancards.repository;

import com.cleancode.cleancards.models.Deck;
import org.springframework.data.repository.CrudRepository;

public interface DeckRepository extends CrudRepository<Deck, Long> {
}
