package ru.roborox.itunesconnect.api.analytics.model;

import java.util.List;

public class TimeSeriesData {
    private String adamId;
    private boolean meetsThreshold;
    private TimeSeriesDataGroup group;
    private List<TimeSeriesItem> data;

    public TimeSeriesData() {
    }

    public TimeSeriesData(String adamId, boolean meetsThreshold, TimeSeriesDataGroup group, List<TimeSeriesItem> data) {
        this.adamId = adamId;
        this.meetsThreshold = meetsThreshold;
        this.group = group;
        this.data = data;
    }

    public String getAdamId() {
        return adamId;
    }

    public void setAdamId(String adamId) {
        this.adamId = adamId;
    }

    public boolean isMeetsThreshold() {
        return meetsThreshold;
    }

    public void setMeetsThreshold(boolean meetsThreshold) {
        this.meetsThreshold = meetsThreshold;
    }

    public TimeSeriesDataGroup getGroup() {
        return group;
    }

    public void setGroup(TimeSeriesDataGroup group) {
        this.group = group;
    }

    public List<TimeSeriesItem> getData() {
        return data;
    }

    public void setData(List<TimeSeriesItem> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "data{" +
                "adamId='" + adamId + '\'' +
                ", group=" + group +
                ", data=" + data +
                '}';
    }
}
