import Games.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class HandEvaluatorTest {
    Card twoClub = new Card(Rank.TWO, Suit.CLUBS);
    Card threeClub = new Card(Rank.THREE, Suit.CLUBS);
    Card fourClub = new Card(Rank.FOUR, Suit.CLUBS);
    Card fiveClub = new Card(Rank.FIVE, Suit.CLUBS);
    Card sixClub = new Card(Rank.SIX, Suit.CLUBS);
    Card sevenClub = new Card(Rank.SEVEN, Suit.CLUBS);
    Card eightClub = new Card(Rank.EIGHT, Suit.CLUBS);
    Card nineClub = new Card(Rank.NINE, Suit.CLUBS);
    Card tenClub = new Card(Rank.TEN, Suit.CLUBS);
    Card twoDiamond = new Card(Rank.TWO, Suit.DIAMONDS);
    Card threeDiamond = new Card(Rank.THREE, Suit.DIAMONDS);
    Card fourDiamond = new Card(Rank.FOUR, Suit.DIAMONDS);
    Card fiveDiamond = new Card(Rank.FIVE, Suit.DIAMONDS);
    Card sixDiamond = new Card(Rank.SIX, Suit.DIAMONDS);
    Card sevenDiamond = new Card(Rank.SEVEN, Suit.DIAMONDS);
    Card eightDiamond = new Card(Rank.EIGHT, Suit.DIAMONDS);
    Card nineDiamond = new Card(Rank.NINE, Suit.DIAMONDS);
    Card tenDiamond = new Card(Rank.TEN, Suit.DIAMONDS);
    HandEvaluator he;

    @BeforeEach
    public void setup() {
    }

    @Test
    public void straight_isStraight_returnsTrue() {
        ArrayList<Card> handCards = new ArrayList<>(Arrays.asList(twoClub, threeClub));
        ArrayList<Card> communityCards = new ArrayList<>(Arrays.asList(fourClub, fiveClub, sixClub, sevenClub, eightClub));
        Hand hand = new Hand(handCards);

        he = new HandEvaluator(hand, communityCards);
        boolean result = he.straight();
        assertTrue(result);
    }

    @Test
    public void straight_notStraight_returnsFalse() {
        ArrayList<Card> handCards = new ArrayList<>(Arrays.asList(twoClub, threeClub));
        ArrayList<Card> communityCards = new ArrayList<>(Arrays.asList(eightClub, fiveClub, sixClub, sevenClub, eightClub));
        Hand hand = new Hand(handCards);

        he = new HandEvaluator(hand, communityCards);
        boolean result = he.straight();
        assertFalse(result);
    }

    @Test
    public void straight_communityCardStraight_returnsTrue() {
        ArrayList<Card> handCards = new ArrayList<>(Arrays.asList(tenClub, tenClub));
        ArrayList<Card> communityCards = new ArrayList<>(Arrays.asList(fourClub, fiveClub, sixClub, sevenClub, eightClub));
        Hand hand = new Hand(handCards);

        he = new HandEvaluator(hand, communityCards);
        boolean result = he.straight();
        assertTrue(result);
    }

    @Test
    public void straight_handAndCommunityCardStraight_returnsTrue() {
        ArrayList<Card> handCards = new ArrayList<>(Arrays.asList(nineClub, tenClub));
        ArrayList<Card> communityCards = new ArrayList<>(Arrays.asList(fourClub, fourClub, sixClub, sevenClub, eightClub));
        Hand hand = new Hand(handCards);

        he = new HandEvaluator(hand, communityCards);
        boolean result = he.straight();
        assertTrue(result);
    }

    @Test
    public void flush_isFlush_returnsTrue() {
        ArrayList<Card> handCards = new ArrayList<>(Arrays.asList(twoClub, threeClub));
        ArrayList<Card> communityCards = new ArrayList<>(Arrays.asList(fourClub, fiveClub, sixClub, sevenClub, eightClub));
        Hand hand = new Hand(handCards);

        he = new HandEvaluator(hand, communityCards);
        boolean result = he.flush();
        assertTrue(result);
    }

    @Test
    public void flush_notFlush_returnsFalse() {
        ArrayList<Card> handCards = new ArrayList<>(Arrays.asList(twoDiamond, threeClub));
        ArrayList<Card> communityCards = new ArrayList<>(Arrays.asList(eightDiamond, fiveDiamond, sixClub, sevenClub, eightClub));
        Hand hand = new Hand(handCards);

        he = new HandEvaluator(hand, communityCards);
        boolean result = he.flush();
        assertFalse(result);
    }

    @Test
    public void flush_communityCardFlush_returnsTrue() {
        ArrayList<Card> handCards = new ArrayList<>(Arrays.asList(tenClub, tenClub));
        ArrayList<Card> communityCards = new ArrayList<>(Arrays.asList(fourDiamond, fiveDiamond, sixDiamond, sevenDiamond, eightDiamond));
        Hand hand = new Hand(handCards);

        he = new HandEvaluator(hand, communityCards);
        boolean result = he.flush();
        assertTrue(result);
    }

    @Test
    public void flush_handAndCommunityCardFlush_returnsTrue() {
        ArrayList<Card> handCards = new ArrayList<>(Arrays.asList(nineDiamond, tenClub));
        ArrayList<Card> communityCards = new ArrayList<>(Arrays.asList(fourDiamond, fourDiamond, sixDiamond, sevenDiamond, eightClub));
        Hand hand = new Hand(handCards);

        he = new HandEvaluator(hand, communityCards);
        boolean result = he.flush();
        assertTrue(result);
    }
}