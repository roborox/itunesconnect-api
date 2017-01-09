package ru.roborox.itunesconnect.api.analytics.model;

import ru.roborox.itunesconnect.api.analytics.model.enums.AnalyticsMeasure;

import java.util.Arrays;
import java.util.List;

public class Measures {
    private String adamId;
    private AnalyticsMeasure measure;
    private double total;
    private String type;
    private double previousTotal;
    private double percentChange;
    private List<MeasuresData> data;
    private boolean meetsThreshold;

    public Measures() {
    }

    public Measures(AnalyticsMeasure measure, MeasuresData... data) {
        this.measure = measure;
        this.data = Arrays.asList(data);
    }

    public String getAdamId() {
        return adamId;
    }

    public void setAdamId(String adamId) {
        this.adamId = adamId;
    }

    public AnalyticsMeasure getMeasure() {
        return measure;
    }

    public void setMeasure(AnalyticsMeasure measure) {
        this.measure = measure;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPreviousTotal() {
        return previousTotal;
    }

    public void setPreviousTotal(double previousTotal) {
        this.previousTotal = previousTotal;
    }

    public double getPercentChange() {
        return percentChange;
    }

    public void setPercentChange(double percentChange) {
        this.percentChange = percentChange;
    }

    public List<MeasuresData> getData() {
        return data;
    }

    public void setData(List<MeasuresData> data) {
        this.data = data;
    }

    public boolean isMeetsThreshold() {
        return meetsThreshold;
    }

    public void setMeetsThreshold(boolean meetsThreshold) {
        this.meetsThreshold = meetsThreshold;
    }
}
