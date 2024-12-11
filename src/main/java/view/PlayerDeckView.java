package view;

import controller.buttonHandlers.HandlerSelectCard;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import model.Drawable;
import model.Player;
import model.cards.Card;
import view.dtos.EnglishCardDTO;

import java.util.ArrayList;

public class PlayerDeckView extends HBox implements Drawable {
    private ArrayList<Card> cards;
    private EnglishCardImageGenerator cardViewGenerator;
    private Player player;

    public PlayerDeckView(ArrayList<Card> cards, Player player) {
        super();
        this.player = player;
        this.cards = cards;
        this.cardViewGenerator = new EnglishCardImageGenerator();
        this.draw();
    }

    @Override
    public void draw() {
        int superPosition = 0;

        for (Card card : cards) {
            EnglishCardDTO cardDTO = card.toDTO();
            ImageView imageCard = this.cardViewGenerator.searchImageCard(cardDTO.suit(), cardDTO.number());
            EnglishCardView englishCardView = new EnglishCardView(imageCard);
            englishCardView.setTranslateX(superPosition);
            englishCardView.setOnMouseClicked(new HandlerSelectCard(this.player, card, englishCardView));
            this.getChildren().add(englishCardView);
            superPosition = superPosition - 10;
        }
    }
}
