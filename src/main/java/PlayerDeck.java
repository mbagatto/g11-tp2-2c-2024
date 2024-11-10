import java.util.ArrayList;

public class PlayerDeck {
    private ArrayList<Card> cards;

    public PlayerDeck() {
        this.cards = new ArrayList<Card>();
    }

    public void addCard(Card card) {
        this.cards.add(card);
    }

    public boolean isComplete() {
        return (this.cards.size() == 8);
    }
}
