package model;

import model.jokers.Joker;
import model.tarots.Tarot;

import java.util.ArrayList;

public interface Purchaser {
    ArrayList<Joker> getJokers();
    ArrayList<Tarot> getTarots();
}
