package model;

import view.records.PlayerDeckDTO;

public interface PlayerDeckObserver {
    void update(PlayerDeckDTO playerDeckDTO);
}
