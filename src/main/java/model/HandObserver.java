package model;

import view.records.HandDTO;

public interface HandObserver {
    void update(HandDTO handDTO);
}
