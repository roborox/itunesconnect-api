package ru.roborox.itunesconnect.api.reporting.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import ru.roborox.itunesconnect.api.reporting.deserializer.TimeSeriesDataDeserializer;
import ru.roborox.itunesconnect.api.reporting.model.enums.ReportingMeasure;

import java.util.Date;
import java.util.Map;

@JsonDeserialize(using = TimeSeriesDataDeserializer.class)
public class TimeSeriesData {
    private Date date;
    private Map<ReportingMeasure, Double> data;

    public TimeSeriesData(Date date, Map<ReportingMeasure, Double> data) {
        this.date = date;
        this.data = data;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Map<ReportingMeasure, Double> getData() {
        return data;
    }

    public void setData(Map<ReportingMeasure, Double> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "TimeSeriesData{" +
                "date=" + date +
                ", data=" + data +
                '}';
    }
}
