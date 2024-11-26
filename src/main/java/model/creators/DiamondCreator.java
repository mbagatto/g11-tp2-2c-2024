package model.creators;

import model.cards.Card;
import model.cards.Diamond;
import model.score.Score;

public class DiamondCreator implements CreatorCard {

    private CreatorCard nextCreator;
    private final String suit = "Diamantes";
    public DiamondCreator(){
        this.nextCreator = new HeartCreator();
    }

    public Card createCard(String number, Score points, Score multiplier) {
        Card card = null;
        if (suit.equals(this.suit)) {
            card = new Diamond(number, points, multiplier);
        } else {
            card = this.nextCreator.createCard(number, points, multiplier);
        }
        return card;
    }

}
