package ru.roborox.itunesconnect.api.model;

import ru.roborox.itunesconnect.api.model.enums.MeasureType;

public class TimeSeriesTotals {
    private int value;
    private String type;
    private MeasureType key;

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

    public MeasureType getKey() {
        return key;
    }

    public void setKey(MeasureType key) {
        this.key = key;
    }
}
