package ru.roborox.itunesconnect.api.model;

public class TimeSeriesResponse extends ApiList<TimeSeries> {
    public TimeSeriesResponse() {
    }

    public TimeSeriesResponse(int size, TimeSeries... results) {
        super(size, results);
    }
}
