package model.creators;

import model.cards.Card;
import model.cards.Heart;
import model.score.Score;

public class HeartCreator implements CreatorCard {

    private CreatorCard nextCreator;
    private final String suit = "Corazones";
    public HeartCreator(){
        this.nextCreator = new SpadeCreator();
    }

    public Card createCard(String number, Score points, Score multiplier) {
        Card card = null;
        if (suit.equals(this.suit)) {
            card = new Heart(number, points, multiplier);
        } else {
            card = this.nextCreator.createCard(number, points, multiplier);
        }
        return card;
    }
}
