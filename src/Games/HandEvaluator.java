package Games;

import java.util.*;
import java.util.stream.Collectors;

public class HandEvaluator {
    private Hand hand;
    private ArrayList<Card> communityCards;
    private ArrayList<Card> allCards = new ArrayList<>();
    Map<Integer, Long> rankMap;
    Map<Suit, Long> suitMap;



    public HandEvaluator(Hand hand, ArrayList<Card> communityCards) {
        this.hand = hand;
        this.communityCards = communityCards;
        this.allCards.addAll(hand.getCards());
        this.allCards.addAll(communityCards);
        Collections.sort(allCards);
        rankMap = allCards.stream().collect(
                Collectors.groupingBy(Card::getRank, Collectors.counting()));
        suitMap = allCards.stream().collect(
                Collectors.groupingBy(Card::getSuit, Collectors.counting()));

    }

    public HandRank highCard() {
        return new HandRank(1, allCards.get(allCards.size() - 1).getRank());
    }

    public HandRank pairs() {
        List<HandRank> pairHands = new ArrayList<>();
        for (int i = 0; i < allCards.size(); i++) {
            for (int j = i + 1; j < allCards.size(); j++) {
                if (allCards.get(i).getRank() == allCards.get(j).getRank()) {
                    pairHands.add(new HandRank(2, allCards.get(i).getRank()));
                }
            }
        }
        if (!pairHands.isEmpty()) {
            if (pairHands.size() > 1) {
                return new HandRank(3, Collections.max(pairHands).getSubHandRank());
            } else {
                return Collections.max(pairHands);
            }
        }
        return new HandRank(0,0);
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
            return new HandRank(5, maxCard);
        }
        return new HandRank(0,0);
    }

    public HandRank flush() {
        int spades = 0;
        int spadesMax = 0;
        int club = 0;
        int clubMax = 0;
        int diamonds = 0;
        int diamondsMax = 0;
        int hearts = 0;
        int heartsMax = 0;
        for (int i = 0; i < allCards.size(); i++) {
            if (allCards.get(i).getSuit() == Suit.SPADES) {
                spades++;
                spadesMax = allCards.get(i).getRank();
            }
            if (allCards.get(i).getSuit() == Suit.CLUBS) {
                club++;
                clubMax = allCards.get(i).getRank();
            }
            if (allCards.get(i).getSuit() == Suit.DIAMONDS) {
                diamonds++;
                diamondsMax = allCards.get(i).getRank();
            }
            if (allCards.get(i).getSuit() == Suit.HEARTS) {
                hearts++;
                heartsMax = allCards.get(i).getRank();
            }
        }

        if (spades >= 5) {
            return new HandRank(6, spadesMax);
        }
        if (club >= 5) {
            return new HandRank(6, clubMax);
        }
        if (diamonds >= 5) {
            return new HandRank(6, diamondsMax);
        }
        if (hearts >= 5) {
            return new HandRank(6, heartsMax);
        }
        return new HandRank(0,0);
    }



    public HandRank ofAKind() {
        for (Map.Entry<Integer, Long> pairs : rankMap.entrySet()) {
            if (pairs.getValue() > 3) {
                return new HandRank(8, pairs.getKey());
            }
            if (pairs.getValue() > 2) {
                return new HandRank(4, pairs.getKey());
            }
        }
        return new HandRank(0, 0);
    }

    public HandRank fullHouse() {
        boolean full = false;
        boolean house = false;
        int key = 0;
        for (Map.Entry<Integer, Long> pairs : rankMap.entrySet()) {
            if (pairs.getValue() == 3) {
                full = true;
                key = pairs.getKey();
            }
            if (pairs.getValue() == 2) {
                house = true;
            }
        }

        if (full && house) {
            return new HandRank(7, key);
        }
        return new HandRank(0, 0);
    }

    public HandRank straightFlush() {
        int counter = 0;
        int maxCard = 0;
        for (int i = 0; i < allCards.size() - 1; i++) {
            int card1Rank = allCards.get(i).getRank() + 1;
            Suit card1Suit = allCards.get(i).getSuit();
            int card2Rank = allCards.get(i + 1).getRank();
            Suit card2Suit = allCards.get(i + 1).getSuit();
            if (card1Rank == card2Rank && card1Suit == card2Suit) {
                counter++;
                maxCard = card2Rank;
            } else if (counter < 4){
                counter = 0;
            }
        }
        if (counter >= 4) {
            return new HandRank(9, maxCard);
        }
        return new HandRank(0,0);
    }
}
