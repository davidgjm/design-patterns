package com.tng.sandbox.designpatterns.observer.pubsub.domainevents.domain;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Data
@Accessors(chain = true)
@Table(
        uniqueConstraints = {
                @UniqueConstraint(name = "uq_location_moment", columnNames = {"location","moment"})
        }
)
@Entity
public final class WeatherCondition {
    @Id
    @GeneratedValue
    private Long id;

    @Enumerated(value = EnumType.STRING)
    Condition condition;

    int temperature;
    int humidity;
    String windSpeed;

    @Enumerated(value = EnumType.STRING)
    Location location;

    @Column(nullable = false, updatable = false, unique = true)
    LocalDateTime moment;

    @PrePersist
    private void onCreate() {
        this.moment = moment.truncatedTo(ChronoUnit.MINUTES)
        ;
    }

}
