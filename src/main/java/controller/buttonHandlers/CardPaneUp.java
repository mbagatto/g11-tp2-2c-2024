package controller.buttonHandlers;

import view.CardPane;

import java.util.List;

public class CardPaneUp implements Movable {

    public void move(CardPane cardPane, HandlerCardPane movable, List<Integer> indexs) {
        if(indexs.size() < 5){
            cardPane.setTranslateY(cardPane.getTranslateY() - 50);
            indexs.add(cardPane.getIndex());
            System.out.println(indexs.toString());
            movable.setMove(new CardPaneDown());
        }
    }
}
