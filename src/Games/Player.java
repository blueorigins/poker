package Games;

import java.util.ArrayList;

public class Player {
    private Hand hand;
    private ArrayList<HandRank> handRank;
    private int name;

    public Player(int i) {
        this.name = i;
    }

    public Hand getHand() {
        return hand;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }

    public void setHandRank(ArrayList<HandRank> handRank) {
        this.handRank = handRank;
    }

    public ArrayList<HandRank> getHandRank() {
        return handRank;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name=" + name +
                '}';
    }
}
