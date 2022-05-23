package com.company.Cards;

import java.util.ArrayList;

public class AblageStapel {
    public ArrayList<Card> ablageStapel;

    public AblageStapel() {
        ablageStapel = new ArrayList<>();
    }

    public ArrayList<Card> getAblageStapel() {
        return ablageStapel;
    }

    //eine methode damit eine karte schon da ist, und eine um karten hinzufügen.

    public void ersteKarte(Deck probe) {
        probe.drawCard();
        ablageStapel.add(probe.drawCard());
    }

    public void ablegen(Card karte) {
        ablageStapel.add(karte);
    }
}
