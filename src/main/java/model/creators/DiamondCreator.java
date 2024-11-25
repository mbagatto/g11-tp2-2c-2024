package model.creators;

import model.cards.Card;
import model.cards.Diamond;

public class DiamondCreator implements CreatorCard {

    private CreatorCard nextCreator;
    private final String suit = "Diamantes";
    public DiamondCreator(){
        this.nextCreator = new HeartCreator();
    }

    public Card createCard(String suit, String name, String number, int value, int multiplier) {
        Card card = null;
        if(suit.equals(this.suit)){
            card = new Diamond(name,number,value,multiplier);
        }else{
            card = this.nextCreator.createCard(suit,name,number,value,multiplier);
        }
        return card;
    }

}
