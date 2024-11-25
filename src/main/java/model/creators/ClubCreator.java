package model.creators;

import model.cards.Card;
import model.cards.Club;

public class ClubCreator implements CreatorCard {
    private CreatorCard nextCreator;
    private final String suit = "Trebol";
    public ClubCreator(){
        this.nextCreator = new DiamondCreator();
    }

    public Card createCard(String suit, String name, String number, int value, int multiplier) {
        Card card = null;
        if(suit.equals(this.suit)){
            card = new Club(name,number,value,multiplier);
        }else{
            card = this.nextCreator.createCard(suit,name,number,value,multiplier);
        }
        return card;
    }

}
