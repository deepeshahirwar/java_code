import java.util.Random;
import java.util.Scanner;

public class CardGame10 {
 
 // this is our main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] deck = initializeDeck();

        System.out.print("Enter the number of players: ");
        int numPlayers = scanner.nextInt();
        System.out.print("Enter the number of cards to distribute to each player: ");
        int cardsPerPlayer = scanner.nextInt();

        
        deck = shuffleDeck(deck);

       
        String[][] players = distributeCards(deck, numPlayers, cardsPerPlayer);

       
        printPlayersCards(players);

        scanner.close();
    }

    // this for dack and card
    public static String[] initializeDeck() {
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        int numOfCards = suits.length * ranks.length;
        String[] deck = new String[numOfCards];

        int index = 0;
        for (String suit : suits) {
            for (String rank : ranks) {
                deck[index++] = rank + " of " + suit;
            }
        }
        return deck;
    }

    //  shuffle the deck of cards
    public static String[] shuffleDeck(String[] deck) {
        Random random = new Random();
        for (int i = 0; i < deck.length; i++) {
            int randomCardNumber = i + random.nextInt(deck.length - i);
            
            // for swapping
            String temp = deck[i];
            deck[i] = deck[randomCardNumber];
            deck[randomCardNumber] = temp;
        }
        return deck;
    }

    //for distributing cards to players
    public static String[][] distributeCards(String[] deck, int numPlayers, int cardsPerPlayer) {
        int totalCards = numPlayers * cardsPerPlayer;
        if (totalCards > deck.length) {
            System.out.println("Not enough cards to distribute.");
            return new String[0][0];
        }

        String[][] players = new String[numPlayers][cardsPerPlayer];
        int cardIndex = 0;

        for (int i = 0; i < numPlayers; i++) {
            for (int j = 0; j < cardsPerPlayer; j++) {
                players[i][j] = deck[cardIndex++];
            }
        }
        return players;
    }

    // this method for print the players cards
    public static void printPlayersCards(String[][] players) {
        for (int i = 0; i < players.length; i++) {
            System.out.print("Player " + (i + 1) + ": ");
            for (String card : players[i]) {
                System.out.print(card + ", ");
            }
            System.out.println();
        }
    }
}