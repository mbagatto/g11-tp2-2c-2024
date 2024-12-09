package view;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class PointsAndMultView extends VBox {
    public PointsAndMultView() {
        super();
        this.setId("points-and-mult");
        this.setMinHeight(200);
        this.setPrefWidth(375);
        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);

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
}
