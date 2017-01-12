package ru.roborox.itunesconnect.api.analytics.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import ru.roborox.itunesconnect.api.analytics.deserializer.TimeSeriesItemDeserializer;
import ru.roborox.itunesconnect.api.analytics.model.enums.AnalyticsMeasure;

import java.util.Date;

@JsonDeserialize(using = TimeSeriesItemDeserializer.class)
public class TimeSeriesItem {
    private Date date;
    private AnalyticsMeasure measure;
    private Double value;

    public TimeSeriesItem(Date date, AnalyticsMeasure measure, Double value) {
        this.date = date;
        this.measure = measure;
        this.value = value;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public AnalyticsMeasure getMeasure() {
        return measure;
    }

    public void setMeasure(AnalyticsMeasure measure) {
        this.measure = measure;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "item{" +
                "date=" + date +
                ", measure=" + measure +
                ", value=" + value +
                '}';
    }
}
