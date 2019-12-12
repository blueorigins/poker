package Games;

import Games.*;

import java.util.ArrayList;

public class Deck {
    private int cardCount;
    private Game game;
    private ArrayList<Card> deck;

    public Deck(int cardCount, Game game) {
        this.game = game;
        this.cardCount = cardCount;
        this.deck = createDeck(cardCount, game);
    }

    private ArrayList<Card> createDeck(int cardCount, Game game) {
        ArrayList<Card> cards = new ArrayList<>();
        if (game.getClass() == TexasHoldEm.class) {
            for (Rank r : Rank.values()) {
                for (Suit s : Suit.values()) {
                    cards.add(new Card(r, s));
                }
            }
        }
        return cards;
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }

    public void deal(ArrayList<Player> players) {
        for (int i = 0; i < players.size(); i++) {
            players.get(i).setHand(new Hand(getCardFromDeck(2)));
        }
    }

    public ArrayList<Card> getCardFromDeck(int cards) {
        ArrayList<Card> cardAgg = new ArrayList<>();
        for (int i = 0; i < cards; i++) {
            cardAgg.add(deck.remove(0));
        }
        return cardAgg;
    }

    public void printDeck() {
        System.out.println(deck);
    }
}
