package controller.buttonHandlers;

import model.Player;
import view.CardPane;

import java.util.List;

public class CardPaneUp implements Movable {

    public void move(CardPane cardPane, HandlerCardPane movable, List<Integer> indexs, Player player) {
        if(indexs.size() < 5){
            cardPane.setTranslateY(cardPane.getTranslateY() - 50);
            indexs.add(cardPane.getIndex());
            //System.out.println(indexs.toString());
            movable.setMove(new CardPaneDown());
            player.notifyPlayerDeck();
        }
    }
}
