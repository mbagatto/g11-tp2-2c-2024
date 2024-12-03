package model;

import view.records.PlayerRecord;
import view.records.RoundRecord;

public interface ObserverRound {
    void update(RoundRecord roundRecord);
}
