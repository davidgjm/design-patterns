package com.tng.sandbox.designpatterns.observer.pubsub.domainevents.infrastructure;

import java.time.LocalDateTime;

public interface DomainEvent {
    String eventId();

    LocalDateTime occuredOn();
}
