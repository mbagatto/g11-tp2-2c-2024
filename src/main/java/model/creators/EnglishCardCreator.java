package model.creators;

import model.cards.*;

public class EnglishCardCreator {

    private CreatorCard firstCreator;

    public EnglishCardCreator() {
        this.firstCreator = new ClubCreator();
    }

    public Card createEnglishCard(String suit, String name, String number, int value, int multiplier){
        return this.firstCreator.createCard(suit, name, number, value, multiplier);
    }

    public Card createHearCard(String name, String number, int value, int multiplier) {
        return new Heart(name,number,value,multiplier);
    }
    public Card createClubCard(String name, String number, int value, int multiplier) {
        return new Club(name,number,value,multiplier);
    }
    public Card createDiamondCard(String name, String number, int value, int multiplier) {
        return new Diamond(name,number,value,multiplier);
    }
    public Card createSpadeCard(String name, String number, int value, int multiplier) {
        return new Spade(name,number,value,multiplier);
    }


}
