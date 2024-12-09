package view;

import javafx.scene.Group;
import javafx.scene.layout.VBox;
import model.RoundObserver;
import model.game.Round;
import view.records.RoundDTO;

public class RoundInfoView extends VBox implements RoundObserver {
    private Group stage;

    public RoundInfoView(Group stage, Round round) {
        super();
        this.stage = stage;
        round.addObserver(this);
        RoundDTO roundDTO = round.toDTO();

        this.setId("info-container");
        this.setLayoutX(62);
        this.setLayoutY(350);
        this.setMinWidth(350);
        this.setSpacing(50);

        this.getChildren().add(new ActualScoreView(roundDTO.actualScore()));
        this.getChildren().add(new PointsAndMultView());
        this.getChildren().add(new HandsAndDiscardsView(roundDTO.hands(), roundDTO.discards()));
    }

    @Override
    public void update(RoundDTO roundDTO) {
        this.getChildren().removeFirst(); // remuevo ActualScoreView
        this.getChildren().removeLast(); // remuevo HandsAndDiscardsView

        this.getChildren().add(new ActualScoreView(roundDTO.actualScore())); // agrego ActualScoreView actualizado
        this.getChildren().add(new HandsAndDiscardsView(roundDTO.hands(), roundDTO.discards())); // agrego HandsAndDiscardsView actualizado

        this.stage.getChildren().remove(this);
        this.stage.getChildren().add(this);
    }
}
