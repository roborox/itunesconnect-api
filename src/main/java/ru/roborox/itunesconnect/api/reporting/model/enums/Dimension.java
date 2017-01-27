package ru.roborox.itunesconnect.api.reporting.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Dimension {
    CONTENT,
    PIANO_LOCATION,
    VERSION_DESC_PIANO;

    @JsonValue
    public String getId() {
        return name().toLowerCase();
    }

    @JsonCreator
    public static Dimension fromId(String id) {
        return valueOf(id.toUpperCase());
    }
}
