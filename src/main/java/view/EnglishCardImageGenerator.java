package view;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class EnglishCardImageGenerator {
    private HashMap<String,HashMap<String, ImageView>> imageCards;
    private final List<String> suitsCards = new ArrayList<>(Arrays.asList("Hearts", "Clubs", "Diamonds", "Spades"));
    private final List<String> numbersCards = new ArrayList<>(Arrays.asList("2", "3", "4", "5", "6", "7", "8", "9", "10", "Jota", "Reina", "Rey", "As"));

    public EnglishCardImageGenerator() {
        this.imageCards = new HashMap<>();
        this.generateImageCard();
    }

    public ImageView searchImageCard(String suit, String cardNumber) {
        return this.imageCards.get(suit).get(cardNumber);
    }

    public void generateImageCard(){

        Image deckImage = new Image("file:src/resources/textures/Deck.png");

        int CARD_ROWS = 4;
        int CARD_COLS = 13;

        double cardWidth = deckImage.getWidth() / CARD_COLS;
        double cardHeight = deckImage.getHeight() / CARD_ROWS;

        for (int row = 0; row < CARD_ROWS; row++) {
            HashMap<String,ImageView> mapNumberCards = new HashMap<>();
            for (int col = 0; col < CARD_COLS; col++) {

                ImageView cardView = new ImageView(deckImage);
                cardView.setViewport(new Rectangle2D(
                        col * cardWidth,
                        row * cardHeight,
                        cardWidth,
                        cardHeight
                ));
                cardView.setFitHeight(115);
                cardView.setFitWidth(90);

                mapNumberCards.put(this.numbersCards.get(col), cardView);
            }
            this.imageCards.put(this.suitsCards.get(row),mapNumberCards);
        }
    }
}

