package com.tng.sandbox.designpatterns.observer.pubsub.domainevents.infrastructure;

import java.time.LocalDateTime;

public abstract class AbstractDomainEvent implements DomainEvent {
    private LocalDateTime occuredOn;

    public AbstractDomainEvent() {
        this.occuredOn = LocalDateTime.now();
    }

    @Override
    public LocalDateTime occuredOn() {
        return this.occuredOn;
    }
}
