package ru.roborox.itunesconnect.api.model;

import ru.roborox.itunesconnect.api.model.enums.Period;
import ru.roborox.itunesconnect.api.model.enums.TimeSeriesMeasure;

import java.util.Date;

public class TimeSeriesRequest {
    private String[] adamId;
    private Period frequency;
    private TimeSeriesMeasure[] measures;
    private String group;
    private String[] dimensionFilters = new String[0];
    private Date startTime;
    private Date endTime;

    public TimeSeriesRequest() {
    }

    public TimeSeriesRequest(String adamId, Period frequency, TimeSeriesMeasure[] measures, Date startTime, Date endTime) {
        this.adamId = new String[]{adamId};
        this.frequency = frequency;
        this.measures = measures;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String[] getAdamId() {
        return adamId;
    }

    public void setAdamId(String[] adamId) {
        this.adamId = adamId;
    }

    public Period getFrequency() {
        return frequency;
    }

    public void setFrequency(Period frequency) {
        this.frequency = frequency;
    }

    public TimeSeriesMeasure[] getMeasures() {
        return measures;
    }

    public void setMeasures(TimeSeriesMeasure[] measures) {
        this.measures = measures;
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

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
