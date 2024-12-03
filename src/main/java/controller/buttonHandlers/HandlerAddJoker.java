package controller.buttonHandlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Player;
import model.jokers.Joker;

public class HandlerAddJoker implements EventHandler<ActionEvent> {
    private VBox jokerView;
    private VBox playerJokers;
    private VBox shopContainer;
    private Player player;
    private Joker joker;

    public HandlerAddJoker(VBox jokerView, VBox playerJokers, VBox shopContainer, Player player, Joker joker) {
        this.jokerView = jokerView;
        this.playerJokers = playerJokers;
        this.shopContainer = shopContainer;
        this.player = player;
        this.joker = joker;
    }

    public void handle(ActionEvent event) {
        this.player.addJoker(this.joker);

        Button button = (Button) this.jokerView.getChildren().get(1);
        Label description = (Label) this.jokerView.getChildren().removeLast();
        button.setOnAction(new HandlerRemoveJoker(this.jokerView, this.playerJokers, this.shopContainer, this.player, this.joker, description));

        HBox jokersContainer = (HBox) this.playerJokers.getChildren().getFirst();
        jokersContainer.getChildren().add(this.jokerView);
        this.shopContainer.getChildren().remove(this.jokerView);
        Label jokerCount = (Label) this.playerJokers.getChildren().getLast();
        jokerCount.setText(this.player.getJokers().size() + "/5");
    }
}
