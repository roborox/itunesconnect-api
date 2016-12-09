package ru.roborox.itunesconnect.api.model;

import ru.roborox.itunesconnect.api.model.enums.Period;
import ru.roborox.itunesconnect.api.model.enums.MeasureType;

import java.util.Date;

public class TimeSeriesRequest extends MeasuresRequest {
    private String group;
    private String[] dimensionFilters;

    public TimeSeriesRequest() {
    }

    public TimeSeriesRequest(String[] adamId, Period frequency, MeasureType[] measures, Date startTime, Date endTime, String group, String[] dimensionFilters) {
        super(adamId, frequency, measures, startTime, endTime);
        this.group = group;
        this.dimensionFilters = dimensionFilters;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String[] getDimensionFilters() {
        return dimensionFilters;
    }

    public void setDimensionFilters(String[] dimensionFilters) {
        this.dimensionFilters = dimensionFilters;
    }
}
