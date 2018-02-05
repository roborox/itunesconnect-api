package ru.roborox.itunesconnect.api.reporting.model;

import java.util.Arrays;

public class RTimeSeries {
    private TimeSeriesMetadata[] metadata;
    private RTimeSeriesData[] data;

    public TimeSeriesMetadata[] getMetadata() {
        return metadata;
    }

    public void setMetadata(TimeSeriesMetadata[] metadata) {
        this.metadata = metadata;
    }

    public RTimeSeriesData[] getData() {
        return data;
    }

    public void setData(RTimeSeriesData[] data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "RTimeSeriesResponse{" +
                "data=" + Arrays.toString(data) +
                '}';
    }
}
