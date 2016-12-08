package ru.roborox.itunesconnect.api.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public enum TimeSeriesMeasure {
    SALES("sales"),
    PAGE_VIEW_UNIQUE("pageViewUnique"),
    IMPRESSIONS_TOTAL_UNIQUE("impressionsTotalUnique"),
    UNITS("units"),
    PAYING_USERS("payingUsers");

    private final String id;
    private static final Map<String, TimeSeriesMeasure> ID_MAP = Arrays.stream(values()).collect(Collectors.toMap(TimeSeriesMeasure::getId, e -> e));

    TimeSeriesMeasure(String id) {
        this.id = id;
    }

    @JsonCreator
    public static TimeSeriesMeasure fromId(String id) {
        final TimeSeriesMeasure result = ID_MAP.get(id);
        if (result == null) {
            throw new IllegalArgumentException("id " + id + " not supported");
        }
        return result;
    }

    @JsonValue
    public String getId() {
        return id;
    }
}
