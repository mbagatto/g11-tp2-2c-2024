package view;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
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
        this.setLayoutY(750);
        this.setSpacing(1);
        this.setAlignment(Pos.CENTER_RIGHT);
        EnglishDeckDTO englishDeckDTO = englishDeck.toDTO();

        Image englishDeckImage = new Image("file:src/resources/textures/english-deck.png");
        ImageView englishDeckImageView = new ImageView(englishDeckImage);
        englishDeckImageView.setFitHeight(200);
        englishDeckImageView.setFitWidth(150);

        Label cardsCount = new Label(englishDeckDTO.cardsCount() + "/52");
        cardsCount.setStyle("-fx-font-size: 20px;" + "-fx-text-fill: white;");

        this.getChildren().add(englishDeckImageView);
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
