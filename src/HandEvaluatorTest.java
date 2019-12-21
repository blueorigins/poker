import Games.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
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
    Card jackClub = new Card(Rank.JACK, Suit.CLUBS);
    Card queenClub = new Card(Rank.QUEEN, Suit.CLUBS);
    Card kingClub = new Card(Rank.KING, Suit.CLUBS);
    Card aceClub = new Card(Rank.ACE, Suit.CLUBS);
    Card twoDiamond = new Card(Rank.TWO, Suit.DIAMONDS);
    Card threeDiamond = new Card(Rank.THREE, Suit.DIAMONDS);
    Card fourDiamond = new Card(Rank.FOUR, Suit.DIAMONDS);
    Card fiveDiamond = new Card(Rank.FIVE, Suit.DIAMONDS);
    Card sixDiamond = new Card(Rank.SIX, Suit.DIAMONDS);
    Card sevenDiamond = new Card(Rank.SEVEN, Suit.DIAMONDS);
    Card eightDiamond = new Card(Rank.EIGHT, Suit.DIAMONDS);
    Card nineDiamond = new Card(Rank.NINE, Suit.DIAMONDS);
    Card tenDiamond = new Card(Rank.TEN, Suit.DIAMONDS);
    Card jackDiamond = new Card(Rank.JACK, Suit.DIAMONDS);
    Card queenDiamond = new Card(Rank.QUEEN, Suit.DIAMONDS);
    Card kingDiamond = new Card(Rank.KING, Suit.DIAMONDS);
    Card aceDiamond = new Card(Rank.ACE, Suit.DIAMONDS);
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
        HandRank actualResult = he.straight();
        HandRank expectedResult = new HandRank(4,8);
        assertEquals(actualResult, expectedResult);
    }

    @Test
    public void straight_notStraight_returnsFalse() {
        ArrayList<Card> handCards = new ArrayList<>(Arrays.asList(twoClub, threeClub));
        ArrayList<Card> communityCards = new ArrayList<>(Arrays.asList(eightClub, fiveClub, sixClub, sevenClub, eightClub));
        Hand hand = new Hand(handCards);

        he = new HandEvaluator(hand, communityCards);
        HandRank actualResult = he.straight();
        HandRank expectedResult = new HandRank(0,0);
        assertEquals(actualResult, expectedResult);
    }

    @Test
    public void straight_communityCardStraight_returnsTrue() {
        ArrayList<Card> handCards = new ArrayList<>(Arrays.asList(tenClub, tenClub));
        ArrayList<Card> communityCards = new ArrayList<>(Arrays.asList(fourClub, fiveClub, sixClub, sevenClub, eightClub));
        Hand hand = new Hand(handCards);

        he = new HandEvaluator(hand, communityCards);
        HandRank actualResult = he.straight();
        HandRank expectedResult = new HandRank(4,8);
        assertEquals(actualResult, expectedResult);
    }

    @Test
    public void straight_handAndCommunityCardStraight_returnsTrue() {
        ArrayList<Card> handCards = new ArrayList<>(Arrays.asList(nineClub, tenClub));
        ArrayList<Card> communityCards = new ArrayList<>(Arrays.asList(fourClub, fourClub, sixClub, sevenClub, eightClub));
        Hand hand = new Hand(handCards);

        he = new HandEvaluator(hand, communityCards);
        HandRank actualResult = he.straight();
        HandRank expectedResult = new HandRank(4,10);
        assertEquals(actualResult, expectedResult);
    }

    @Test
    public void flush_isFlush_returnsTrue() {
        ArrayList<Card> handCards = new ArrayList<>(Arrays.asList(twoClub, threeClub));
        ArrayList<Card> communityCards = new ArrayList<>(Arrays.asList(fourClub, fiveClub, sixClub, sevenClub, eightClub));
        Hand hand = new Hand(handCards);

        he = new HandEvaluator(hand, communityCards);
        HandRank actualResult = he.flush();
        HandRank expectedResult = new HandRank(5,8);
        assertEquals(actualResult, expectedResult);
    }

    @Test
    public void flush_notFlush_returnsFalse() {
        ArrayList<Card> handCards = new ArrayList<>(Arrays.asList(twoDiamond, threeClub));
        ArrayList<Card> communityCards = new ArrayList<>(Arrays.asList(eightDiamond, fiveDiamond, sixClub, sevenClub, eightClub));
        Hand hand = new Hand(handCards);

        he = new HandEvaluator(hand, communityCards);
        HandRank actualResult = he.flush();
        HandRank expectedResult = new HandRank(0,0);
        assertEquals(actualResult, expectedResult);
    }

    @Test
    public void flush_communityCardFlush_returnsTrue() {
        ArrayList<Card> handCards = new ArrayList<>(Arrays.asList(tenClub, tenClub));
        ArrayList<Card> communityCards = new ArrayList<>(Arrays.asList(fourDiamond, fiveDiamond, sixDiamond, sevenDiamond, eightDiamond));
        Hand hand = new Hand(handCards);

        he = new HandEvaluator(hand, communityCards);
        HandRank actualResult = he.flush();
        HandRank expectedResult = new HandRank(5,8);
        assertEquals(actualResult, expectedResult);
    }

    @Test
    public void flush_handAndCommunityCardFlush_returnsTrue() {
        ArrayList<Card> handCards = new ArrayList<>(Arrays.asList(nineDiamond, tenClub));
        ArrayList<Card> communityCards = new ArrayList<>(Arrays.asList(fourDiamond, fourDiamond, sixDiamond, sevenDiamond, eightClub));
        Hand hand = new Hand(handCards);

        he = new HandEvaluator(hand, communityCards);
        HandRank actualResult = he.flush();
        HandRank expectedResult = new HandRank(5,9);
        assertEquals(actualResult, expectedResult);
    }

    @Test
    public void pair_handAndCommunityCardSinglePair_returnsTrue() {
        ArrayList<Card> handCards = new ArrayList<>(Arrays.asList(nineDiamond, tenClub));
        ArrayList<Card> communityCards = new ArrayList<>(Arrays.asList(fourDiamond, fiveDiamond, sixDiamond, sevenDiamond, nineDiamond));
        Hand hand = new Hand(handCards);

        he = new HandEvaluator(hand, communityCards);
        HandRank actualResult = he.pairs();
        HandRank expectedResult = new HandRank(2,9);
        assertEquals(actualResult, expectedResult);
    }

    @Test
    public void pair_noPair_returnsFalse() {
        ArrayList<Card> handCards = new ArrayList<>(Arrays.asList(eightDiamond, tenClub));
        ArrayList<Card> communityCards = new ArrayList<>(Arrays.asList(fourDiamond, fiveDiamond, sixDiamond, sevenDiamond, nineDiamond));
        Hand hand = new Hand(handCards);

        he = new HandEvaluator(hand, communityCards);
        HandRank actualResult = he.pairs();
        HandRank expectedResult = new HandRank(0,0);
        assertEquals(actualResult, expectedResult);
    }

    @Test
    public void pair_handSinglePair_returnsTrue() {
        ArrayList<Card> handCards = new ArrayList<>(Arrays.asList(eightDiamond, eightClub));
        ArrayList<Card> communityCards = new ArrayList<>(Arrays.asList(fourDiamond, fiveDiamond, sixDiamond, sevenDiamond, nineDiamond));
        Hand hand = new Hand(handCards);

        he = new HandEvaluator(hand, communityCards);
        HandRank actualResult = he.pairs();
        HandRank expectedResult = new HandRank(2,8);
        assertEquals(actualResult, expectedResult);
    }

    @Test
    public void pair_handAndCommunityCardTwoPair_returnsTrue() {
        ArrayList<Card> handCards = new ArrayList<>(Arrays.asList(nineDiamond, tenClub));
        ArrayList<Card> communityCards = new ArrayList<>(Arrays.asList(fourDiamond, fourDiamond, sixDiamond, sevenDiamond, nineDiamond));
        Hand hand = new Hand(handCards);

        he = new HandEvaluator(hand, communityCards);
        HandRank actualResult = he.pairs();
        HandRank expectedResult = new HandRank(3,9);
        assertEquals(actualResult, expectedResult);
    }

    @Test
    public void pair_handAndCommunityCardThreePair_returnsTrue() {
        ArrayList<Card> handCards = new ArrayList<>(Arrays.asList(nineDiamond, tenClub));
        ArrayList<Card> communityCards = new ArrayList<>(Arrays.asList(fourDiamond, fourDiamond, sixDiamond, tenClub, nineDiamond));
        Hand hand = new Hand(handCards);

        he = new HandEvaluator(hand, communityCards);
        HandRank actualResult = he.pairs();
        HandRank expectedResult = new HandRank(3,10);
        assertEquals(actualResult, expectedResult);
    }

    @Test
    public void highCard_highHand_returnsTrue() {
        ArrayList<Card> handCards = new ArrayList<>(Arrays.asList(nineDiamond, tenClub));
        ArrayList<Card> communityCards = new ArrayList<>(Arrays.asList(fourDiamond, fourDiamond, sixDiamond, nineClub, nineDiamond));
        Hand hand = new Hand(handCards);

        he = new HandEvaluator(hand, communityCards);
        HandRank actualResult = he.highCard();
        HandRank expectedResult = new HandRank(1,10);
        assertEquals(actualResult, expectedResult);
    }

    @Test
    public void highCard_highCommunity_returnsTrue() {
        ArrayList<Card> handCards = new ArrayList<>(Arrays.asList(nineDiamond, tenClub));
        ArrayList<Card> communityCards = new ArrayList<>(Arrays.asList(fourDiamond, fourDiamond, sixDiamond, jackClub, nineDiamond));
        Hand hand = new Hand(handCards);

        he = new HandEvaluator(hand, communityCards);
        HandRank actualResult = he.highCard();
        HandRank expectedResult = new HandRank(1,11);
        assertEquals(actualResult, expectedResult);
    }

    @Test
    public void highCard_allSameCard_returnsTrue() {
        ArrayList<Card> handCards = new ArrayList<>(Arrays.asList(nineDiamond, nineDiamond));
        ArrayList<Card> communityCards = new ArrayList<>(Arrays.asList(nineDiamond, nineDiamond, nineDiamond, nineDiamond, nineDiamond));
        Hand hand = new Hand(handCards);

        he = new HandEvaluator(hand, communityCards);
        HandRank actualResult = he.highCard();
        HandRank expectedResult = new HandRank(1,9);
        assertEquals(actualResult, expectedResult);
    }

    @Test
    public void ofAKind_notThreeOfAKind_returnsFalse() {
        ArrayList<Card> handCards = new ArrayList<>(Arrays.asList(twoDiamond, threeDiamond));
        ArrayList<Card> communityCards = new ArrayList<>(Arrays.asList(fourDiamond, fiveDiamond, sevenDiamond, sixDiamond, eightDiamond));
        Hand hand = new Hand(handCards);

        he = new HandEvaluator(hand, communityCards);
        HandRank actualResult = he.ofAKind();
        HandRank expectedResult = new HandRank(0,0);
        assertEquals(actualResult, expectedResult);
    }

    @Test
    public void ofAKind_threeOfAKind_returnsTrue() {
        ArrayList<Card> handCards = new ArrayList<>(Arrays.asList(twoDiamond, twoDiamond));
        ArrayList<Card> communityCards = new ArrayList<>(Arrays.asList(twoDiamond, threeDiamond, fourDiamond, sixDiamond, eightDiamond));
        Hand hand = new Hand(handCards);

        he = new HandEvaluator(hand, communityCards);
        HandRank actualResult = he.ofAKind();
        HandRank expectedResult = new HandRank(4,2);
        assertEquals(actualResult, expectedResult);
    }

    @Test
    public void ofAKind_allOfAKind_returnsTrue() {
        ArrayList<Card> handCards = new ArrayList<>(Arrays.asList(twoDiamond, twoDiamond));
        ArrayList<Card> communityCards = new ArrayList<>(Arrays.asList(twoDiamond, twoDiamond, twoDiamond, twoDiamond, twoDiamond));
        Hand hand = new Hand(handCards);

        he = new HandEvaluator(hand, communityCards);
        HandRank actualResult = he.ofAKind();
        HandRank expectedResult = new HandRank(8,2);
        assertEquals(actualResult, expectedResult);
    }

    @Test
    public void fullHouse_jacksFullOfKings_returnsTrue() {
        ArrayList<Card> handCards = new ArrayList<>(Arrays.asList(jackClub, jackClub));
        ArrayList<Card> communityCards = new ArrayList<>(Arrays.asList(kingClub, kingClub, kingClub, threeDiamond, twoDiamond));
        Hand hand = new Hand(handCards);

        he = new HandEvaluator(hand, communityCards);
        HandRank actualResult = he.fullHouse();
        HandRank expectedResult = new HandRank(7,13);
        assertEquals(actualResult, expectedResult);
    }

    @Test
    public void fullHouse_noFullHouse_returnsFalse() {
        ArrayList<Card> handCards = new ArrayList<>(Arrays.asList(queenClub, jackClub));
        ArrayList<Card> communityCards = new ArrayList<>(Arrays.asList(aceClub, kingClub, tenClub, threeDiamond, twoDiamond));
        Hand hand = new Hand(handCards);

        he = new HandEvaluator(hand, communityCards);
        HandRank actualResult = he.fullHouse();
        HandRank expectedResult = new HandRank(0,0);
        assertEquals(actualResult, expectedResult);
    }

    @Test
    public void straightFlush_actualStraight_returnsTrue() {
        ArrayList<Card> handCards = new ArrayList<>(Arrays.asList(aceClub, jackClub));
        ArrayList<Card> communityCards = new ArrayList<>(Arrays.asList(queenClub, kingClub, tenClub, threeDiamond, twoDiamond));
        Hand hand = new Hand(handCards);

        he = new HandEvaluator(hand, communityCards);
        HandRank actualResult = he.straightFlush();
        HandRank expectedResult = new HandRank(9,14);
        assertEquals(actualResult, expectedResult);
    }

    @Test
    public void straightFlush_flushNotStraight_returnsFalse() {
        ArrayList<Card> handCards = new ArrayList<>(Arrays.asList(tenClub, jackClub));
        ArrayList<Card> communityCards = new ArrayList<>(Arrays.asList(queenClub, kingClub, tenClub, threeDiamond, twoDiamond));
        Hand hand = new Hand(handCards);

        he = new HandEvaluator(hand, communityCards);
        HandRank actualResult = he.straightFlush();
        HandRank expectedResult = new HandRank(0,0);
        assertEquals(actualResult, expectedResult);
    }

    @Test
    public void straightFlush_notFlushStraight_returnsFalse() {
        ArrayList<Card> handCards = new ArrayList<>(Arrays.asList(aceDiamond, jackClub));
        ArrayList<Card> communityCards = new ArrayList<>(Arrays.asList(queenClub, kingClub, tenClub, threeDiamond, twoDiamond));
        Hand hand = new Hand(handCards);

        he = new HandEvaluator(hand, communityCards);
        HandRank actualResult = he.straightFlush();
        HandRank expectedResult = new HandRank(0,0);
        assertEquals(actualResult, expectedResult);
    }
}
