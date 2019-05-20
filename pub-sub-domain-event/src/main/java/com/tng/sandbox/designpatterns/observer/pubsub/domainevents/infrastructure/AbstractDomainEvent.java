package com.tng.sandbox.designpatterns.observer.pubsub.domainevents.infrastructure;

import java.time.LocalDateTime;
import java.util.UUID;

public abstract class AbstractDomainEvent implements DomainEvent {
    private final LocalDateTime occurredOn;
    private final String eventId;

    protected AbstractDomainEvent() {
        this.occurredOn = LocalDateTime.now();
        eventId = UUID.randomUUID().toString();
    }

    @Override
    public LocalDateTime occuredOn() {
        return this.occurredOn;
    }

    @Override
    public String eventId() {
        return eventId;
    }
}
