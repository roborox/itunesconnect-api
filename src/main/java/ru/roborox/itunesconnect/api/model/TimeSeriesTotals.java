package ru.roborox.itunesconnect.api.model;

import ru.roborox.itunesconnect.api.model.enums.TimeSeriesMeasure;

public class TimeSeriesTotals {
    private int value;
    private String type;
    private TimeSeriesMeasure key;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public TimeSeriesMeasure getKey() {
        return key;
    }

    public void setKey(TimeSeriesMeasure key) {
        this.key = key;
    }
}
