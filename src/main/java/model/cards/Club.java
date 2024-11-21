package model.cards;

public class Club extends Card {

    public Club(int value) {
        super(value);
        this.suit = "Club";
    }

    public Club(String name,String number, int value,int multiplier) {
        super(name,number,value,multiplier);
        this.suit = "Club";
    }


}
