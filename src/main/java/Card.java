public class Card {
    private int value;
    private String suit;

    public Card(int value, String suit) {
        this.value = value;
        this.suit = suit;
    }

    public boolean isSuit(String suit) {
        return (this.suit.equals(suit));
    }
}
