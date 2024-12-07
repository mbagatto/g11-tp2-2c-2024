//package view;
//
//import controller.SoundPlayer;
//import controller.buttonHandlers.HandlerNextGame;
//import javafx.geometry.Pos;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.layout.VBox;
//import javafx.stage.Stage;
//import model.Player;
//import model.game.Game;
//import model.game.Round;
//import view.buttons.ButtonNextRound;
//
//public class WinRoundView extends VBox {
//    public WinRoundView(Stage stage, Player player, Round actualRound, Game game, PlayerJokersView playerJokersView, PlayerTarotsView playerTarotsView) {
//        super();
//        this.setId("win-round-view");
//        this.setAlignment(Pos.CENTER);
//        this.setSpacing(10);
//
//        SoundPlayer soundPlayer = new SoundPlayer();
//        soundPlayer.playWinRound();
//
//        if (actualRound == null) {
//            FinalWinScreenView finalScreen = new FinalWinScreenView(stage);
//        }
//
//        Label messageTitle = new Label("¡Felicidades! Has ganado la ronda.");
//        messageTitle.setStyle("-fx-font-size: 48; -fx-text-fill: white");
//
//        Label messageSubtitle = new Label("Presiona el botón para avanzar a la siguiente ronda");
//        messageSubtitle.setStyle("-fx-font-size: 26; -fx-text-fill: white");
//
//        Button nextRound = new ButtonNextRound(stage, player, actualRound, game, playerJokersView, playerTarotsView);
//        nextRound.setOnAction(new HandlerNextGame(stage, player, game.nextRound(), game));
//
//        this.getChildren().add(messageTitle);
//        this.getChildren().add(messageSubtitle);
//        this.getChildren().add(nextRound);
//    }
//}
