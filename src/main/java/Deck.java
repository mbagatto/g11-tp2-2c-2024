import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Deck {
    private ArrayList<Card> cards;
    private static List<String> suits = new ArrayList<>(Arrays.asList("heart", "diamond", "spade", "club"));

    public Deck() {
        this.cards = new ArrayList<>();
        for (String suit : suits) {
            for (int i = 2; i <= 14; i++) {
                this.cards.add(new Card(i, suit));
            }
        }
    }

    public Card deal() {
        return (this.cards.removeLast());
    }

    public boolean isReadyToPlay() {
        return (this.cards.size() == 52);
    }

    public boolean hasAmount(int amount) {
        return (this.cards.size() == amount);
    }
}
