package com.company.Game;

import com.company.Cards.AblageStapel;
import com.company.Cards.Card;
import com.company.Cards.Deck;
import com.company.Players.HumanPlayer;
import com.company.Players.Player;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.Scanner;

public class App {
    private Deck deck = new Deck();
    private ArrayList<Player> players = new ArrayList<Player>();
    private AblageStapel stapel = new AblageStapel();
    private final Scanner input;
    private final PrintStream output;
    private Player currentPlayer;
    private boolean exit = false;
    private int currentPlayerIndex = 0;

    public App(Scanner input, PrintStream output) {
        this.input = input;
        this.output = output;
    }

    public void addPlayer() {
        String name;
        for (int j = 0; j < 4; j++) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter your name");

            name = scanner.next();

            System.out.println("Hallo, " + name);
            HumanPlayer sp1 = new HumanPlayer(name);
            players.add(sp1);
        }
    }

    public void handOut(Player spieler) {

        for (int i = 0; i < 7; i++) {
            spieler.takeCard(deck.drawCard());

        }
    }

    // gameloop implementieren
    public void Run() {
        // alles was einmal stattfindet: handout(take card), namen eingeben,
        initialize();
        //karteAblegen();
        while (!exit) {
            printState();
            String cardInput = readInput(input);
            System.out.println("Ihre Eingabe war: " + cardInput);
            karteAblegen(cardInput.toLowerCase(Locale.ROOT));
            currentPlayer = nextPlayer();


        }

        //TODO: Schleife draus machen! Darf/Muss noch verändert werden --> Doppelschleife

        //karte muss ausgewählt werden, dann gespielt, entfernt von die handout und im stapel hingefügt
        //spielrunden(game), draw/remove card
    }

    public void initialize() {
        deck.shuffle();
        addPlayer();
        for (Player sp : players) {
            handOut(sp);
        }

        stapel.ersteKarte(deck);
        Collections.shuffle(players);
        currentPlayer = players.get(0);
        //random player beginnt

    }

    private void printState() {
        //welche karte gespielt wurde

        output.println(currentPlayer.printHand());
    }


    public void karteAblegen(String cardInput) {
        Card card = currentPlayer.playCard(cardInput);
        if (card == null){
            System.out.println("Bitte gültige Karte eingeben.");
        }
        System.out.println("You chose card " + card);
        stapel.ablegen(card);
    }

    //TODO methode, um zu überprüfen, ob Input-Wert einer Karte entspricht --> auf der Hand
    // mit Schleife machen!!!
    // wenn beide equal sind --> Karte kann gespielt werden

    public String readInput(Scanner eingabe) {
        System.out.println("Bitte Karte eingeben: ");
        String var = eingabe.nextLine();
        // TODO: var.split() --> muss aufgeteilt werden, weil man sonst die einzelnen Strings nicht trennen kann

        return var;
    }

    public Player nextPlayer () {
        currentPlayerIndex++;
        if (currentPlayerIndex > 3){
            currentPlayerIndex = 0;
        }
        return players.get(currentPlayerIndex);
    }



}
