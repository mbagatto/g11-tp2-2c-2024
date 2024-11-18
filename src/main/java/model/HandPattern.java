package model;

import model.Cards.Card;

import java.util.ArrayList;

public interface HandPattern {
    Hand verifyPattern(ArrayList<Card> cards);
}