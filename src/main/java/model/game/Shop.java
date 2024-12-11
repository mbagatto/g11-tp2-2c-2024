package model.game;

import model.ObservableShop;
import model.ShopObserver;
import model.tarots.Tarot;
import model.jokers.Joker;
import view.dtos.ShopDTO;

import java.util.ArrayList;

public class Shop implements ObservableShop  {
    private ArrayList<Joker> jokers;
    private ArrayList<Tarot> tarots;
    private ArrayList<ShopObserver> observers;

    public Shop() {
        this.jokers = new ArrayList<>();
        this.tarots = new ArrayList<>();
        this.observers = new ArrayList<>();
    }

    public void addJoker(Joker joker) {
        this.jokers.add(joker);
        this.notifyObservers();
    }

    public void removeJoker(Joker joker) {
        this.jokers.remove(joker);
        this.notifyObservers();
    }

    public void addTarot(Tarot tarot) {
        this.tarots.add(tarot);
        this.notifyObservers();
    }

    public void removeTarot(Tarot tarot) {
        this.tarots.remove(tarot);
        this.notifyObservers();
    }

    public boolean isFull() {
        return (this.tarots.size() + this.jokers.size()) >= 4;
    }

    public void addObserver(ShopObserver observer) {
        this.observers.add(observer);
    }

    public void notifyObservers() {
        for (ShopObserver observer : observers) {
            observer.update(this.toDTO());
        }
    }

    public ShopDTO toDTO() {
        return new ShopDTO(this.jokers, this.tarots);
    }


}
