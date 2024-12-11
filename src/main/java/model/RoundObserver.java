package model;

import view.dtos.RoundDTO;

public interface RoundObserver {
    void update(RoundDTO roundDTO);
}
