package controller.buttonHandlers;

import model.Player;
import view.CardPane;
import view.PlayerObserver;

import java.util.List;

public interface Movable {
    void move(CardPane cardPane, HandlerCardPane movable, List<Integer> indexs, Player player, PlayerObserver playerObserver);
}
