package com.cleancode.cleancards.service;

import com.cleancode.cleancards.models.Deck;
import com.cleancode.cleancards.models.Hero;
import com.cleancode.cleancards.models.Player;
import com.cleancode.cleancards.repository.DeckRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    public Iterable<Deck> findAll() {
        return deckRepository.findAll();
    }

    public List<Deck> findAllNotPlayer_IdPlayer(Long idPlayer) {
        return deckRepository.findAllByPlayer_IdPlayerNot(idPlayer);
    }

    public String fight(Long idAlly, Long idEnemy) {
        List<Deck> decks = fightIsCorrect(idAlly, idEnemy);

        Hero heroAlly = decks.get(0).getHero();
        Player playerAlly = decks.get(0).getPlayer();
        Hero heroEnemy = decks.get(1).getHero();
        Player playerEnemy = decks.get(1).getPlayer();

        while (heroAlly.getHp() > 0 && heroEnemy.getHp() > 0) {
            heroAlly.setHp(heroAlly.getHp() - (heroEnemy.getPower() - heroAlly.getArmor()));
            heroEnemy.setHp(heroEnemy.getHp() - (heroAlly.getPower() - heroEnemy.getArmor()));
        }

        return getWinnerOfFight(heroAlly, heroEnemy, playerAlly, playerEnemy);
    }

    private String getWinnerOfFight(Hero heroAlly, Hero heroEnemy, Player playerAlly, Player playerEnemy) {
        if (heroAlly.getHp() > 0) {
            heroAlly.updateExperience();
            playerAlly.winner();
            return "The winner is " + playerAlly.getPseudo();
        } else {
            heroEnemy.updateExperience();
            playerEnemy.winner();
            return "The winner is " + playerEnemy.getPseudo();
        }
    }

    public List<Deck> fightIsCorrect(Long idAlly, Long idEnemy) {
        List<Deck> decks = new ArrayList<>();
        if (deckRepository.findById(idAlly).isPresent() && deckRepository.findById(idEnemy).isPresent()) {
            Deck deckAlly = deckRepository.findById(idAlly).get();
            Deck deckEnemy = deckRepository.findById(idEnemy).get();
            Hero heroAlly = deckAlly.getHero();
            Hero heroEnemy = deckEnemy.getHero();
            if (!Objects.equals(deckAlly.getPlayer().getIdPlayer(), deckEnemy.getPlayer().getIdPlayer())) {
                if (heroAlly == null || heroEnemy == null) {
                    throw new IllegalArgumentException("Hero is not exist");
                } else {
                    if (heroAlly.getLevel() > heroEnemy.getLevel()) {
                        throw new IllegalArgumentException("Hero level is not correct");
                    }
                }
            } else {
                throw new IllegalArgumentException("Player is not correct");
            }
            decks.add(deckAlly);
            decks.add(deckEnemy);
        } else {
            throw new IllegalArgumentException("Deck is not exist");
        }
        return decks;
    }
}
