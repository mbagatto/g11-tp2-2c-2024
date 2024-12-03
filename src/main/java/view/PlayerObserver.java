package view;

import model.ObservablePlayer;
import model.ObserverPlayer;
import model.Player;
import model.cards.Card;

import java.util.List;


public class PlayerObserver implements ObservablePlayer {

    private Player player;

    public PlayerObserver(Player player) {
        this.player = player;
    }

    @Override
    public void addObserverPlayer(ObserverPlayer observerPlayer) {
        this.player.addObserverPlayer(observerPlayer);
    }

    @Override
    public void notifyObserversPlayer() {
        this.player.notifyObserversPlayer();
    }

    public void selectCards(List<Integer> indexsCards) {
        for (Integer index : indexsCards) {
            this.player.selectCard(index);
        }
    }

    public Player getplayer() {
        return player;
    }
}
