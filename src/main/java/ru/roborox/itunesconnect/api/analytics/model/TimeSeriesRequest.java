package ru.roborox.itunesconnect.api.analytics.model;

import ru.roborox.itunesconnect.api.analytics.model.enums.Measure;
import ru.roborox.itunesconnect.api.analytics.model.enums.Period;

import java.util.Arrays;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        TimeSeriesRequest that = (TimeSeriesRequest) o;

        if (group != null ? !group.equals(that.group) : that.group != null) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(dimensionFilters, that.dimensionFilters);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (group != null ? group.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(dimensionFilters);
        return result;
    }
}
