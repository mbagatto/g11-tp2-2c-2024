package controller.buttonHandlers;

import model.Player;
import view.CardPane;

import java.util.List;


public class CardPaneDown implements Movable{

    public void move(CardPane cardPane, HandlerCardPane movable, List<Integer> indexs, Player player) {
        cardPane.setTranslateY(cardPane.getTranslateY() + 50);
        Integer index = cardPane.getIndex() ;
        indexs.remove(index);
        System.out.println(indexs.toString());
        movable.setMove(new CardPaneUp());
    }
}
