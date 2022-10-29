package com.cleancode.cleancards.service;

import com.cleancode.cleancards.models.*;
import com.cleancode.cleancards.repository.CardsPackRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class CardsPackService {
    private final CardsPackRepository cardsPackRepository;
    private final PlayerService playerService;
    private final DeckService deckService;
    private final HeroService heroService;

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

    public void openCardsPack(Long idCardsPack, Long idPlayer) {
        CardsPack cardsPack = findById(idCardsPack);
        Player player = playerService.findById(idPlayer);
        boolean isEnoughTokens = checkPlayerTokensIsEnough(cardsPack, player);
        if (isEnoughTokens) {
            //if is enough we open the cards pack, and we add the cards to the player deck
            addHeroIntoPlayerDeck(cardsPack, player);
        } else {
            throw new IllegalArgumentException("Player with id " + idPlayer + " has not enough tokens.");
        }
    }

    public boolean checkPlayerTokensIsEnough(CardsPack cardsPack, Player player) {
        //we check if the player has enough coins to open the cards pack
        return player.getTokens() >= cardsPack.getRequiredTokens();
    }

    public List<Hero> createRandomListByDropRate(CardsPack cardsPack) {
        //we create a list of heroes, and we add the hero in the list according to the drop rate
        List<Hero> randomHeroesList = new ArrayList<>();
        int dropRateLegendary = (int) ((cardsPack.getLegendaryDropRate() * 100));
        int dropRateRare = (int) ((cardsPack.getRareDropRate() * 100));
        int dropRateCommon = (int) ((cardsPack.getCommonDropRate() * 100));

        for (int i = 0; i < dropRateLegendary; i++) {

            randomHeroesList.add(heroService.findByRarity(Rarity.Legendary));
        }
        for (int i = 0; i < dropRateRare; i++) {
            randomHeroesList.add(heroService.findByRarity(Rarity.Rare));
        }
        for (int i = 0; i < dropRateCommon; i++) {
            randomHeroesList.add(heroService.findByRarity(Rarity.Common));
        }
        return randomHeroesList;
    }

    public void addHeroIntoPlayerDeck(CardsPack cardsPack, Player player) {
        List<Hero> randomHeroesList = createRandomListByDropRate(cardsPack);
        //about the cards pack type, we add a number of cards into the player deck
        for (int i = 0; i < cardsPack.getCardsNumber(); i++) {
            chooseDeckToSetHero(player, randomHeroesList);
        }
    }

    public void chooseDeckToSetHero(Player player, List<Hero> heroesRandomList) {
        //we need to know if the player have a hero in the deck, or we need to create a new line deck
        List<Deck> deck = deckService.findByPlayer(player);
        Deck deckToSetHero = deck.get(deck.size() - 1);

        if (deckToSetHero.getHero() != null) {
            Deck newDeck = new Deck(player);
            //we need to set the hero in the new deck about the drop rate of cards pack type
            newDeck.setHero(getHeroFromCardsPackByDropRate(heroesRandomList));
            deckService.updateDeck(newDeck);
        } else {
            deckToSetHero.setHero(getHeroFromCardsPackByDropRate(heroesRandomList));
            deckService.updateDeck(deckToSetHero);
        }
    }

    public Hero getHeroFromCardsPackByDropRate(List<Hero> randomHeroesList) {
        return randomHeroesList.get((int) (Math.random() * randomHeroesList.size()));
    }
}
