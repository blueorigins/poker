package Games;

public class Card implements Comparable<Card> {
    private Rank rank;
    private Suit suit;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public int getRank() {
        return rank.getRank();
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    public String toString() {
        return rank + " of " + suit;
    }

    @Override
    public int compareTo(Card other) {
        return rank.compareTo(other.rank);
    }
}
