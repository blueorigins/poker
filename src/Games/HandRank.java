package Games;

public class HandRank {
    private int handRank;
    private int subHandRank;

    public HandRank(int handRank, int subHandRank) {
        this.handRank = handRank;
        this.subHandRank = subHandRank;
    }

    public int getHandRank() {
        return handRank;
    }

    public void setHandRank(int handRank) {
        this.handRank = handRank;
    }

    public int getSubHandRank() {
        return subHandRank;
    }

    public void setSubHandRank(int subHandRank) {
        this.subHandRank = subHandRank;
    }
}
