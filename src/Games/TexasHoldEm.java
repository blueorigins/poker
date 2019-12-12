package Games;

import java.util.ArrayList;
import java.util.Collections;

public class TexasHoldEm extends Game {
    private int playerCount;
    private ArrayList<Player> players = new ArrayList<>();
    private Deck deck;
    private ArrayList<Card> communityCards = new ArrayList<>();

    public TexasHoldEm(int playerCount) {
        this.playerCount = playerCount;
        for (int i = 0; i < playerCount; i++) {
            this.players.add(new Player());
        }
        this.deck = new Deck(52, this);
    }

    public void playGame() {
        Collections.shuffle(deck.getDeck());
        deck.deal(players);
        for (Player player : players) {
            System.out.println(player.getHand());
        }
        //bet
        //flop
        deal(2, 3);
        //bet
        //turn
        deal(1,1);
        //bet
        //river
        deal(1,1);
        HandEvaluator h = new HandEvaluator(players.get(0).getHand(), communityCards);
        if (h.straight()) {
            System.out.println("Straight");
        }
    }

    public void deal(int burn, int comms) {
        deck.getCardFromDeck(burn);
        ArrayList<Card> flop = deck.getCardFromDeck(comms);
        for (Card c : flop) {
            communityCards.add(c);
        }
        System.out.println(communityCards);
    }

    public void reset() {
        this.deck = new Deck(52, this);
        this.communityCards = new ArrayList<>();
        this.players = new ArrayList<>();
    }
}
