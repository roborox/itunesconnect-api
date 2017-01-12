package ru.roborox.itunesconnect.api.analytics.model;

import ru.roborox.itunesconnect.api.analytics.model.enums.AnalyticsDimension;
import ru.roborox.itunesconnect.api.analytics.model.enums.AnalyticsMeasure;
import ru.roborox.itunesconnect.api.common.Sort;

public class TimeSeriesGroup {
    private AnalyticsMeasure metric;
    private AnalyticsDimension dimension;
    private Sort rank;
    private int limit;

    public TimeSeriesGroup() {
    }

    public TimeSeriesGroup(AnalyticsMeasure metric, AnalyticsDimension dimension, Sort rank, int limit) {
        this.metric = metric;
        this.dimension = dimension;
        this.rank = rank;
        this.limit = limit;
    }

    public AnalyticsMeasure getMetric() {
        return metric;
    }

    public void setMetric(AnalyticsMeasure metric) {
        this.metric = metric;
    }

    public AnalyticsDimension getDimension() {
        return dimension;
    }

    public void setDimension(AnalyticsDimension dimension) {
        this.dimension = dimension;
    }

    public Sort getRank() {
        return rank;
    }

    public void setRank(Sort rank) {
        this.rank = rank;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
