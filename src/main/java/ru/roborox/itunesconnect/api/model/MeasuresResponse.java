package ru.roborox.itunesconnect.api.model;

public class MeasuresResponse extends ApiList<Measures> {
    public MeasuresResponse() {
    }

    public MeasuresResponse(int size, Measures... results) {
        super(size, results);
    }
}
