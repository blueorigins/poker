package test;

import Games.*;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TexasHoldEmTest {
    Card two = new Card(Rank.TWO, Suit.CLUBS);
    Card three = new Card(Rank.THREE, Suit.CLUBS);
    Card four = new Card(Rank.FOUR, Suit.CLUBS);
    Card five = new Card(Rank.FIVE, Suit.CLUBS);
    Card six = new Card(Rank.SIX, Suit.CLUBS);
    ArrayList<Card> cards = new ArrayList<>();
    ArrayList<Card> hands = new ArrayList<>();
    Hand hand;
    HandEvaluator he;

    @BeforeEach
    public void setup() {
        hands.add(two);
        hands.add(three);
        cards.add(four);
        cards.add(five);
        cards.add(six);
        he = new HandEvaluator(hand, cards);
    }

    @Test
    public void test1() {
        boolean result = he.straight();
        assertTrue(result);
    }
}