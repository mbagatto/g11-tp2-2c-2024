import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Deck {
    private ArrayList<Card> cards;
    private static List<String> suits = new ArrayList<>(Arrays.asList("heart", "diamond", "spade", "club"));

    public Deck() {
        this.cards = new ArrayList<Card>();
        for (String suit : suits) {
            for (int i = 1; i <= 13; i++) {
                this.cards.add(new Card(i, suit));
            }
        }
    }

    public boolean isReadyToPlay() {
        return (this.cards.size() == 52);
    }
}
