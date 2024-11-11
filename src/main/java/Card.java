public class Card {
    private int value;
    private String suit;

    public Card(int value, String suit) {
        this.value = value;
        this.suit = suit;
    }

    public int getValue() {
        return (this.value);
    }

    public boolean isSuit(String suit) {
        return (this.suit.equals(suit));
    }

    public String getSuit() {
        return (this.suit);
    }

    public boolean hasSameSuitAs(Card card) {
        return (this.suit.equals(card.getSuit()));
    }
}
