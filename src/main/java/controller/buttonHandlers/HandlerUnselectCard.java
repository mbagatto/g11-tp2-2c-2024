package controller.buttonHandlers;

import controller.SoundPlayer;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import model.Player;
import model.cards.Card;
import view.EnglishCardView;

public class HandlerUnselectCard implements EventHandler<MouseEvent> {
    private Player player;
    private Card card;
    private EnglishCardView englishCardView;
    private SoundPlayer soundPlayer;

    public HandlerUnselectCard(Player player, Card card, EnglishCardView englishCardView) {
        this.player = player;
        this.card = card;
        this.englishCardView = englishCardView;
        this.soundPlayer = SoundPlayer.getInstance();
    }

    public void handle(MouseEvent event) {
        this.soundPlayer.playCardDown();
        this.englishCardView.setTranslateY(this.englishCardView.getLayoutY());
        this.player.unselectCard(this.card);
        this.englishCardView.setOnMouseClicked(new HandlerSelectCard(player, card, englishCardView));
    }
}
