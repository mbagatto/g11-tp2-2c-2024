import java.util.ArrayList;

public class PlayerDeck {
    private ArrayList<Card> cards;
    private static HandCalculator handCalculator = new HandCalculator();

    public PlayerDeck() {
        this.cards = new ArrayList<>();
    }

    public void addCard(Card card) {
        this.cards.add(card);
    }

    public boolean isComplete() {
        return (this.cards.size() == 8);
    }
}
