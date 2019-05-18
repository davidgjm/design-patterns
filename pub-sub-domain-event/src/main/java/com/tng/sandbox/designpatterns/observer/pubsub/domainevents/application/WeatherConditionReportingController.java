package com.tng.sandbox.designpatterns.observer.pubsub.domainevents.application;

import com.tng.sandbox.designpatterns.observer.pubsub.domainevents.domain.Condition;
import com.tng.sandbox.designpatterns.observer.pubsub.domainevents.domain.Location;
import com.tng.sandbox.designpatterns.observer.pubsub.domainevents.domain.events.ConditionChanged;
import com.tng.sandbox.designpatterns.observer.pubsub.domainevents.domain.events.TemperatureChangedEvent;
import com.tng.sandbox.designpatterns.observer.pubsub.domainevents.infrastructure.DomainEventPublisher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

@Slf4j
@RestController
@RequestMapping("/weather/feeds")
public class WeatherConditionReportingController {
    private final DomainEventPublisher eventPublisher;

    public WeatherConditionReportingController(DomainEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }


    @PostMapping("/t")
    public void feedTemperature(
            @RequestParam("l") @NotNull Location location,
            @RequestParam("t") @NotNull Integer temperature) {
        log.info("Received temperature {}", temperature);

        eventPublisher.publish(new TemperatureChangedEvent(location, temperature));
    }

    @PostMapping("/c")
    public void feedCondition(@RequestParam("l") @NotNull Location location, @RequestParam("c") @NotNull Condition condition) {
        log.info("Received reported condition change for {}: {}", location, condition);
        eventPublisher.publish(new ConditionChanged(location, condition));
    }
}
