package com.company.Cards;

import java.util.Collections;
import java.util.Stack;

public class Deck {
    private Type[] type;
    private Value[] value;
    public Stack<Card> deck;

    public Deck() {
        this.type =  Type.values();
        this.value = Value.values();
        this.deck = new Stack<>();
        Card card;
        for (Value v : Value.values()){

            for (Type t : Type.values()) {

                if (t.name().contains("WILD")){
                    if (v.name().contains("COLOR")||v.name().contains("PLUS4")) {
                        card = new Card(t, v);
                        deck.push(card);
                        deck.push(card);
                        deck.push(card);
                        deck.push(card);
                    }
                } else if (!v.name().contains("COLOR") && !v.name().contains("PLUS4")) {
                    if (v.name().contains("ZERO")) {
                        card = new Card(t, v);
                        deck.push(card);
                    } else {
                        card = new Card(t, v);
                        deck.push(card);
                        deck.push(card);
                    }
                }

            }

        }
    }

    @Override
    public String toString() {
        return "Deck{" +
                "deck=" + deck +
                '}';
    }

    public void shuffle () {
        Collections.shuffle(deck);
    }
}
