package com.tng.sandbox.designpatterns.observer.pubsub.domainevents.domain.events;

import com.tng.sandbox.designpatterns.observer.pubsub.domainevents.domain.WeatherCondition;
import com.tng.sandbox.designpatterns.observer.pubsub.domainevents.domain.WeatherConditionService;
import com.tng.sandbox.designpatterns.observer.pubsub.domainevents.infrastructure.DomainEventPublisher;
import com.tng.sandbox.designpatterns.observer.pubsub.domainevents.infrastructure.DomainEventSubscriber;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Slf4j
@Component
public class ConditionChangedEventListener implements DomainEventSubscriber<ConditionChanged> {
    private final DomainEventPublisher publisher;
    private final WeatherConditionService weatherConditionService;

    public ConditionChangedEventListener(DomainEventPublisher publisher, WeatherConditionService weatherConditionService) {
        this.publisher = publisher;
        this.weatherConditionService = weatherConditionService;
    }

    @PostConstruct
    private void init() {
        publisher.subscribe(this);
    }

    @Override
    public Class<ConditionChanged> subscribedToEventType() {
        return ConditionChanged.class;
    }

    @Async
    @Override
    public void onEvent(ConditionChanged event) {
        log.info("Handling condition changed event. {}", event);
        WeatherCondition wc = new WeatherCondition();
        wc.setLocation(event.getLocation());
        wc.setMoment(event.occuredOn());
        wc.setCondition(event.getCondition());
        weatherConditionService.updateWeatherCondition(wc);
    }
}
