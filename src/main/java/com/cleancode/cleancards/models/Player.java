package com.cleancode.cleancards.models;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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

	public Player(String pseudo) {
		this.pseudo = pseudo;
		this.tokens = 4;
	}
}


