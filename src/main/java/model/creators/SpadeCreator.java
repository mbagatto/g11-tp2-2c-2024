package model.creators;

import model.cards.Card;
import model.cards.Spade;

public class SpadeCreator implements CreatorCard {

    private CreatorCard nextCreator;
    private final String suit = "Picas";
    public SpadeCreator(){
        this.nextCreator = null;
    }

    public Card createCard(String suit, String name, String number, int value, int multiplier) {
        Card card = null;
        if(suit.equals(this.suit)){
            card = new Spade(name,number,value,multiplier);
        }else{
            card = this.nextCreator.createCard(suit,name,number,value,multiplier);
        }
        return card;
    }

}
