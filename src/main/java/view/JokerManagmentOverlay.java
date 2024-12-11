package view;

import controller.buttonHandlers.HandlerAddJoker;
import controller.buttonHandlers.HandlerRemoveJoker;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import model.Player;
import model.game.Shop;
import model.jokers.Joker;

public class JokerManagmentOverlay extends VBox {
    private Joker joker;
    private Player player;
    private Shop shop;

    public JokerManagmentOverlay(Joker joker, Player player, Shop shop) {
        super();
        this.setId("joker-managment-overlay");
        this.setAlignment(Pos.CENTER);
        this.setVisible(false);
        this.joker = joker;
        this.player = player;
        this.shop = shop;
    }

    public void setAddButton() {
        this.getChildren().clear();

        Button addButton = new Button("Añadir");
        addButton.setId("joker-managment-button");
        addButton.setMinWidth(75);
        addButton.setMaxWidth(75);
        addButton.setOnAction(new HandlerAddJoker(player, joker, shop));

        this.getChildren().add(addButton);
    }

    public void setDiscardButton() {
        this.getChildren().clear();

        Button discardButton = new Button("Descartar");
        discardButton.setId("joker-managment-button");
        discardButton.setMinWidth(75);
        discardButton.setMaxWidth(75);
        discardButton.setStyle("-fx-font-size: 16px;");
        discardButton.setOnAction(new HandlerRemoveJoker(player, joker, shop));

        this.getChildren().add(discardButton);
    }
}
