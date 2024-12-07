//package controller.buttonHandlers;
//
//import controller.SoundPlayer;
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
//import javafx.scene.Scene;
//import javafx.scene.layout.VBox;
//import javafx.stage.Stage;
//import model.Player;
//import model.game.Game;
//import model.game.Round;
//import view.GameView;
//import view.PlayerJokersView;
//import view.PlayerTarotsView;
//
//public class HandlerNextRound  implements EventHandler<ActionEvent> {
//    private Stage stage;
//    private Player player;
//    private Round round;
//    private Game game;
//    private SoundPlayer soundPlayer;
//    private PlayerJokersView playerJokersView;
//    private PlayerTarotsView playerTarotsView;
//
//    public HandlerNextRound(Stage stage, Player player, Round round, Game game, PlayerJokersView playerJokersView, PlayerTarotsView playerTarotsView) {
//        this.stage = stage;
//        this.player = player;
//        this.round = round;
//        this.game = game;
//        this.playerJokersView = playerJokersView;
//        this.playerTarotsView = playerTarotsView;
//        this.soundPlayer = new SoundPlayer();
//    }
//
//    public void handle(ActionEvent actionEvent) {
//        this.soundPlayer.playButtonSound();
//        Scene gameScene = new Scene(new GameView(this.stage, this.player, this.round, this.game, this.playerJokersView, this.playerTarotsView));
//        gameScene.getStylesheets().add("file:src/resources/custom-font-styles.css");
//        this.stage.setScene(gameScene);
//        this.stage.setFullScreen(true);
//        this.stage.setFullScreenExitHint("");
//    }
//}
