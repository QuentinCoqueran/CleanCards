package com.cleancode.cleancards.models;

import com.cleancode.cleancards.enums.Rarity;
import com.cleancode.cleancards.enums.Speciality;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
public class Hero {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idHero;
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
	@Enumerated(EnumType.STRING)
	@NotNull
	private Speciality specialty;
	@Enumerated(EnumType.STRING)
	@NotNull
	private Rarity rarity;
	@NotNull
	private Integer level;

	public Hero(String name, Speciality speciality, Rarity rarity) {
		this.specialty = speciality;
		this.rarity = rarity;
		this.name = name;
		this.level = 1;
		this.xp = 0;
		switch (speciality) {
			case Tank -> {
				this.hp = 1000;
				this.power = 100;
				this.armor = 20;
			}
			case Assassin -> {
				this.hp = 800;
				this.power = 200;
				this.armor = 5;
			}
			case Mage -> {
				this.hp = 700;
				this.power = 150;
				this.armor = 10;
			}
		}
		switch (rarity) {
			case Common:
				break;
			case Rare:
				this.hp += (this.hp * 10) / 100;
				this.power += (this.power * 10) / 100;
				this.armor += (this.armor * 10) / 100;
				break;
			case Legendary:
				this.hp += (this.hp * 20) / 100;
				this.power += (this.power * 20) / 100;
				this.armor += (this.armor * 20) / 100;
				break;
		}
	}

	public void updateExperience() {
		this.xp += 1;
		if (this.xp == 5) {
			this.xp = 0;
			this.level += 1;
			this.hp += (this.hp * 10) / 100;
			this.power += (this.power * 10) / 100;
			this.armor += (this.armor * 10) / 100;
		}
	}

}
