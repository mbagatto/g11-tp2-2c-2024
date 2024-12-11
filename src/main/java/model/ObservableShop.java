package model;

public interface ObservableShop {
    void addObserver(ShopObserver observer);
    void notifyObservers();
}
