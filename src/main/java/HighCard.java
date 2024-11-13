import java.util.ArrayList;
import java.util.Comparator;

public class HighCard implements HandPattern {
    public Hand verifyPattern(ArrayList<Card> cards) {
        return this.findCards(cards);
    }

    private Hand findCards(ArrayList<Card> cards){
        Hand hand = new Hand(5, 1);
        cards.sort(Comparator.comparingInt(Card::getValue));
        hand.addCard(cards.getLast());

        return hand;
    }
}
