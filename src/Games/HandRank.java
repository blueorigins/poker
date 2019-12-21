package Games;

import java.util.Objects;

public class HandRank implements Comparable<HandRank> {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HandRank handRank1 = (HandRank) o;
        return handRank == handRank1.handRank &&
                subHandRank == handRank1.subHandRank;
    }

    @Override
    public int hashCode() {
        return Objects.hash(handRank, subHandRank);
    }

    @Override
    public int compareTo(HandRank other) {
        int result = new Integer(handRank).compareTo(other.handRank);
        if (result == 0) {
            return new Integer(subHandRank).compareTo(other.subHandRank);
        }
        return result;
    }

    @Override
    public String toString() {
        return "HandRank{" +
                "handRank=" + handRank +
                ", subHandRank=" + subHandRank +
                '}';
    }
}
