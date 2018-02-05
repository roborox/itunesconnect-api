package ru.roborox.itunesconnect.api.reporting.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Map;

import ru.roborox.itunesconnect.api.reporting.model.enums.CubeApiType;
import ru.roborox.itunesconnect.api.reporting.model.enums.Interval;
import ru.roborox.itunesconnect.api.reporting.model.enums.RDimension;
import ru.roborox.itunesconnect.api.reporting.model.enums.RMeasureType;
import ru.roborox.itunesconnect.api.reporting.model.enums.RSort;

public class RTimeSeriesRequest {
    private CubeApiType cubeApiType = CubeApiType.TIMESERIES;
    private RPeriod interval;
    private RDimension[] group;
    private RSort sorting;
    private int limit;
    private RMeasure[] measures;
    private RTimeSeriesFilter[] filters;
    private String[] order = new String[0];
    private Map<String, Object> optionalParams = Collections.EMPTY_MAP;

    public RTimeSeriesRequest() {
    }

    public RTimeSeriesRequest(RPeriod interval, RDimension[] group, RSort sorting, int limit, RMeasure[] measures,
            RTimeSeriesFilter[] filters) {
        this.interval = interval;
        this.group = group;
        this.sorting = sorting;
        this.limit = limit;
        this.measures = measures;
        this.filters = filters;
    }

    public RTimeSeriesRequest(Interval interval, RDimension group, Date startDate, Date endDate, RSort sort, int limit,
            RTimeSeriesFilter filter, RMeasureType... measures) {
        this(new RPeriod(interval, startDate, endDate), new RDimension[] { group }, sort, limit,
                Arrays.stream(measures).map(RMeasure::new).toArray(RMeasure[]::new),
                new RTimeSeriesFilter[] { filter });
    }

    public CubeApiType getCubeApiType() {
        return cubeApiType;
    }

    public void setCubeApiType(CubeApiType cubeApiType) {
        this.cubeApiType = cubeApiType;
    }

    public RSort getSorting() {
        return sorting;
    }

    public void setSorting(RSort sorting) {
        this.sorting = sorting;
    }

    public Map<String, Object> getOptionalParams() {
        return optionalParams;
    }

    public void setOptionalParams(Map<String, Object> optionalParams) {
        this.optionalParams = optionalParams;
    }

    public String[] getOrder() {
        return order;
    }

    public void setOrder(String[] order) {
        this.order = order;
    }

    public RDimension[] getGroup() {
        return group;
    }

    public void setGroup(RDimension[] group) {
        this.group = group;
    }

    public RTimeSeriesFilter[] getFilters() {
        return filters;
    }

    public void setFilters(RTimeSeriesFilter[] filters) {
        this.filters = filters;
    }

    public RPeriod getInterval() {
        return interval;
    }

    public void setInterval(RPeriod interval) {
        this.interval = interval;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public RMeasure[] getMeasures() {
        return measures;
    }

    public void setMeasures(RMeasure[] measures) {
        this.measures = measures;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cubeApiType == null) ? 0 : cubeApiType.hashCode());
        result = prime * result + Arrays.hashCode(filters);
        result = prime * result + Arrays.hashCode(group);
        result = prime * result + ((interval == null) ? 0 : interval.hashCode());
        result = prime * result + limit;
        result = prime * result + Arrays.hashCode(measures);
        result = prime * result + ((optionalParams == null) ? 0 : optionalParams.hashCode());
        result = prime * result + Arrays.hashCode(order);
        result = prime * result + ((sorting == null) ? 0 : sorting.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        RTimeSeriesRequest other = (RTimeSeriesRequest) obj;
        if (cubeApiType != other.cubeApiType)
            return false;
        if (!Arrays.equals(filters, other.filters))
            return false;
        if (!Arrays.equals(group, other.group))
            return false;
        if (interval == null) {
            if (other.interval != null)
                return false;
        } else if (!interval.equals(other.interval))
            return false;
        if (limit != other.limit)
            return false;
        if (!Arrays.equals(measures, other.measures))
            return false;
        if (optionalParams == null) {
            if (other.optionalParams != null)
                return false;
        } else if (!optionalParams.equals(other.optionalParams))
            return false;
        if (!Arrays.equals(order, other.order))
            return false;
        if (sorting != other.sorting)
            return false;
        return true;
    }
}
