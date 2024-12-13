package view;

import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import model.Player;
import model.PlayerObserver;
import model.game.Shop;
import view.dtos.PlayerDTO;

public class PlayerTarotsContainer extends VBox implements PlayerObserver {
    private Group stage;
    private Player player;
    private Shop shop;
    private TarotsContainerView tarotsContainerView;
    private final boolean isRoundGameView;

    public PlayerTarotsContainer(Group stage, Player player, Shop shop, boolean isRoundGameView) {
        super();
        this.stage = stage;
        this.player = player;
        this.shop = shop;
        this.isRoundGameView = isRoundGameView;
        player.addObserver(this);
        PlayerDTO playerDTO = player.toDTO();

        this.setLayoutX(1300);
        this.setLayoutY(100);
        this.setSpacing(5);

        this.tarotsContainerView = new TarotsContainerView(player, playerDTO.tarots(), shop, isRoundGameView);
        this.getChildren().add(tarotsContainerView);

        Label tarotsCount = new Label(playerDTO.tarots().size() + "/2");
        tarotsCount.setId("player-tarots-count");
        this.getChildren().add(tarotsCount);
    }

    @Override
    public void update(PlayerDTO playerDTO) {
        this.getChildren().clear();

        this.tarotsContainerView = new TarotsContainerView(player, playerDTO.tarots(), shop, this.isRoundGameView);
        this.getChildren().add(tarotsContainerView);

        Label tarotsCount = new Label(playerDTO.tarots().size() + "/2");
        tarotsCount.setId("player-tarots-count");
        this.getChildren().add(tarotsCount);

        this.stage.getChildren().remove(this);
        this.stage.getChildren().add(this);
    }

    public void setUseButtonEnabled() {
        this.tarotsContainerView.setUseButtonEnabled();
    }
}
