//package controller.buttonHandlers;
//
//import controller.SoundPlayer;
//import model.Player;
//import view.CardPane;
//import view.PlayerObserver;
//import java.util.List;
//
//public class CardPaneUp implements Movable {
//
//    public void move(CardPane cardPane, HandlerCardPane movable, List<Integer> indexs, Player player, PlayerObserver playerObserver) {
//        if(indexs.size() < 5){
//            cardPane.setTranslateY(cardPane.getTranslateY() - 50);
//            indexs.add(cardPane.getIndex());
//            //System.out.println(indexs.toString());
//            playerObserver.clearSelectCards();
//            playerObserver.selectCards(indexs);
//            movable.setMove(new CardPaneDown());
//            player.notifyPlayerDeck();
//        }
//    }
//}
