package ru.roborox.itunesconnect.api.analytics.model;

import ru.roborox.itunesconnect.api.analytics.model.enums.Dimension;

public class TimeSeriesFilter {
    private Dimension dimensionKey;
    private String[] optionKeys;

    public TimeSeriesFilter() {
    }

    public TimeSeriesFilter(Dimension dimensionKey, String... optionKeys) {
        this.dimensionKey = dimensionKey;
        this.optionKeys = optionKeys;
    }

    public Dimension getDimensionKey() {
        return dimensionKey;
    }

    public void setDimensionKey(Dimension dimensionKey) {
        this.dimensionKey = dimensionKey;
    }

    public String[] getOptionKeys() {
        return optionKeys;
    }

    public void setOptionKeys(String[] optionKeys) {
        this.optionKeys = optionKeys;
    }
}
