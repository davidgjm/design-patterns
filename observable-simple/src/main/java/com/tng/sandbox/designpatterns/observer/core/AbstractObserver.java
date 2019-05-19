package com.tng.sandbox.designpatterns.observer.core;

public abstract class AbstractObserver<T> implements Observer<T>{
    private final Subject<T> subject;

    public AbstractObserver(Subject<T> subject) {
        this.subject = subject;
        this.subject.addObserver(this);
    }

    protected Subject<T> getSubject() {
        return subject;
    }
}
