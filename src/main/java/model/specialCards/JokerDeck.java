package model.specialCards;
import model.Deck;
import model.score.Score;

import java.util.ArrayList;

public class JokerDeck extends Deck {

    public JokerDeck() {
        this.cards = new ArrayList<>();
    }
    @Override
    public void fillDeck() {
        //Aca se crearian todos los comodines
        this.cards.add(new Joker(new Score(0)));
    }
}
