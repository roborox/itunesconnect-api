package ru.roborox.itunesconnect.api.reporting.model;

import java.util.Arrays;

import ru.roborox.itunesconnect.api.reporting.model.enums.RDimension;

public class RTimeSeriesFilter {
    private RDimension dimensionKey;
    private String[] optionKeys;

    public RTimeSeriesFilter() {
    }

    public RTimeSeriesFilter(RDimension dimensionKey, String... optionKeys) {
        this.dimensionKey = dimensionKey;
        this.optionKeys = optionKeys;
    }

    public RDimension getDimensionKey() {
        return dimensionKey;
    }

    public void setDimensionKey(RDimension dimensionKey) {
        this.dimensionKey = dimensionKey;
    }

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

        RTimeSeriesFilter that = (RTimeSeriesFilter) o;

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
