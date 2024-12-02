package view;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import model.Player;
import model.jokers.Joker;


public class PlayerJokersView extends HBox {
    public PlayerJokersView(Pane stage, Player player) {
        HBox jokersContainer = new HBox();
        jokersContainer.setAlignment(Pos.CENTER_LEFT);
        jokersContainer.setPrefWidth(750);
        jokersContainer.setPrefHeight(175);
        jokersContainer.setLayoutX(500);
        jokersContainer.setLayoutY(75);
        jokersContainer.setSpacing(5);
        jokersContainer.setStyle(
                "-fx-background-color: rgba(0,0,0,0.40);"
                        + "-fx-background-radius: 10px;"
                + "-fx-padding: 8px;"
        );

        for (Joker joker : player.getJokers()) {
            VBox jokerContainer = new VBox();

            VBox jokerNameAndGraphic = new VBox();
            jokerNameAndGraphic.setAlignment(Pos.CENTER);

            Label jokerName = new Label(joker.getName());
            jokerName.setStyle(
                    "-fx-text-fill: rgba(255,255,255,0.97);"
                    + "-fx-font-size: 16px;"
                    + "-fx-label-padding-left: 25px;"
            );

            Image jokerImage = new Image("file:src/resources/textures/jokerImage.png");
            ImageView jokerImageView = new ImageView(jokerImage);
            jokerImageView.setFitHeight(100);
            jokerImageView.setFitWidth(75);

            Label jokerDescription = new Label(joker.getDescription());
            jokerDescription.setStyle(
                    "-fx-text-fill: rgb(255,221,111);"
                            + "-fx-font-size: 16px;"
            );
            jokerDescription.setVisible(false);

            ButtonRemove buttonRemove = new ButtonRemove(jokerImageView, jokerDescription);
//            buttonRemove.setOnAction(new HandlerRemoveJoker(player, joker, ));

            jokerNameAndGraphic.getChildren().addAll(jokerName, buttonRemove);

            jokerContainer.getChildren().addAll(jokerNameAndGraphic, jokerDescription);

            jokersContainer.getChildren().add(jokerContainer);
        }

        Label jokersAmount = new Label(player.getJokersSize() + "/5");
        jokersAmount.setLayoutX(505);
        jokersAmount.setLayoutY(235);
        jokersAmount.setStyle(
                "-fx-text-fill: rgba(255,255,255,0.97);"
                        + "-fx-font-size: 20px;"
        );

        stage.getChildren().addAll(jokersContainer, jokersAmount);
    }
}
