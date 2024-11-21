package model.cards;

public class Heart extends Card {

    public Heart(int value) {
        super(value);
        this.suit = "Heart";
    }
    public Heart(String name,String number, int value,int multiplier) {
        super(name,number,value,multiplier);
        this.suit = "Heart";
    }

}
