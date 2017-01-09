package ru.roborox.itunesconnect.api.reporting.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import ru.roborox.itunesconnect.api.reporting.model.enums.Dimension;
import ru.roborox.itunesconnect.api.reporting.model.enums.Interval;
import ru.roborox.itunesconnect.api.reporting.model.enums.MeasureType;
import ru.roborox.itunesconnect.api.reporting.model.enums.Sort;

import java.util.Date;

public class TimeSeriesRequest {
    private Interval interval;
    private Dimension group;
    private Date startDate;
    private Date endDate;
    private Sort sort;
    private int limit;
    private MeasureType[] measures;
    private TimeSeriesFilter[] filters;

    public TimeSeriesRequest(Interval interval, Dimension group, Date startDate, Date endDate, Sort sort, int limit, MeasureType[] measures, TimeSeriesFilter[] filters) {
        this.interval = interval;
        this.group = group;
        this.startDate = startDate;
        this.endDate = endDate;
        this.sort = sort;
        this.limit = limit;
        this.measures = measures;
        this.filters = filters;
    }

    public TimeSeriesRequest(Interval interval, Dimension group, Date startDate, Date endDate, Sort sort, int limit, TimeSeriesFilter filter, MeasureType... measures) {
        this(interval, group, startDate, endDate, sort, limit, measures, new TimeSeriesFilter[]{filter});
    }

    public Dimension getGroup() {
        return group;
    }

    public void setGroup(Dimension group) {
        this.group = group;
    }

    public TimeSeriesFilter[] getFilters() {
        return filters;
    }

    public void setFilters(TimeSeriesFilter[] filters) {
        this.filters = filters;
    }

    public Interval getInterval() {
        return interval;
    }

    public void setInterval(Interval interval) {
        this.interval = interval;
    }

    @JsonProperty("start_date")
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @JsonProperty("end_date")
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Sort getSort() {
        return sort;
    }

    public void setSort(Sort sort) {
        this.sort = sort;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public MeasureType[] getMeasures() {
        return measures;
    }

    public void setMeasures(MeasureType[] measures) {
        this.measures = measures;
    }
}
