import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Deck {
    private ArrayList<Card> cards;
    private static List<String> suits = new ArrayList<>(Arrays.asList("heart", "diamond", "spade", "club"));
    private static List<Integer> values = new ArrayList<>(Arrays.asList(
            2,
            3,
            4,
            5,
            6,
            7,
            8,
            9,
            10,
            10,
            10,
            10,
            11
    ));

    public Deck() {
        this.cards = new ArrayList<>();
        for (String suit : suits) {
            for (int value : values) {
                this.cards.add(new Card(value, suit));
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
