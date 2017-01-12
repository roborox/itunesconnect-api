package ru.roborox.itunesconnect.api.analytics.model;

import ru.roborox.itunesconnect.api.analytics.model.enums.AnalyticsDimension;

public class TimeSeriesFilter {
    private AnalyticsDimension dimensionKey;
    private String[] optionKeys;

    public TimeSeriesFilter() {
    }

    public TimeSeriesFilter(AnalyticsDimension dimensionKey, String... optionKeys) {
        this.dimensionKey = dimensionKey;
        this.optionKeys = optionKeys;
    }

    public AnalyticsDimension getDimensionKey() {
        return dimensionKey;
    }

    public void setDimensionKey(AnalyticsDimension dimensionKey) {
        this.dimensionKey = dimensionKey;
    }

    public String[] getOptionKeys() {
        return optionKeys;
    }

    public void setOptionKeys(String[] optionKeys) {
        this.optionKeys = optionKeys;
    }
}
