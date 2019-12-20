package Games;

import java.util.ArrayList;
import java.util.Collections;

public class HandEvaluator {
    private Hand hand;
    private ArrayList<Card> communityCards;
    private ArrayList<Card> allCards = new ArrayList<>();


    public HandEvaluator(Hand hand, ArrayList<Card> communityCards) {
        this.hand = hand;
        this.communityCards = communityCards;
        this.allCards.addAll(hand.getCards());
        this.allCards.addAll(communityCards);
        Collections.sort(allCards);
    }

    public HandRank straight() {
        int counter = 0;
        int maxCard = 0;
        for (int i = 0; i < allCards.size() - 1; i++) {
            int card1 = allCards.get(i).getRank() + 1;
            int card2 = allCards.get(i + 1).getRank();
            if (card1 == card2) {
                counter++;
                maxCard = card2;
            } else if (counter < 4){
                counter = 0;
            }
        }
        if (counter >= 4) {
            return new HandRank(4, maxCard);
        }
        return new HandRank(0,0);
    }

    public HandRank flush() {
        int spades = 0;
        int club = 0;
        int diamonds = 0;
        int hearts = 0;
        int maxCard = 0;
        for (int i = 0; i < allCards.size() - 1; i++) {
            if (allCards.get(i).getSuit() == Suit.SPADES) {
                spades++;
                maxCard = allCards.get(i).getRank();
            }
            if (allCards.get(i).getSuit() == Suit.CLUBS) {
                club++;
                maxCard = allCards.get(i).getRank();
            }
            if (allCards.get(i).getSuit() == Suit.DIAMONDS) {
                diamonds++;
                maxCard = allCards.get(i).getRank();
            }
            if (allCards.get(i).getSuit() == Suit.HEARTS) {
                hearts++;
                maxCard = allCards.get(i).getRank();
            }
        }

        if (spades >= 4 || club >= 4 || diamonds >= 4 || hearts >= 4) {
            return new HandRank(5, maxCard);
        }
        return new HandRank(0,0);
    }
}
