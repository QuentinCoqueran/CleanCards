package com.cleancode.cleancards.models;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPlayer;

    @NotNull
    private String pseudo;

    private Integer tokens;

    @Column(columnDefinition = "Integer default 0")
    private Integer winCount = 0;

    public Player(String pseudo) {
        this.pseudo = pseudo;
        this.tokens = 4;
    }

    public void winner() {
        if (this.winCount < 5) {
            this.winCount += 1;
        } else {
            this.tokens += 1;
            this.winCount = 0;
        }
    }
}


