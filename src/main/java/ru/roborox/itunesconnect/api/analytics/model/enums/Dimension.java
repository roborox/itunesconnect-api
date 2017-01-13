package ru.roborox.itunesconnect.api.analytics.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public enum Dimension {
    TERRITORY("storefront");

    private final String id;
    private static final Map<String, Dimension> ID_MAP = Arrays.stream(values()).collect(Collectors.toMap(Dimension::getId, e -> e));

    Dimension(String id) {
        this.id = id;
    }

    @JsonCreator
    public static Dimension fromId(String id) {
        final Dimension result = ID_MAP.get(id);
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
