package com.cleancode.cleancards.model;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@Data
public
class Hero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private Integer hp;
    @NotNull
    private Integer xp;
    @NotNull
    private Integer power;
    @NotNull
    private Integer armor;
    @NotNull
    private String specialty;
    @NotNull
    private String rarity;
    @NotNull
    private Integer level;

}
