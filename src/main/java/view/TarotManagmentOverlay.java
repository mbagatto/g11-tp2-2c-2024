package view;

import controller.buttonHandlers.HandlerAddTarot;
import controller.buttonHandlers.HandlerRemoveTarot;
import controller.buttonHandlers.HandlerUseTarot;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import model.Player;
import model.game.Shop;
import model.tarots.Tarot;

public class TarotManagmentOverlay extends VBox {
    private Tarot tarot;
    private Player player;
    private Shop shop;

    public TarotManagmentOverlay(Tarot tarot, Player player, Shop shop) {
        super();
        this.setId("tarot-managment-overlay");
        this.setAlignment(Pos.CENTER);
        this.setVisible(false);
        this.tarot = tarot;
        this.player = player;
        this.shop = shop;
    }

    public void setAddButton() {
        this.getChildren().clear();

        Button addButton = new Button("Añadir");
        addButton.setId("tarot-managment-button");
        addButton.setMinWidth(75);
        addButton.setMaxWidth(75);
        addButton.setOnAction(new HandlerAddTarot(player, tarot, shop));

        this.getChildren().add(addButton);
    }

    public void setDiscardAndUseButton() {
        this.getChildren().clear();

        Button useButton = new Button("Usar");
        useButton.setId("tarot-managment-use-button");
        useButton.setMinWidth(50);
        useButton.setMaxWidth(50);
        useButton.setTranslateX(60);
        useButton.setTranslateY(-100);
        useButton.setOnAction(new HandlerUseTarot(player, tarot));

        Button discardButton = new Button("Descartar");
        discardButton.setId("tarot-managment-button");
        discardButton.setMinWidth(75);
        discardButton.setMaxWidth(75);
        discardButton.setStyle("-fx-font-size: 16px;");
        discardButton.setOnAction(new HandlerRemoveTarot(player, tarot, shop));

        this.getChildren().addAll(discardButton, useButton);
    }
}
