package com.tng.sandbox.designpatterns.observer.pubsub.domainevents.infrastructure;

import org.springframework.scheduling.annotation.Async;

public interface DomainEventSubscriber<T extends DomainEvent> {

     Class<T> subscribedToEventType();
    @Async
    void onEvent(T event);
}
