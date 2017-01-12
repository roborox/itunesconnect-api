package ru.roborox.itunesconnect.api.analytics.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public enum AnalyticsDimension {
    TERRITORY("storefront");

    private final String id;
    private static final Map<String, AnalyticsDimension> ID_MAP = Arrays.stream(values()).collect(Collectors.toMap(AnalyticsDimension::getId, e -> e));

    AnalyticsDimension(String id) {
        this.id = id;
    }

    @JsonCreator
    public static AnalyticsDimension fromId(String id) {
        final AnalyticsDimension result = ID_MAP.get(id);
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
