package ru.roborox.itunesconnect.api.reporting.model;

import ru.roborox.itunesconnect.api.reporting.model.enums.RMeasureType;

public class RMeasure {
    private RMeasureType key;
    
    public RMeasure() {
    }
    
    public RMeasure(RMeasureType key) {
        this.key = key;
    }

    public RMeasureType getKey() {
        return key;
    }
    
    public void setKey(RMeasureType key) {
        this.key = key;
    }
}
