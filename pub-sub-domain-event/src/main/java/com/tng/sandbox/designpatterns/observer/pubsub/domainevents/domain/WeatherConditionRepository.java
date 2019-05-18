package com.tng.sandbox.designpatterns.observer.pubsub.domainevents.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Optional;

public interface WeatherConditionRepository extends JpaRepository<WeatherCondition, Long> {
    Optional<WeatherCondition> getWeatherConditionByLocationAndMoment(Location location, LocalDateTime moment);
}
