package view;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import model.decks.EnglishDeck;

public class TurnedDeckView extends VBox {
    public TurnedDeckView(EnglishDeck deck) {
        super();
        this.setLayoutX(1650);
        this.setLayoutY(850);
        this.setSpacing(1);
        this.setAlignment(Pos.CENTER_RIGHT);

        Image turnedCard = new Image("file:src/resources/textures/turned-card.png");
        ImageView turnedCardView = new ImageView(turnedCard);
        turnedCardView.setFitHeight(110);
        turnedCardView.setFitWidth(85);

        Label cardsCount = new Label(deck.getCards().size() + "/52");
        cardsCount.setStyle("-fx-font-size: 20px;" + "-fx-text-fill: white;");

        this.getChildren().add(turnedCardView);
        this.getChildren().add(cardsCount);
    }
}
