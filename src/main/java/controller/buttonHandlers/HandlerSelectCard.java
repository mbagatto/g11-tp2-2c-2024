package controller.buttonHandlers;

import controller.SoundPlayer;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import model.Player;
import model.cards.Card;
import view.EnglishCardView;

public class HandlerSelectCard implements EventHandler<MouseEvent> {
    private Player player;
    private Card card;
    private EnglishCardView englishCardView;
    private SoundPlayer soundPlayer;

    public HandlerSelectCard(Player player, Card card, EnglishCardView englishCardView) {
        this.player = player;
        this.card = card;
        this.englishCardView = englishCardView;
        this.soundPlayer = SoundPlayer.getInstance();
    }

    public void handle(MouseEvent event) {
        if (! this.player.maxSelectedReached()) {
            this.soundPlayer.playCardUp();
            this.englishCardView.setTranslateY(this.englishCardView.getLayoutY() - 60);
            this.player.selectCard(this.card);
            this.englishCardView.setOnMouseClicked(new HandlerUnselectCard(player, card, englishCardView));
        } else {
            this.soundPlayer.playMaxSelected();
        }
    }
}
