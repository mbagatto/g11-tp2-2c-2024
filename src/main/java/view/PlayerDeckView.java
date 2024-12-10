package view;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import model.Drawable;
import model.Player;
import view.records.EnglishCardDTO;
import view.records.PlayerDTO;

import java.util.ArrayList;

public class PlayerDeckView extends HBox implements Drawable {
    private Player player;
    private EnglishCardImageGenerator cardViewGenerator;

    public PlayerDeckView(Player player) {
        super();
        this.player = player;
        this.cardViewGenerator = new EnglishCardImageGenerator();
        this.draw();
    }

    @Override
    public void draw() {
        ArrayList<EnglishCardDTO> cardsDTOS = this.player.toDTO().playerDeck().cards();
        int superPosition = 0;
        System.out.println(cardsDTOS);
        for(EnglishCardDTO cardDTO : cardsDTOS) {
            ImageView imageCard = this.cardViewGenerator.searchImageCard(cardDTO.suit(),cardDTO.number());
            EnglishCardView englishCardView = new EnglishCardView(imageCard);
            englishCardView.setTranslateX(superPosition);
            this.getChildren().add(englishCardView);
            superPosition = superPosition - 10;
        }
    }
}
