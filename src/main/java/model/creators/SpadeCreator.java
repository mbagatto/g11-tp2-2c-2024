package model.creators;

import model.cards.Card;
import model.cards.Spade;
import model.score.Score;

public class SpadeCreator implements CreatorCard {

    private CreatorCard nextCreator;
    private final String suit = "Picas";
    public SpadeCreator(){
        this.nextCreator = null;
    }

    public Card createCard(String number, Score points, Score multiplier) {
        Card card = null;
        if (suit.equals(this.suit)) {
            card = new Spade(number, points, multiplier);
        } else {
            card = this.nextCreator.createCard(number, points, multiplier);
        }
        return card;
    }

}
