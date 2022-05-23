package com.company.Players;

import com.company.Cards.Card;

import java.util.ArrayList;

public class HumanPlayer extends Player {
    public HumanPlayer(String name) {
        super(name);
    }

    @Override
    public Card playCard(String cardInput) {

        for (int i = 0; i < getHand().size(); i++) {
            Card card = getHand().get(i);
            if (card.getCard().equals(cardInput)) {

                getHand().remove(card);

                return card;
            }
        }
        return null;
    }
}
