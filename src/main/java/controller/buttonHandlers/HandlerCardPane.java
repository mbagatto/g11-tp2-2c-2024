package controller.buttonHandlers;

import controller.SoundPlayer;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import model.Player;
import view.CardPane;
import view.PlayerObserver;
import java.util.List;

public class HandlerCardPane implements EventHandler<MouseEvent> {
    private Movable move;
    private List<Integer> indexs;
    private PlayerObserver playerObserver;
    private Player player;
    private SoundPlayer soundPlayer;

    public HandlerCardPane(List<Integer> indexs, Player player, PlayerObserver playerObserver) {
        this.move = new CardPaneUp();
        this.indexs = indexs;
        this.player = player;
        this.playerObserver = playerObserver;
        this.soundPlayer = new SoundPlayer();
    }
    public void handle(MouseEvent event){
        this.soundPlayer.playButtonSound();
        CardPane cardPane = (CardPane) event.getSource();
        this.move.move(cardPane,this, this.indexs, this.player, this.playerObserver);
    }

    public void setMove(Movable move){
        this.move = move;
    }

}
