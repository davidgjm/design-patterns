package com.tng.sandbox.designpatterns.observer.pubsub.domainevents.infrastructure;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Slf4j
@Service
public class DomainEventPublisherImpl implements DomainEventPublisher {
    private static final Set<DomainEventSubscriber> subscribers = new HashSet<>();

    @Override
    public <T extends DomainEvent> void subscribe(DomainEventSubscriber<T> subscriber) {
        log.info("Registering subscriber: {}", subscriber.getClass().getName());
        boolean isAdded = subscribers.add((subscriber));
        if (!isAdded) {
            log.warn("The subscriber is already added! {}", subscriber.getClass().getName());
        }
    }

    @Override
    public <T extends DomainEvent> void unsubscribe(DomainEventSubscriber<T> subscriber) {
        log.info("Removing subscriber {}", subscriber.getClass().getName());
        boolean isRemoved = subscribers.remove(subscriber);
        if (!isRemoved) {
            log.warn("Subscriber not found in the registered list. {}", subscriber.getClass().getName());
        }
    }

    @Async
    @Override
    public <T extends DomainEvent> void publish(final T domainEvent) {
        log.info("About to publish event {}", domainEvent.getClass().getName());
        log.info("Event ID: {}", domainEvent.eventId());

        subscribers.parallelStream()
                .filter(p -> p.subscribedToEventType().equals(domainEvent.getClass()))
                .forEach(s -> {
                    log.info("Notifying subscriber: {}", s.getClass().getName());
                    s.onEvent(domainEvent);
                });
    }
}
