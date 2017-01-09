package ru.roborox.itunesconnect.api.reporting.model;

import java.util.Arrays;

public class TimeSeriesResponse {
    private TimeSeriesMetadata metadata;
    private TimeSeriesData[] data;

    public TimeSeriesMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(TimeSeriesMetadata metadata) {
        this.metadata = metadata;
    }

    public TimeSeriesData[] getData() {
        return data;
    }

    public void setData(TimeSeriesData[] data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "TimeSeriesResponse{" +
                "data=" + Arrays.toString(data) +
                '}';
    }
}
