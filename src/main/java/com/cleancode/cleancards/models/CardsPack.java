package com.cleancode.cleancards.models;

public class CardsPack {
    private Integer requiredTokens;
    private Integer cardsNumber;
    private CardsPackType type;
    private Double legendaryDropRate;
    private Double rareDropRate;
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
