import java.util.ArrayList;
import java.util.Comparator;

public class Straight implements HandPattern {
    @Override
    public boolean verifyPattern(ArrayList<Card> cards) {
        cards.sort(Comparator.comparingInt(Card::getValue));
        for (int i = 1; i < cards.size(); i++) {
            if (cards.get(i).getValue() != cards.get(i - 1).getValue() + 1) {
                return false;
            }
        }
        return true;
    }
}
