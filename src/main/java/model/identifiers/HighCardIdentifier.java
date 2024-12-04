package model.identifiers;

import model.hands.Hand;
import model.cards.Card;
import model.hands.HighCard;
import java.util.ArrayList;

public class HighCardIdentifier implements HandIdentifier  {
    private NullCardIdentifier nullCardIdentifier;

    public HighCardIdentifier(HandIdentifier next) {
        //super(next);
        this.nullCardIdentifier = new NullCardIdentifier();
    }

    @Override
    public Hand identify(ArrayList<Card> cards) {
        //System.out.println("antes de NULLINDETIFY");
        if(cards.isEmpty()){
            //System.out.println("antes de NULLINDETIFYY DENTRO DEL IF");
            return this.nullCardIdentifier.identify(cards);
        }else{
            return HighCard.getInstance();
        }

    }
}
