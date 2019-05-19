package com.tng.sandbox.designpatterns.observer.core;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public abstract class AbstractSubject<T> implements Subject<T> {
    private final List<Observer<T>> observers;

    protected AbstractSubject() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void addObserver(Observer<T> observer) {
        assert observer != null;
        observers.add(observer);
    }

    @Override
    public boolean removeObserver(Observer<T> observer) {
        return observers.remove(observer);
    }

    @Override
    public final void notifyObservers() {
        log.info("Notifying all observers");
        observers.parallelStream().forEach(o -> o.update(getValue()));
        log.info("All observers notified.");
    }

}
