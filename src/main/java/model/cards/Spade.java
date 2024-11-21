package model.cards;

public class Spade extends Card {

    public Spade(int value) {
        super(value);
        this.suit = "Spade";
    }

    public Spade(String name,String number, int value,int multiplier) {
        super(name,number,value,multiplier);
        this.suit = "Spade";
    }

}
