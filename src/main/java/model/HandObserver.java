package model;

import view.dtos.HandDTO;

public interface HandObserver {
    void update(HandDTO handDTO);
}
