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
            this.players.add(new Player(i));
        }
        this.deck = new Deck(52, this);
    }

    public void playGame() {
        Collections.shuffle(deck.getDeck());
        deck.deal(players);
        for (int i = 0; i < players.size(); i++) {
            System.out.println(i + players.get(i).getHand().toString());
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
        System.out.println(communityCards);
        for (int i = 0; i < players.size(); i++) {
            HandEvaluator eval = new HandEvaluator(players.get(i).getHand(), communityCards);
            ArrayList<HandRank> handRanks = new ArrayList<>();
            handRanks.add(eval.highCard());
            handRanks.add(eval.pairs());
            handRanks.add(eval.ofAKind());
            handRanks.add(eval.fullHouse());
            handRanks.add(eval.straight());
            handRanks.add(eval.flush());
            handRanks.add(eval.straightFlush());
            players.get(i).setHandRank(handRanks);
        }

        for (Player play : players) {
            System.out.println(play.getHandRank());
        }

        Player winningPlayer = players.get(0);
        for (Player playboy : players) {
            if (Collections.max(playboy.getHandRank()).compareTo(Collections.max(winningPlayer.getHandRank())) > 0) {
                winningPlayer = playboy;
            }
        }

        System.out.println(winningPlayer.toString());

    }

    public void deal(int burn, int comms) {
        deck.getCardFromDeck(burn);
        ArrayList<Card> flop = deck.getCardFromDeck(comms);
        for (Card c : flop) {
            communityCards.add(c);
        }
    }

    public void reset() {
        this.deck = new Deck(52, this);
        this.communityCards = new ArrayList<>();
        this.players = new ArrayList<>();
    }
}
