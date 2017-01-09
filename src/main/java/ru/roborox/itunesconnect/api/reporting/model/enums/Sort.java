package ru.roborox.itunesconnect.api.reporting.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Sort {
    ASCENDING,
    DESCENDING;

    @JsonValue
    public String getId() {
        return name().toLowerCase();
    }

    @JsonCreator
    public static Sort fromId(String id) {
        return valueOf(id.toUpperCase());
    }
}
