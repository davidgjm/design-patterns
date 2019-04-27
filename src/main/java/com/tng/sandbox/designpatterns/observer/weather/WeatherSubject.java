package com.tng.sandbox.designpatterns.observer.weather;

import com.tng.sandbox.designpatterns.observer.core.AbstractSubject;
import com.tng.sandbox.designpatterns.observer.core.Subject;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Data
@EqualsAndHashCode(callSuper = false)
@Component
public class WeatherSubject extends AbstractSubject<Weather> implements Subject<Weather> {
    private Weather weather;

    public void setWeather(Weather weather) {
        if (this.weather==null || !this.weather.equals(weather)) {
            this.weather = weather;
            notifyObservers();
        }
    }

    @Override
    public Weather getValue() {
        return weather;
    }
}
