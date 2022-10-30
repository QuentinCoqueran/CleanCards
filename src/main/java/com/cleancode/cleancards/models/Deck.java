package com.cleancode.cleancards.models;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
public class Deck {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idPlayer")
    @NotNull
    Player player;

    @ManyToOne
    @JoinColumn(name = "idHero")
    Hero hero;

    public Deck(Player player) {
        this.player = player;
    }
    
}
