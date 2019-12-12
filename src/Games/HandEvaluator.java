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
    }

    public boolean straight() {
        Collections.sort(allCards);
        int counter = 0;
        for (int i = 0; i < allCards.size() - 1; i++) {
            if (allCards.get(i).getRank().ordinal() == allCards.get(i + 1).getRank().ordinal()) {
                counter++;
            }
        }
        if (counter >= 5) {
            return true;
        }
        return false;
    }
}
