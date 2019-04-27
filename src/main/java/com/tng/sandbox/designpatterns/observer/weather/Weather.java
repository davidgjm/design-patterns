package com.tng.sandbox.designpatterns.observer.weather;

import lombok.Data;
        import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class Weather  {
    Integer lowest;
    Integer highest;
    String condition;
}
