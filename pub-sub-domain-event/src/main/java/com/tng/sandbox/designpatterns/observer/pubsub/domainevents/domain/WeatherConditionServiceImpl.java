package com.tng.sandbox.designpatterns.observer.pubsub.domainevents.domain;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class WeatherConditionServiceImpl implements WeatherConditionService {
    private final WeatherConditionRepository repository;

    public WeatherConditionServiceImpl(WeatherConditionRepository repository) {
        this.repository = repository;
    }


    @Override
    public List<WeatherCondition> dataOf(Location location) {
        return null;
    }

    @Override
    public List<WeatherCondition> dataOfAndOn(Location location, LocalDateTime localDateTime) {
        return null;
    }

    @Override
    public void updateWeatherCondition(WeatherCondition condition) {
        LocalDateTime timeToHour = condition.getMoment().truncatedTo(ChronoUnit.MINUTES);
        Optional<WeatherCondition> weatherConditionOptional = repository.getWeatherConditionByLocationAndMoment(condition.getLocation(), timeToHour);

        if (weatherConditionOptional.isPresent()) {
            WeatherCondition c = weatherConditionOptional.get();
            if (condition.getCondition() != null) {
                c.setCondition(condition.condition);
            }
            if (condition.getWindSpeed() != null) {
                c.setWindSpeed(condition.getWindSpeed());
            }

            if (condition.getTemperature() > 0) {
                c.setTemperature(condition.temperature);
            }

            if (condition.getHumidity() > 0) {
                c.setHumidity(condition.getHumidity());
            }
            log.info("Updated weather condition: {}", c);
            repository.save(c);
        } else {
            repository.save(condition);
        }

    }

}
