package com.tng.sandbox.designpatterns.observer.weather.observers;

import com.tng.sandbox.designpatterns.observer.core.AbstractObserver;
import com.tng.sandbox.designpatterns.observer.core.Observer;
import com.tng.sandbox.designpatterns.observer.core.Subject;
import com.tng.sandbox.designpatterns.observer.weather.Weather;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class WeatherObserverImpl extends AbstractObserver<Weather> implements Observer<Weather> {
    public WeatherObserverImpl(Subject<Weather> subject) {
        super(subject);
    }

    @Override
    public void update(Weather value) {
        log.warn("Weather has changed to {}", value);
    }
}
