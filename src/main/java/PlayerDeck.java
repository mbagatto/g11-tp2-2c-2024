import java.util.ArrayList;

public class PlayerDeck {
    private ArrayList<Card> cards;
    private ArrayList<Card> selectedCards;
    private static HandCalculator handCalculator = new HandCalculator();

    public PlayerDeck() {
        this.cards = new ArrayList<Card>();
        this.selectedCards = new ArrayList<Card>();
    }

    public void addCard(Card card) {
        this.cards.add(card);
    }

    public void addSelectedCard(Card card) {
        this.selectedCards.add(card);
    }

    public boolean isComplete() {
        return (this.cards.size() == 8);
    }
}
