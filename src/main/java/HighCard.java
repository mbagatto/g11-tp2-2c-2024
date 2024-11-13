import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class HighCard implements HandPattern {
    public Hand verifyPattern(ArrayList<Card> cards) {
        ArrayList<Card> cardsCopy = new ArrayList<>(cards);
        cardsCopy.sort(Comparator.comparingInt(Card::getValue));
        Card maxCard = cardsCopy.getLast();
        cardsCopy = new ArrayList<>(Arrays.asList(maxCard));
        return new Hand(5, 1, cardsCopy);
    }

//    private Hand findCards(ArrayList<Card> cards){
//        Hand hand = new Hand(5, 1);
//        cards.sort(Comparator.comparingInt(Card::getValue));
//        hand.addCard(cards.getLast());
//
//        return hand;
//    }
}
