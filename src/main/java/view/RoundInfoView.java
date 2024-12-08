package view;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.RoundObserver;
import model.game.Round;
import view.records.RoundDTO;

public class RoundInfoView extends VBox implements RoundObserver {
    private PreparationView stage;

    public RoundInfoView(PreparationView stage, Round round) {
        super();
        this.stage = stage;
        round.addObserver(this);
        RoundDTO roundDTO = round.toDTO();

        this.setId("info-container");
        this.setLayoutX(62);
        this.setLayoutY(350);
        this.setMinWidth(350);
        this.setSpacing(50);

        VBox pointsAndMultContainer = new VBox();
        pointsAndMultContainer.setId("points-and-mult");
        pointsAndMultContainer.setMinHeight(200);
        pointsAndMultContainer.setPrefWidth(375);
        pointsAndMultContainer.setAlignment(Pos.CENTER);
        pointsAndMultContainer.setSpacing(20);

        Label handType = new Label();
        handType.setStyle("-fx-text-fill: white; -fx-font-size: 60;");

        HBox pointsAndMultHBox = new HBox();
        pointsAndMultHBox.setSpacing(10);
        pointsAndMultHBox.setAlignment(Pos.CENTER);

        Label playsPoints = new Label("0");
        playsPoints.setId("plays-points");
        playsPoints.setPrefWidth(150);
        playsPoints.setAlignment(Pos.CENTER_RIGHT);

        Label playsSymbol = new Label("X");
        playsSymbol.setStyle("-fx-text-fill: rgb(255, 235, 167); -fx-font-size: 25px;");

        Label playsMult = new Label("0");
        playsMult.setId("plays-mult");
        playsMult.setPrefWidth(150);
        playsMult.setAlignment(Pos.CENTER_LEFT);

        pointsAndMultHBox.getChildren().add(playsPoints);
        pointsAndMultHBox.getChildren().add(playsSymbol);
        pointsAndMultHBox.getChildren().add(playsMult);

        pointsAndMultContainer.getChildren().addAll(handType, pointsAndMultHBox);

        this.getChildren().add(new ActualScoreView(roundDTO.actualScore()));
        this.getChildren().add(pointsAndMultContainer);
        this.getChildren().add(new HandsAndDiscardsView(roundDTO.hands(), roundDTO.discards()));
    }

    @Override
    public void update(RoundDTO roundDTO) {
        this.getChildren().removeFirst(); // remuevo ActualScoreView
        this.getChildren().removeLast(); // remuevo HandsAndDiscardsView

        this.getChildren().add(new ActualScoreView(roundDTO.actualScore())); // agrego ActualScoreView actualizado
        this.getChildren().add(new HandsAndDiscardsView(roundDTO.hands(), roundDTO.discards())); // agrego HandsAndDiscardsView actualizado

        this.stage.updateView(this);
    }
}
