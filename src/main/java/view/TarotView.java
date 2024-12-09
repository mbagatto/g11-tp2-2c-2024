package view;

import controller.buttonHandlers.HandlerUseTarot;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import model.Drawable;
import model.Player;
import model.tarots.Tarot;
import view.buttons.ButtonSpecialCard;
import view.records.TarotDTO;

public class TarotView extends VBox implements Drawable {
    private Player player;
    private Tarot tarot;
    private ImageView imageView;
    private VBox popup;
    private Pane pane;

    public TarotView(Tarot tarot, Player player) {
        super();
        this.player = player;
        this.tarot = tarot;
        this.setId("tarot-view");
        this.setAlignment(Pos.CENTER);

        this.draw();
    }

    @Override
    public void draw() {
        TarotDTO tarotDTO = this.tarot.toDTO();

        Pane pane = new Pane();

        Image image = new Image("file:src/resources/textures/specialCards/" + tarotDTO.name() + ".png");
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(115);
        imageView.setFitWidth(90);

        VBox overlay = new VBox(5);
        overlay.setId("tarot-popup");
        overlay.setAlignment(Pos.CENTER);
        overlay.setMinWidth(205);
        overlay.setMaxWidth(205);
        overlay.setMinHeight(125);
        overlay.setMaxHeight(125);
        Label name = new Label(tarotDTO.name());
        name.setId("tarot-popup-name");
        Label description = new Label(tarotDTO.description());
        description.setId("tarot-popup-description");
        description.setWrapText(true);
        description.setAlignment(Pos.CENTER);
        description.setTextAlignment(TextAlignment.CENTER);
        description.setMinWidth(195);
        description.setMaxWidth(195);
        description.setMinHeight(50);
        description.setMaxHeight(50);
        Label type = new Label("Tarot");
        type.setId("tarot-popup-type");
        type.setPrefWidth(80);
        type.setAlignment(Pos.CENTER);
        overlay.setVisible(false);
        overlay.getChildren().addAll(name, description, type);

        pane.getChildren().addAll(imageView, overlay);

        this.pane = pane;
        this.imageView = imageView;
        this.popup = overlay;

        this.getChildren().add(pane);
    }

    public void addButton(Button button, EventHandler<ActionEvent> handler) {
        button.setOnAction(handler);
        button.setGraphic(this.imageView);
        button.setOnMouseEntered(e -> {
            this.popup.setVisible(true);
            this.popup.setTranslateX(-50);
            this.popup.setTranslateY(-125);
        });
        button.setOnMouseExited(e -> this.popup.setVisible(false));
        this.pane.getChildren().add(button);
    }

    public void setUseButton() {
        this.pane.getChildren().removeLast();
        this.addButton(new ButtonSpecialCard(), new HandlerUseTarot(this.player, this.tarot));
    }
}
