package com.tng.sandbox.designpatterns.observer.pubsub.domainevents.domain.events;

import com.tng.sandbox.designpatterns.observer.pubsub.domainevents.domain.Location;
import com.tng.sandbox.designpatterns.observer.pubsub.domainevents.infrastructure.AbstractDomainEvent;

public abstract class WeatherConditionEvent extends AbstractDomainEvent {
    private final Location location;

    WeatherConditionEvent(Location location) {
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }
}
