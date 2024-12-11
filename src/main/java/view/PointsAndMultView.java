package view;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.PlayerDeckObserver;
import model.decks.PlayerDeck;
import view.records.PlayerDeckDTO;

public class PointsAndMultView extends VBox implements PlayerDeckObserver {

        public PointsAndMultView(PlayerDeck playerDeck) {
        super();
        this.setId("points-and-mult");
        this.setMinHeight(200);
        this.setPrefWidth(375);
        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);

        playerDeck.addObserver(this);

        Label handType = new Label();
        handType.setStyle("-fx-text-fill: rgb(255, 235, 167); -fx-font-size: 60;");

        HBox pointsAndMultHBox = new HBox();
        pointsAndMultHBox.setSpacing(10);
        pointsAndMultHBox.setAlignment(Pos.CENTER);

        Label playsPoints = new Label("0");
        playsPoints.setId("plays-points");
        playsPoints.setPrefWidth(150);
        playsPoints.setAlignment(Pos.CENTER_RIGHT);

        Label playsSymbol = new Label("X");
        playsSymbol.setStyle("-fx-text-fill: rgb(255, 235, 167); -fx-font-size: 36px;");

        Label playsMult = new Label("0");
        playsMult.setId("plays-mult");
        playsMult.setPrefWidth(150);
        playsMult.setAlignment(Pos.CENTER_LEFT);

        pointsAndMultHBox.getChildren().add(playsPoints);
        pointsAndMultHBox.getChildren().add(playsSymbol);
        pointsAndMultHBox.getChildren().add(playsMult);

        this.getChildren().addAll(handType, pointsAndMultHBox);
    }

    @Override
    public void update(PlayerDeckDTO playerDeckDTO) {

        this.getChildren().clear();

        Label handType = new Label(playerDeckDTO.handDTO().name());
        handType.setStyle("-fx-text-fill: rgb(255, 235, 167); -fx-font-size: 60;");

        HBox pointsAndMultHBox = new HBox();
        pointsAndMultHBox.setSpacing(10);
        pointsAndMultHBox.setAlignment(Pos.CENTER);

        Label playsPoints = new Label(playerDeckDTO.handDTO().points());
        playsPoints.setId("plays-points");
        playsPoints.setPrefWidth(150);
        playsPoints.setAlignment(Pos.CENTER_RIGHT);

        Label playsSymbol = new Label("X");
        playsSymbol.setStyle("-fx-text-fill: rgb(255, 235, 167); -fx-font-size: 36px;");

        Label playsMult = new Label(playerDeckDTO.handDTO().multiplier());
        playsMult.setId("plays-mult");
        playsMult.setPrefWidth(150);
        playsMult.setAlignment(Pos.CENTER_LEFT);

        pointsAndMultHBox.getChildren().add(playsPoints);
        pointsAndMultHBox.getChildren().add(playsSymbol);
        pointsAndMultHBox.getChildren().add(playsMult);

        this.getChildren().addAll(handType, pointsAndMultHBox);
    }
}
