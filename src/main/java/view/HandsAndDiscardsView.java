package view;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class HandsAndDiscardsView extends HBox {
    public HandsAndDiscardsView(String hands, String discards) {
        super();
        this.setLayoutX(145);
        this.setLayoutY(800);
        this.setAlignment(Pos.CENTER);
        this.setSpacing(10);

        VBox roundInfoHandsContainer = new VBox();
        roundInfoHandsContainer.setPrefWidth(125);
        roundInfoHandsContainer.setMinHeight(92);
        roundInfoHandsContainer.setAlignment(Pos.CENTER);
        roundInfoHandsContainer.setStyle("-fx-background-color: rgba(0,0,0,0.5); -fx-background-radius: 15px;");

        Label handsContainerTitle = new Label("Manos");
        handsContainerTitle.setStyle("-fx-font-size: 26px; -fx-text-fill: white;");

        Label handsValueContainer = new Label(hands);
        handsValueContainer.setId("hands-value-container");
        handsValueContainer.setAlignment(Pos.CENTER);
        handsValueContainer.setMinWidth(115);

        roundInfoHandsContainer.getChildren().addAll(handsContainerTitle, handsValueContainer);

        VBox roundInfoDiscardsContainer = new VBox();
        roundInfoDiscardsContainer.setPrefWidth(125);
        roundInfoDiscardsContainer.setMinHeight(92);
        roundInfoDiscardsContainer.setAlignment(Pos.CENTER);
        roundInfoDiscardsContainer.setStyle("-fx-background-color: rgba(0,0,0,0.5); -fx-background-radius: 15px;");

        Label discardsContainerTitle = new Label("Descartes");
        discardsContainerTitle.setStyle("-fx-font-size: 26px; -fx-text-fill: white;");

        Label discardsValueContainer = new Label(discards);
        discardsValueContainer.setId("discards-value-container");
        discardsValueContainer.setAlignment(Pos.CENTER);
        discardsValueContainer.setMinWidth(115);

        roundInfoDiscardsContainer.getChildren().addAll(discardsContainerTitle, discardsValueContainer);

        this.getChildren().add(roundInfoHandsContainer);
        this.getChildren().add(roundInfoDiscardsContainer);
    }
}
