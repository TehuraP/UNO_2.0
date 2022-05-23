package com.company.Cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class Deck {
    private Type[] type;
    private Value[] value;
    public ArrayList<Card> deck;

    public Deck() {
        this.type =  Type.values();
        this.value = Value.values();
        this.deck = new ArrayList<Card>();
        Card card;
        for (Value v : Value.values()){

            for (Type t : Type.values()) {

                if (t.name().contains("WILD")){
                    if (v.name().contains("COLOR")||v.name().contains("PLUS4")) {
                        card = new Card(t, v);
                        deck.add(card);
                        deck.add(card);
                        deck.add(card);
                        deck.add(card);
                    }
                } else if (!v.name().contains("COLOR") && !v.name().contains("PLUS4")) {
                    if (v.name().contains("ZERO")) {
                        card = new Card(t, v);
                        deck.add(card);
                    } else {
                        card = new Card(t, v);
                        deck.add(card);
                        deck.add(card);
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

    public Card drawCard(){
        return deck.remove(deck.size()-1);
    }

}
