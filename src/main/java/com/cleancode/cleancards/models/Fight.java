package com.cleancode.cleancards.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Fight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String idFight;


    @ManyToOne
    @JoinColumn(name = "idHero")
    Hero idHeroAlly;

    @ManyToOne
    @JoinColumn(name = "idHero")
    Hero idHeroEnemy;

    private Boolean isWin;

}
