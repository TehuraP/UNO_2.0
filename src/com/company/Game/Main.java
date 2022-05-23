package com.company.Game;

import com.company.Cards.Deck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


//        Deck deck = new Deck();
//        deck.shuffle();
////        Collections.shuffle(deck);
//        System.out.println(deck.toString());
        Scanner input = new Scanner(System.in);
        App app = new App(input, System.out);
        app.Run();
        input.close();
        System.out.println("Das Programm wird beendet ...");
    }
}
