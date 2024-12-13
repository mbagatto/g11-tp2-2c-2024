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
import model.tarots.Tarot;
import view.dtos.TarotDTO;

public class TarotView extends VBox implements Drawable {
    private Tarot tarot;
    private Player player;
    private Shop shop;
    private ImageView tarotImageView;
    private TarotManagmentOverlay managmentOverlay;
    private boolean alreadyClicked = false;

    public TarotView(Tarot tarot, Player player, Shop shop) {
        super();
        this.player = player;
        this.tarot = tarot;
        this.shop = shop;
        this.setId("tarot-view");
        this.setAlignment(Pos.CENTER);

        this.draw();
    }

    @Override
    public void draw() {
        TarotDTO tarotDTO = this.tarot.toDTO();

        Pane pane = new Pane();

        Image image = new Image("file:src/resources/textures/specialCards/" + tarotDTO.name() + ".png");
        this.tarotImageView = new ImageView(image);
        this.tarotImageView.setFitHeight(115);
        this.tarotImageView.setFitWidth(90);
        this.tarotImageView.setCursor(Cursor.HAND);

        TarotInfoOverlay infoOverlay = new TarotInfoOverlay(tarotDTO);
        pane.setOnMouseEntered(e -> {
            infoOverlay.setTranslateX(-60);
            infoOverlay.setTranslateY(-130);
            infoOverlay.setVisible(true);
        });
        pane.setOnMouseExited(e -> {
            infoOverlay.setVisible(false);
        });

        this.managmentOverlay = new TarotManagmentOverlay(this.tarot, this.player, this.shop);
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
        pane.getChildren().add(this.tarotImageView);

        this.getChildren().add(pane);
    }

    public void setAddButton() {
        this.managmentOverlay.setAddButton();
    }

    public void setDiscardAndUseButton() {
        this.managmentOverlay.setDiscardAndUseButton();
    }

    public void setUseButtonEnabled() {
        this.managmentOverlay.setUseButtonEnabled();
    }
}
