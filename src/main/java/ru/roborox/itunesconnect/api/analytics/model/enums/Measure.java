package ru.roborox.itunesconnect.api.analytics.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public enum Measure {
    SALES("sales"),
    PAGE_VIEW_UNIQUE("pageViewUnique"),
    IMPRESSIONS_TOTAL_UNIQUE("impressionsTotalUnique"),
    IMPRESSIONS_TOTAL("impressionsTotal"),
    UNITS("units"),
    IAP("iap"),
    ACTIVE_DEVICES("activeDevices"),
    SESSIONS("sessions"),
    CRASHES("crashes"),
    PAYING_USERS("payingUsers");

    private final String id;
    private static final Map<String, Measure> ID_MAP = Arrays.stream(values()).collect(Collectors.toMap(Measure::getId, e -> e));

    Measure(String id) {
        this.id = id;
    }

    @JsonCreator
    public static Measure fromId(String id) {
        final Measure result = ID_MAP.get(id);
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
