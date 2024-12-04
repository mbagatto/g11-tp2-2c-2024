package controller.buttonHandlers;

import model.Player;
import view.CardPane;
import view.PlayerObserver;

import java.util.List;


public class CardPaneDown implements Movable{

    public void move(CardPane cardPane, HandlerCardPane movable, List<Integer> indexs, Player player, PlayerObserver playerObserver) {
        cardPane.setTranslateY(cardPane.getTranslateY() + 50);
        Integer index = cardPane.getIndex() ;
        indexs.remove(index);
        System.out.println(indexs.toString());
        playerObserver.clearSelectCards();
        playerObserver.selectCards(indexs);
        movable.setMove(new CardPaneUp());
        player.notifyPlayerDeck();

    }
}
