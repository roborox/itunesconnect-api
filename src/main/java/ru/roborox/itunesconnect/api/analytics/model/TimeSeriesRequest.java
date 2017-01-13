package ru.roborox.itunesconnect.api.analytics.model;

import ru.roborox.itunesconnect.api.analytics.model.enums.Measure;
import ru.roborox.itunesconnect.api.analytics.model.enums.Period;

import java.util.Date;

public class TimeSeriesRequest extends MeasuresRequest {
    private TimeSeriesGroup group;
    private TimeSeriesFilter[] dimensionFilters;

    public TimeSeriesRequest() {
    }

    public TimeSeriesRequest(String adamId, Period frequency, Measure measure, Date startTime, Date endTime, TimeSeriesGroup group, TimeSeriesFilter... dimensionFilters) {
        super(adamId, frequency, new Measure[]{measure}, startTime, endTime);
        this.group = group;
        this.dimensionFilters = dimensionFilters;
    }

    public TimeSeriesGroup getGroup() {
        return group;
    }

    public void setGroup(TimeSeriesGroup group) {
        this.group = group;
    }

    public TimeSeriesFilter[] getDimensionFilters() {
        return dimensionFilters;
    }

    public void setDimensionFilters(TimeSeriesFilter[] dimensionFilters) {
        this.dimensionFilters = dimensionFilters;
    }
}
