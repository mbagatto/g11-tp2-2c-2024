package model.cards;

import model.reader.EnglishCardReader;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class EnglishCardCreator {

    public Card createHearCard(String name,String number,int value, int multiplier) {
        return new Heart(name,number,value,multiplier);
    }
    public Card createClubCard(String name,String number,int value, int multiplier) {
        return new Club(name,number,value,multiplier);
    }
    public Card createDiamondCard(String name,String number,int value, int multiplier) {
        return new Diamond(name,number,value,multiplier);
    }
    public Card createSpadeCard(String name,String number,int value, int multiplier) {
        return new Spade(name,number,value,multiplier);
    }

    public Card createHearCard(int value) {
        return new Heart(value);
    }
    public Card createClubCard(int value) {
        return new Club(value);
    }
    public Card createDiamondCard(int value) {
        return new Diamond(value);
    }
    public Card createSpadeCard(int value) {
        return new Spade(value);
    }

}
