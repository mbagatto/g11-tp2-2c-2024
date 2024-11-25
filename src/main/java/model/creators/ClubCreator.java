package model.creators;

import model.cards.Card;
import model.cards.Club;
import model.score.Score;

public class ClubCreator implements CreatorCard {
    private CreatorCard nextCreator;
    private final String suit = "Trebol";
    public ClubCreator(){
        this.nextCreator = new DiamondCreator();
    }

    public Card createCard(String number, Score points, Score multiplier) {
        Card card = null;
        if (suit.equals(this.suit)) {
            card = new Club(number, points, multiplier);
        } else {
            card = this.nextCreator.createCard(number, points, multiplier);
        }
        return card;
    }
}
