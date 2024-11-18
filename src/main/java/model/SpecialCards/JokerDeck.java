package model.SpecialCards;
import model.Deck;

import java.util.ArrayList;

public class JokerDeck extends Deck {

    public JokerDeck() {
        this.cards = new ArrayList<>();
    }
    @Override
    public void fillDeck() {
        //Aca se crearian todos los comodines
        Joker joker = new Joker();
        joker.setBehaviour(new ForMultiplier(10));
        this.cards.add(joker);
    }
}
