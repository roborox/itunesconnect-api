package ru.roborox.itunesconnect.api.reporting.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public enum MeasureType {
    ROYALTY("Royalty"),
    ROYALTY_UTC("Royalty_utc");

    private final String id;
    private static final Map<String, MeasureType> ID_MAP = Arrays.stream(values()).collect(Collectors.toMap(MeasureType::getId, e -> e));

    MeasureType(String id) {
        this.id = id;
    }

    @JsonCreator
    public static MeasureType fromId(String id) {
        final MeasureType result = ID_MAP.get(id);
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
