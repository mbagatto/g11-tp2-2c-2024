package model;

import view.records.RoundDTO;

public interface RoundObserver {
    void update(RoundDTO roundDTO);
}
