package view;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import model.RoundObserver;
import model.game.Round;
import view.dtos.RoundDTO;

public class RoundTitleView extends VBox implements RoundObserver {
    public RoundTitleView(Round round) {
        super();
        this.setId("title-container");
        this.setLayoutX(62);
        this.setLayoutY(80);
        this.setMinWidth(375);
        this.setAlignment(Pos.CENTER);
        this.setSpacing(2);
        round.addObserver(this);
        RoundDTO roundDTO = round.toDTO();

        Label title = new Label("Ronda " + roundDTO.number());
        title.setStyle("-fx-font-size: 100px; -fx-text-fill: white;");

        this.getChildren().add(title);
        this.getChildren().add(new RoundScoreView(roundDTO.scoreToBeat()));
    }

    @Override
    public void update(RoundDTO roundDTO) {
        this.getChildren().clear();

        Label title = new Label("Ronda " + roundDTO.number());
        title.setStyle("-fx-font-size: 100px; -fx-text-fill: white;");

        this.getChildren().add(title);
        this.getChildren().add(new RoundScoreView(roundDTO.scoreToBeat()));
    }
}
