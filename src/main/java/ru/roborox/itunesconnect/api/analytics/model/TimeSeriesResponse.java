package ru.roborox.itunesconnect.api.analytics.model;

public class TimeSeriesResponse extends ApiList<TimeSeriesData> {
    public TimeSeriesResponse() {
    }

    public TimeSeriesResponse(int size, TimeSeriesData... results) {
        super(size, results);
    }
}
