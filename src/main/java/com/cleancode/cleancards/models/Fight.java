package com.cleancode.cleancards.models;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
public class Fight {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idFight;

	@ManyToOne
	@JoinColumn(name = "idHeroAlly")
	@NotNull
	Hero idHeroAlly;

	@ManyToOne
	@JoinColumn(name = "idHeroEnemy")
	@NotNull
	Hero idHeroEnemy;

	@NotNull
	private boolean isWin;

}
