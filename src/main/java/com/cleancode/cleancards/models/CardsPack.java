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
public class CardsPack {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	@NotNull
	private Integer requiredTokens;
	@NotNull
	private Integer cardsNumber;
	@NotNull
	private CardsPackType type;
	@NotNull
	private Double legendaryDropRate;
	@NotNull
	private Double rareDropRate;
	@NotNull
	private Double commonDropRate;

	public CardsPack(CardsPackType type) {
		this.type = type;
		switch (type) {
			case Argent -> {
				this.requiredTokens = 1;
				this.cardsNumber = 3;
				this.legendaryDropRate = 0.05;
				this.rareDropRate = 0.2;
				this.commonDropRate = 0.75;
			}
			case Diamant -> {
				this.requiredTokens = 2;
				this.cardsNumber = 5;
				this.legendaryDropRate = 0.15;
				this.rareDropRate = 0.35;
				this.commonDropRate = 0.5;
			}
		}
	}
}
