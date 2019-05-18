package com.tng.sandbox.designpatterns.observer.pubsub.domainevents.application;

import com.tng.sandbox.designpatterns.observer.pubsub.domainevents.domain.Condition;
import com.tng.sandbox.designpatterns.observer.pubsub.domainevents.domain.Location;
import lombok.Data;

@Data
public class WeatherConditionDTO {
    Condition c;
    Integer t;
    Integer h;
    String w;
    Location l;

}
