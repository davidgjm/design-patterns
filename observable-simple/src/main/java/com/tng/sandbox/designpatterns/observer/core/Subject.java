package com.tng.sandbox.designpatterns.observer.core;

public interface Subject<T> {
    void addObserver(Observer<T> observer);

    boolean removeObserver(Observer<T> observer);

    void notifyObservers();

    T getValue();
}
