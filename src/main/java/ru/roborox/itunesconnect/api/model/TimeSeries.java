package ru.roborox.itunesconnect.api.model;

import java.util.List;

public class TimeSeries {
    private String adamId;
    private boolean meetsThreshold;
    private String group;
    private List<TimeSeriesData> data;
    private TimeSeriesTotals totals;

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

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public List<TimeSeriesData> getData() {
        return data;
    }

    public void setData(List<TimeSeriesData> data) {
        this.data = data;
    }

    public TimeSeriesTotals getTotals() {
        return totals;
    }

    public void setTotals(TimeSeriesTotals totals) {
        this.totals = totals;
    }
}
