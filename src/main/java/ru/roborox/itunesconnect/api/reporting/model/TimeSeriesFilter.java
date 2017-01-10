package ru.roborox.itunesconnect.api.reporting.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import ru.roborox.itunesconnect.api.reporting.model.enums.Dimension;

import java.util.Arrays;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TimeSeriesFilter that = (TimeSeriesFilter) o;

        if (dimensionKey != that.dimensionKey) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(optionKeys, that.optionKeys);
    }

    @Override
    public int hashCode() {
        int result = dimensionKey != null ? dimensionKey.hashCode() : 0;
        result = 31 * result + Arrays.hashCode(optionKeys);
        return result;
    }
}
