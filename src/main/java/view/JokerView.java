package view;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import model.Drawable;
import model.Player;
import model.jokers.Joker;
import view.records.JokerDTO;

public class JokerView extends VBox implements Drawable {
    private Player player;
    private Joker joker;
    private ImageView imageView;
    private Tooltip popUp;

    public JokerView(Joker joker, Player player) {
        super();
        this.player = player;
        this.joker = joker;
        this.setId("joker-view");
        this.setAlignment(Pos.CENTER);

        this.draw();
    }

    @Override
    public void draw() {
        JokerDTO jokerDTO = this.joker.toDTO();

        Label name = new Label(jokerDTO.name());
        name.setId("joker-name");
        Image image = new Image("file:src/resources/textures/specialCards/" + jokerDTO.name() + ".png");
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(110);
        imageView.setFitWidth(85);
        this.imageView = imageView;

        Tooltip popUp = new Tooltip(jokerDTO.description());
        popUp.setId("joker-popup");
        popUp.setShowDelay(Duration.ZERO);
        popUp.setOnShowing(event -> {
            Tooltip tooltip = (Tooltip) event.getSource();
            Bounds bounds = imageView.localToScreen(imageView.getBoundsInLocal());

            Platform.runLater(() -> {
                tooltip.setX(bounds.getCenterX() - imageView.getFitWidth());
                tooltip.setY(bounds.getMinY() + 80);
            });
        });
        this.popUp = popUp;

        this.getChildren().add(name);
    }

    public void addButton(Button button, EventHandler<ActionEvent> handler) {
        button.setOnAction(handler);
        button.setGraphic(this.imageView);
        button.setTooltip(this.popUp);
        this.getChildren().add(button);
    }
}
