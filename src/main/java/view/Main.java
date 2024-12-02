package view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Main extends Application {
    private OnLaunchView onLaunchView;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        onLaunchView = new OnLaunchView(stage);

        VBox vbox = new VBox();
        vbox.getChildren().add(onLaunchView);

        Scene scene = new Scene(vbox);
        scene.getStylesheets().add("file:src/resources/custom-font-styles.css");
        stage.setScene(scene);
        stage.show();
    }

//    public void showRoundMenuScene(Game game) {
//        ArrayList<Round> rounds = (new RoundReader()).read("/cardsInfo/balatro.json");
//        game.setRounds(rounds);
//
//        Label chooseRoundLabel = new Label("Choose Round:");
//        chooseRoundLabel.setStyle("-fx-font-size: 75px; -fx-text-fill: white;");
//
//        HBox firstRow = new HBox();
//        firstRow.setAlignment(Pos.CENTER);
//        HBox secondRow = new HBox();
//        secondRow.setAlignment(Pos.CENTER);
//        ArrayList<VBox> roundsButtons = new ArrayList<>();
//
//
//        for (int i = 0; i < rounds.size(); i++) {
//            VBox roundButtonContainer = new VBox();
//            Button roundButton = new Button("Round " + rounds.get(i).getNumber());
//            roundButton.setStyle("-fx-background-color: rgb(248,74,74);" +
//                    "-fx-text-fill: white;" +
//                    "-fx-font-size: 50px; " +
//                    "-fx-cursor: hand;");
//            roundButton.setMinHeight(75);
//            roundButton.setMinWidth(380);
//            Text hands = new Text(rounds.get(i).getHands());
//            hands.setFill(Color.rgb(248, 74, 74));
//            Text discards = new Text(rounds.get(i).getDiscards());
//            discards.setFill(Color.rgb(248, 74, 74));
//            Text scoreToBeat = new Text(rounds.get(i).getScoreToBeat());
//            scoreToBeat.setFill(Color.rgb(248, 74, 74));
//            Label roundDescription = new Label(
//                    "Hands: " + hands.getText() + "    "
//                            + "Discards: " + discards.getText() + "    "
//                            + "Score: " + scoreToBeat.getText() + "    "
//            );
//            roundDescription.setStyle("-fx-font-size: 30px; -fx-text-fill: white;");
//
//            if (i != 0 && !rounds.get(i-1).wonRound()) {
//                roundButton.setDisable(true);
//                roundDescription.setStyle("-fx-font-size: 30px; -fx-text-fill: rgba(255,255,255,0.29);");
//            }
//
//            roundButtonContainer.getChildren().addAll(roundButton, roundDescription);
//            roundsButtons.add(roundButtonContainer);
//        }
//
//        firstRow.getChildren().addAll(roundsButtons.subList(0, 4));
//        secondRow.getChildren().addAll(roundsButtons.subList(4, 8));
//
//        VBox container = new VBox(30);
//        container.setAlignment(Pos.CENTER);
//        container.getChildren().addAll(chooseRoundLabel, firstRow, secondRow);
//
//        BorderPane borderPane = new BorderPane();
//        borderPane.setCenter(container);
//        borderPane.setStyle("-fx-background-color: rgba(0,0,0,0.77);");
//
//        Scene roundMenuScene = new Scene(borderPane, 1920, 1080);
//        roundMenuScene.getStylesheets().add("file:src/resources/custom-font-styles.css");
//        stage.setMaximized(true);
//        stage.setTitle("Balatro - Round Menu");
//        stage.setScene(roundMenuScene);
//    }
}
