//package controller.buttonHandlers;
//
//import controller.SoundPlayer;
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
//import javafx.stage.Stage;
//import view.PlayerObserver;
//import view.TurnedDeckView;
//
//import java.util.List;
//
//public class HandlerPlayHand implements EventHandler<ActionEvent> {
//
//    private PlayerObserver playerObserver;
//    private RoundObserver roundObserver;
//    private List<Integer> indexCards;
//    private Stage stage;
//    private TurnedDeckView turnedDeckView;
//    private SoundPlayer soundPlayer;
//
//    public HandlerPlayHand(PlayerObserver playerObserver, RoundObserver roundObserver, List<Integer> indexCards, Stage stage, TurnedDeckView turnedDeckView) {
//        this.playerObserver = playerObserver;
//        this.roundObserver = roundObserver;
//        this.indexCards = indexCards;
//        this.stage = stage;
//        this.turnedDeckView = turnedDeckView;
//        this.soundPlayer = new SoundPlayer();
//    }
//
//    public void handle(ActionEvent event) {
//        this.soundPlayer.playButtonSound();
//        if (! this.roundObserver.ranOutOfHands()) {
//            this.roundObserver.playHand(this.playerObserver.getplayer());
//            this.turnedDeckView.updateLabel();
//            this.playerObserver.notifyObserversPlayer();
//            this.indexCards.clear();
//            this.roundObserver.subtractHand();
//        }
////        checkLoserStatus();
//    }
//
////    public void checkLoserStatus() {
////        if (this.roundObserver.isGameOver()) { // Aca se decide que pasa cuando se pierde
////            GameOverView gameOverView = new GameOverView(this.stage);
////        }
////    }
//}
