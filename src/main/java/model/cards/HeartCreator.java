package model.cards;

public class HeartCreator implements CreatorCard{

    private CreatorCard nextCreator;
    private final String suit = "Corazones";
    public HeartCreator(){
        this.nextCreator = new SpadeCreator();
    }

    public Card createCard(String suit, String name, String number, int value, int multiplier) {
        Card card = null;
        if(suit.equals(this.suit)){
            card = new Heart(name,number,value,multiplier);
        }else{
            card = this.nextCreator.createCard(suit,name,number,value,multiplier);
        }
        return card;
    }

}
