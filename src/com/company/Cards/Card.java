package com.company.Cards;

import java.util.Locale;

public class Card {
    public Type type;
    public Value value;
    private String card;
    private int cardPoints;

    public Card(Type type, Value value) {

        this.type = type;
        this.value = value;
        card = type.name() + " " + value.name();
        cardPoints = value.points;
    }

    public int getCardPoints() {
        return cardPoints;
    }

    public Card(Value value) {
        this.value = value;
        this.card = value.name();
    }

    public Type getType() {
        return type;
    }

    public Value getValue() {
        return value;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    public String getCard() {
        return card.toLowerCase(Locale.ROOT);
    }

    @Override
    public String toString() {
        return card;
    }
}
