package com.tng.sandbox.designpatterns.observer.pubsub.domainevents.domain.events;

import com.tng.sandbox.designpatterns.observer.pubsub.domainevents.domain.Location;

public final class TemperatureChangedEvent extends WeatherConditionEvent {
    private final int temperature;

    public TemperatureChangedEvent(Location location, int temperature) {
        super(location);
        this.temperature = temperature;
    }

    public int getTemperature() {
        return temperature;
    }
}
