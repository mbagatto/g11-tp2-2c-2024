package view;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import model.EnglishDeckObserver;
import model.decks.EnglishDeck;
import view.records.EnglishDeckDTO;

public class EnglishDeckView extends VBox implements EnglishDeckObserver {
    private PreparationView stage;

    public EnglishDeckView(PreparationView stage, EnglishDeck englishDeck) {
        super();
        this.stage = stage;
        englishDeck.addObserver(this);
        this.setLayoutX(1650);
        this.setLayoutY(725);
        this.setSpacing(8);
        this.setAlignment(Pos.CENTER_RIGHT);
        EnglishDeckDTO englishDeckDTO = englishDeck.toDTO();

        StackPane deckView = new StackPane();
        Image cardImage = new Image("file:src/resources/textures/english-deck.png");

        for (int i = 0; i < 5; i++) {
            ImageView cardView = new ImageView(cardImage);
            cardView.setFitWidth(150);
            cardView.setFitHeight(200);
            cardView.setTranslateX(i * 3);
            cardView.setTranslateY(i * 2);

            DropShadow shadow = new DropShadow();
            shadow.setRadius(10);
            shadow.setOffsetX(3);
            shadow.setOffsetY(3);
            shadow.setColor(Color.color(0, 0, 0, 0.5));
            cardView.setEffect(shadow);

            deckView.getChildren().add(cardView);
        }

        Label cardsCount = new Label(englishDeckDTO.cardsCount() + "/52");
        cardsCount.setStyle("-fx-font-size: 20px;" + "-fx-text-fill: white;");

        this.getChildren().add(deckView);
        this.getChildren().add(cardsCount);
    }

    @Override
    public void update(EnglishDeckDTO englishDeckDTO) {
        this.getChildren().removeLast();

        Label cardsCount = new Label(englishDeckDTO.cardsCount() + "/52");
        cardsCount.setStyle("-fx-font-size: 20px;" + "-fx-text-fill: white;");
        this.getChildren().add(cardsCount);

        this.stage.updateView(this);
    }
}
