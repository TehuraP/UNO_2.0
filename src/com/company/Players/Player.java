package com.company.Players;

import com.company.Cards.Card;

import java.util.ArrayList;

public abstract class Player {
    private String name;
    private int points;
    private ArrayList<Card> hand;
    private boolean UNOStatus;

    public Player(String name) {
        this.name = name;
        this.points = 0;
        this.hand = new ArrayList<>() ;
        this.UNOStatus = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoints() {
        return points;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public void setHand(ArrayList<Card> hand) {
        this.hand = hand;
    }

    public void takeCard(Card card) {
        hand.add(card);
    }

    public String printHand(){
        return hand.toString();
    }

    public abstract Card playCard (String cardInput);

}

