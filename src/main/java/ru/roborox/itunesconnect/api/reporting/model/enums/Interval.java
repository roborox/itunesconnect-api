package ru.roborox.itunesconnect.api.reporting.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Interval {
    DAY,
    WEEK,
    QUARTER,
    YEAR,
    MONTH;

    @JsonValue
    public String getId() {
        return name().toLowerCase();
    }

    @JsonCreator
    public static Interval fromId(String id) {
        return valueOf(id.toUpperCase());
    }
}
