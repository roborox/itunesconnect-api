package ru.roborox.itunesconnect.api.analytics.model;

import ru.roborox.itunesconnect.api.analytics.model.enums.Dimension;
import ru.roborox.itunesconnect.api.analytics.model.enums.Measure;
import ru.roborox.itunesconnect.api.common.Sort;

public class TimeSeriesGroup {
    private Measure metric;
    private Dimension dimension;
    private Sort rank;
    private int limit;

    public TimeSeriesGroup() {
    }

    public TimeSeriesGroup(Measure metric, Dimension dimension, Sort rank, int limit) {
        this.metric = metric;
        this.dimension = dimension;
        this.rank = rank;
        this.limit = limit;
    }

    public Measure getMetric() {
        return metric;
    }

    public void setMetric(Measure metric) {
        this.metric = metric;
    }

    public Dimension getDimension() {
        return dimension;
    }

    public void setDimension(Dimension dimension) {
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
