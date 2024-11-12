import java.util.ArrayList;

public class HighCard implements HandPattern {
    public Hand verifyPattern(ArrayList<Card> cards) {
        return (new Hand(5, 1));
    }
}
