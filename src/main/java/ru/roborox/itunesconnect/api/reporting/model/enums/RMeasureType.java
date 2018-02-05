package ru.roborox.itunesconnect.api.reporting.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public enum RMeasureType {
    ROYALTY("Royalty"),
    ROYALTY_UTC("Royalty_utc");

    private final String id;
    private static final Map<String, RMeasureType> ID_MAP = Arrays.stream(values()).collect(Collectors.toMap(RMeasureType::getId, e -> e));

    RMeasureType(String id) {
        this.id = id;
    }

    @JsonCreator
    public static RMeasureType fromId(String id) {
        final RMeasureType result = ID_MAP.get(id);
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
