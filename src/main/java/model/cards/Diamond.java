package model.cards;

public class Diamond extends Card {

    public Diamond(int value) {
        super(value);
        this.suit = "Diamond";
    }

    public Diamond(String name,String number, int value,int multiplier) {
        super(name,number,value,multiplier);
        this.suit = "Diamond";
    }

}
