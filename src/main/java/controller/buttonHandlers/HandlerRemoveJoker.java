package controller.buttonHandlers;

import controller.SoundPlayer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Player;
import model.jokers.Joker;

public class HandlerRemoveJoker implements EventHandler<ActionEvent> {
    private VBox jokerView;
    private VBox playerJokers;
    private VBox shopContainer;
    private Player player;
    private Joker joker;
    private Label description;
    private SoundPlayer soundPlayer;

    public HandlerRemoveJoker(VBox jokerView, VBox playerJokers, VBox shopContainer, Player player, Joker joker, Label description) {
        this.jokerView = jokerView;
        this.playerJokers = playerJokers;
        this.shopContainer = shopContainer;
        this.player = player;
        this.joker = joker;
        this.description = description;
        this.soundPlayer = new SoundPlayer();
    }

    public void handle(ActionEvent actionEvent) {
        this.soundPlayer.playButtonSound();
        this.player.removeJoker(this.joker);

        Button button = (Button) this.jokerView.getChildren().get(1);
        button.setOnAction(new HandlerAddJoker(this.jokerView, this.playerJokers, this.shopContainer, this.player, this.joker));

        this.jokerView.getChildren().add(this.description);
        this.shopContainer.getChildren().add(this.jokerView);
        HBox jokersContainer = (HBox) this.playerJokers.getChildren().getFirst();
        jokersContainer.getChildren().remove(this.jokerView);
        Label jokerCount = (Label) this.playerJokers.getChildren().getLast();
        jokerCount.setText(this.player.getJokers().size() + "/5");
    }
}
