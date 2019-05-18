package com.tng.sandbox.designpatterns.observer.pubsub.domainevents.infrastructure;

public interface DomainEventPublisher {

    <T extends DomainEvent> void subscribe(DomainEventSubscriber<T> subscriber);

    <T extends DomainEvent> void unsubscribe(DomainEventSubscriber<T> subscriber);

    <T extends DomainEvent> void publish(final T domainEvent);
}
