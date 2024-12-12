package view;

import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import model.Drawable;
import model.Player;
import model.game.Shop;
import model.jokers.Joker;
import view.dtos.JokerDTO;

public class JokerView extends VBox implements Drawable {
    private Joker joker;
    private Player player;
    private Shop shop;
    private ImageView jokerImageView;
    private JokerManagmentOverlay managmentOverlay;
    private boolean alreadyClicked = false;

    public JokerView(Joker joker, Player player, Shop shop) {
        super();
        this.joker = joker;
        this.player = player;
        this.shop = shop;
        this.setId("joker-view");
        this.setAlignment(Pos.CENTER);

        this.draw();
    }

    @Override
    public void draw() {
        JokerDTO jokerDTO = this.joker.toDTO();

        Pane pane = new Pane();

        Image image = new Image("file:src/resources/textures/specialCards/" + jokerDTO.name() + ".png");
        this.jokerImageView = new ImageView(image);
        this.jokerImageView.setFitHeight(115);
        this.jokerImageView.setFitWidth(90);
        this.jokerImageView.setCursor(Cursor.HAND);

        JokerInfoOverlay infoOverlay = new JokerInfoOverlay(jokerDTO);
        pane.setOnMouseEntered(e -> {
            infoOverlay.setTranslateX(-60);
            infoOverlay.setTranslateY(-130);
            infoOverlay.setVisible(true);
        });
        pane.setOnMouseExited(e -> {
            infoOverlay.setVisible(false);
        });

        this.managmentOverlay = new JokerManagmentOverlay(this.joker, this.player, this.shop);
        pane.setOnMouseClicked(e -> {
            if (!this.alreadyClicked) {
                this.alreadyClicked = true;
                this.managmentOverlay.setTranslateX(8);
                this.managmentOverlay.setTranslateY(112);
                this.managmentOverlay.setVisible(true);
            } else {
                this.alreadyClicked = false;
                this.managmentOverlay.setVisible(false);
            }
        });

        pane.getChildren().add(infoOverlay);
        pane.getChildren().add(this.managmentOverlay);
        pane.getChildren().add(this.jokerImageView);

        this.getChildren().add(pane);
    }

    public void setAddButton() {
        this.managmentOverlay.setAddButton();
    }

    public void setDiscardButton() {
        this.managmentOverlay.setDiscardButton();
    }
}
