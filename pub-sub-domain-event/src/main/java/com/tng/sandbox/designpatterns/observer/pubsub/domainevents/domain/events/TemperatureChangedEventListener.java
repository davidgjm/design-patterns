package com.tng.sandbox.designpatterns.observer.pubsub.domainevents.domain.events;

import com.tng.sandbox.designpatterns.observer.pubsub.domainevents.domain.WeatherCondition;
import com.tng.sandbox.designpatterns.observer.pubsub.domainevents.domain.WeatherConditionService;
import com.tng.sandbox.designpatterns.observer.pubsub.domainevents.infrastructure.DomainEventPublisher;
import com.tng.sandbox.designpatterns.observer.pubsub.domainevents.infrastructure.DomainEventSubscriber;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Slf4j
@Component
public class TemperatureChangedEventListener implements DomainEventSubscriber<TemperatureChangedEvent> {
    private final DomainEventPublisher eventPublisher;
    private final WeatherConditionService weatherConditionService;

    public TemperatureChangedEventListener(DomainEventPublisher eventPublisher, WeatherConditionService weatherConditionService) {
        this.eventPublisher = eventPublisher;
        this.weatherConditionService = weatherConditionService;
    }

    @PostConstruct
    private void init() {
        eventPublisher.subscribe(this);
    }

    @Override
    public Class<TemperatureChangedEvent> subscribedToEventType() {
        return TemperatureChangedEvent.class;
    }

    @Override
    public void onEvent(TemperatureChangedEvent event) {
        log.info("Handling temperature changed event");
        WeatherCondition wc = new WeatherCondition();
        wc.setTemperature(event.getTemperature());
        wc.setLocation(event.getLocation());
        wc.setMoment(event.occuredOn());
        weatherConditionService.updateWeatherCondition(wc);
    }
}
