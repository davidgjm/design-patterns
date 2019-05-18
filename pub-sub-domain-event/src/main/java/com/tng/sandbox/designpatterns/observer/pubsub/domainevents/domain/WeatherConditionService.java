package com.tng.sandbox.designpatterns.observer.pubsub.domainevents.domain;

import java.time.LocalDateTime;
import java.util.List;

public interface WeatherConditionService {
    List<WeatherCondition> dataOf(Location location);

    List<WeatherCondition> dataOfAndOn(Location location, LocalDateTime localDateTime);

    void updateWeatherCondition(WeatherCondition condition);
}
