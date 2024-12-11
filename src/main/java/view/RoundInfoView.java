package view;

import javafx.scene.Group;
import javafx.scene.layout.VBox;
import model.RoundObserver;
import model.decks.PlayerDeck;
import model.game.Round;
import view.records.RoundDTO;

public class RoundInfoView extends VBox implements RoundObserver {
    private Group stage;
    private PlayerDeck playerDeck;

    public RoundInfoView(Group stage, Round round, PlayerDeck playerDeck) {
        super();
        this.stage = stage;
        round.addObserver(this);
        RoundDTO roundDTO = round.toDTO();
        this.playerDeck = playerDeck;

        this.setId("info-container");
        this.setLayoutX(62);
        this.setLayoutY(350);
        this.setMinWidth(350);
        this.setSpacing(50);

        this.getChildren().add(new ActualScoreView(roundDTO.actualScore()));
        this.getChildren().add(new PointsAndMultView(this.playerDeck));
        this.getChildren().add(new HandsAndDiscardsView(roundDTO.hands(), roundDTO.discards()));
    }

    @Override
    public void update(RoundDTO roundDTO) {
        this.getChildren().clear();

        this.getChildren().add(new ActualScoreView(roundDTO.actualScore()));
        this.getChildren().add(new PointsAndMultView(this.playerDeck));
        this.getChildren().add(new HandsAndDiscardsView(roundDTO.hands(), roundDTO.discards()));

        this.stage.getChildren().remove(this);
        this.stage.getChildren().add(this);
    }
}
