import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Straight implements HandPattern {
    @Override
    public Hand verifyPattern(ArrayList<Card> cards) {

        cards.sort(Comparator.comparingInt(Card::getValue));

        for (int i = 1; i < cards.size(); i++) {
            if (cards.get(i).getValue() != cards.get(i - 1).getValue() + 1) {
                return null;
            }
        }
        return this.findCards(cards);
    }

    private Hand findCards(ArrayList<Card> cards){
        Hand hand = new Hand(30, 4);
        for (Card card : cards) {
            hand.addCard(card);
        }
        return hand;
    }

}
