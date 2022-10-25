package com.cleancode.cleancards.service;

import com.cleancode.cleancards.models.CardsPack;
import com.cleancode.cleancards.repository.CardsPackRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CardsPackService {
	private final CardsPackRepository cardsPackRepository;

	public void createCardsPack(CardsPack cardsPack) {
		CardsPack createCardsPack = new CardsPack(cardsPack.getType());
		cardsPackRepository.save(createCardsPack);
	}

	public Iterable<CardsPack> findAll() {
		return cardsPackRepository.findAll();
	}

	public CardsPack findById(Long id) {
		if (cardsPackRepository.findById(id).isPresent()) {
			return cardsPackRepository.findById(id).get();
		}
		throw new IllegalArgumentException("cards pack with id " + id + " is not exist.");
	}


}
