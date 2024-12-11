package model;

import view.dtos.PlayerDeckDTO;

public interface PlayerDeckObserver {
    void update(PlayerDeckDTO playerDeckDTO);
}
