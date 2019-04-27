package com.tng.sandbox.designpatterns.observer.web;

import com.tng.sandbox.designpatterns.observer.weather.Weather;
import com.tng.sandbox.designpatterns.observer.weather.WeatherSubject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

@Slf4j
@RestController
@RequestMapping("/api/weather")
public class WeatherController {
    private final WeatherSubject subject;

    public WeatherController(WeatherSubject subject) {
        this.subject = subject;
    }

    @PostMapping
    public void forecast(@RequestBody @NotNull Weather weather) {
        log.info("Receiving weather forecast data");
        log.info("Incoming weather data: {}", weather);
        subject.setWeather(weather);
        log.info("Forecast finished....");
    }
}
