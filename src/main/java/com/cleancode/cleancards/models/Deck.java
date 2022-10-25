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
	@MapsId("id")
	@JoinColumn(name = "id")
	@NotNull
	Player player;

	@ManyToOne
	@MapsId("id")
	@JoinColumn(name = "id")
	Hero hero;
}
