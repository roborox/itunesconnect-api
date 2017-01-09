package ru.roborox.itunesconnect.api.reporting.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import ru.roborox.itunesconnect.api.reporting.model.enums.Dimension;

public class TimeSeriesFilter {
    private Dimension dimensionKey;
    private String[] optionKeys;

    public TimeSeriesFilter(Dimension dimensionKey, String... optionKeys) {
        this.dimensionKey = dimensionKey;
        this.optionKeys = optionKeys;
    }

    @JsonProperty("dimension_key")
    public Dimension getDimensionKey() {
        return dimensionKey;
    }

    public void setDimensionKey(Dimension dimensionKey) {
        this.dimensionKey = dimensionKey;
    }

    @JsonProperty("option_keys")
    public String[] getOptionKeys() {
        return optionKeys;
    }

    public void setOptionKeys(String[] optionKeys) {
        this.optionKeys = optionKeys;
    }
}
