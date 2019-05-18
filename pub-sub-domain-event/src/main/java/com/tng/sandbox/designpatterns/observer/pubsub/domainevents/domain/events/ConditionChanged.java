package com.tng.sandbox.designpatterns.observer.pubsub.domainevents.domain.events;

import com.tng.sandbox.designpatterns.observer.pubsub.domainevents.domain.Condition;
import com.tng.sandbox.designpatterns.observer.pubsub.domainevents.domain.Location;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public final class ConditionChanged extends WeatherConditionEvent {
    private final Condition condition;
    public ConditionChanged(Location location, Condition condition) {
        super(location);
        this.condition = condition;
    }

    public Condition getCondition() {
        return condition;
    }
}
