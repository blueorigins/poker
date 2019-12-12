package Games;

import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> cards;

    public Hand(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public String toString() {
        StringBuilder hand = new StringBuilder();
        for (Card card : cards) {
            hand.append(card);
        }
        return hand.toString();
    }

    public ArrayList<Card> getCards() {
        return cards;
    }
}
