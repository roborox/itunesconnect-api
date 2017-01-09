package ru.roborox.itunesconnect.api.analytics.model;

public class MeasuresResponse extends ApiList<Measures> {
    public MeasuresResponse() {
    }

    public MeasuresResponse(int size, Measures... results) {
        super(size, results);
    }
}
