package com.tng.sandbox.designpatterns.observer.pubsub.domainevents.infrastructure;

import java.time.LocalDateTime;
import java.util.UUID;

public interface DomainEvent {
    default String getEventId(){
        return UUID.randomUUID().toString();
    }

    LocalDateTime occuredOn();
}
