package view;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import model.Player;
import model.tarots.Tarot;

public class PlayerTarotsView extends HBox {

    public PlayerTarotsView(Pane stage, Player player) {
        HBox tarotsContainer = new HBox();
        tarotsContainer.setAlignment(Pos.CENTER_LEFT);
        tarotsContainer.setPrefWidth(500);
        tarotsContainer.setPrefHeight(175);
        tarotsContainer.setLayoutX(1300);
        tarotsContainer.setLayoutY(75);
        tarotsContainer.setSpacing(1);
        tarotsContainer.setStyle(
                "-fx-background-color: rgba(0,0,0,0.40);"
                        + "-fx-background-radius: 10px;"
                        + "-fx-padding: 8px;"
        );

        for (Tarot tarot : player.getTarots()) {
            VBox tarotContainer = new VBox();

            VBox tarotNameAndGraphic = new VBox();
            tarotNameAndGraphic.setAlignment(Pos.CENTER);

            Label tarotName = new Label(tarot.getName());
            tarotName.setStyle(
                    "-fx-text-fill: rgba(255,255,255,0.97);"
                            + "-fx-font-size: 16px;"
            );

            Image tarotImage = new Image("file:src/resources/textures/tarotImage.png");
            ImageView tarotImageView = new ImageView(tarotImage);
            tarotImageView.setFitHeight(100);
            tarotImageView.setFitWidth(75);

            Label tarotDescription = new Label(tarot.getDescription());
            tarotDescription.setStyle(
                    "-fx-text-fill: rgb(255,221,111);"
                            + "-fx-font-size: 16px;"
            );
            tarotDescription.setVisible(false);

            ButtonRemove buttonRemove = new ButtonRemove(tarotImageView, tarotDescription);

            tarotNameAndGraphic.getChildren().addAll(tarotName, buttonRemove);

            tarotContainer.getChildren().addAll(tarotNameAndGraphic, tarotDescription);

            tarotsContainer.getChildren().add(tarotContainer);
        }

        Label tarotsAmount = new Label(player.getTarotsSize() + "/2");
        tarotsAmount.setLayoutX(1305);
        tarotsAmount.setLayoutY(235);
        tarotsAmount.setStyle(
                "-fx-text-fill: rgba(255,255,255,0.97);"
                        + "-fx-font-size: 20px;"
        );

        stage.getChildren().addAll(tarotsContainer, tarotsAmount);
    }
}
