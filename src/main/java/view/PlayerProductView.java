package view;

import controller.buttonHandlers.HandlerUseTarot;
import javafx.application.Platform;
import javafx.geometry.Bounds;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import model.Player;
import model.Purchasable;
import view.buttons.ButtonRemove;

public class PlayerProductView extends VBox {
    private Purchasable purchasable;
    private Player player;

    public PlayerProductView(Purchasable purchasable, Player player) {
        super();
        this.purchasable = purchasable;
        this.player = player;
        this.setId("player-product-view");
        this.setAlignment(Pos.CENTER);
        Label name = new Label(purchasable.getName());
        name.setId("purchasable-name");
        Image image = new Image("file:src/resources/textures/specialCards/" + purchasable.getName() + ".png");
        System.out.println(image.getUrl());
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(110);
        imageView.setFitWidth(85);

        Button removeButton = new ButtonRemove(imageView, purchasable.getDescription());
        Tooltip popUp = new Tooltip(purchasable.getDescription());
        popUp.setId("product-popup");
        popUp.setShowDelay(Duration.ZERO);
        removeButton.setTooltip(popUp);
        popUp.setOnShowing(event -> {
            Tooltip tooltip = (Tooltip) event.getSource();
            Bounds bounds = removeButton.localToScreen(removeButton.getBoundsInLocal());

            Platform.runLater(() -> {
                tooltip.setX(bounds.getMinX() + 5);
                tooltip.setY(bounds.getMinY() + 105);
            });
        });

        this.getChildren().add(name);
        this.getChildren().add(removeButton);
    }

    public void disableButton() {
        ((Button) this.getChildren().getLast()).setOnAction(null);
        this.getChildren().getLast().setStyle("-fx-cursor: default;");
    }

    public void changeButton(HBox tarotsContainer) {
        ((Button) this.getChildren().getLast()).setOnAction(new HandlerUseTarot(this.purchasable, this.player, tarotsContainer, this));
    }
}
