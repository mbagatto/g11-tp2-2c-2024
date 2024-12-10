package view;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import model.Drawable;
import model.Player;
import view.records.EnglishCardDTO;
import view.records.PlayerDTO;

import java.util.ArrayList;

public class PlayerDeckView extends HBox implements Drawable {
    private ArrayList<EnglishCardDTO> cards;
    private EnglishCardImageGenerator cardViewGenerator;

    public PlayerDeckView(ArrayList<EnglishCardDTO> cards) {
        super();
        this.cards = cards;
        this.cardViewGenerator = new EnglishCardImageGenerator();
        this.draw();
    }

    @Override
    public void draw() {
        int superPosition = 0;
        for(EnglishCardDTO cardDTO : cards) {
            ImageView imageCard = this.cardViewGenerator.searchImageCard(cardDTO.suit(), cardDTO.number());
            EnglishCardView englishCardView = new EnglishCardView(imageCard);
            englishCardView.setTranslateX(superPosition);
            this.getChildren().add(englishCardView);
            superPosition = superPosition - 10;
        }
    }
}
