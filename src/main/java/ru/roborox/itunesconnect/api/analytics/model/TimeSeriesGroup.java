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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TimeSeriesGroup that = (TimeSeriesGroup) o;

        if (limit != that.limit) return false;
        if (metric != that.metric) return false;
        if (dimension != that.dimension) return false;
        return rank == that.rank;
    }

    @Override
    public int hashCode() {
        int result = metric != null ? metric.hashCode() : 0;
        result = 31 * result + (dimension != null ? dimension.hashCode() : 0);
        result = 31 * result + (rank != null ? rank.hashCode() : 0);
        result = 31 * result + limit;
        return result;
    }
}
