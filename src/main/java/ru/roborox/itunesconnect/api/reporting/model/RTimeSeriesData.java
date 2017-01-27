package ru.roborox.itunesconnect.api.reporting.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import ru.roborox.itunesconnect.api.reporting.deserializer.RTimeSeriesDataDeserializer;
import ru.roborox.itunesconnect.api.reporting.model.enums.RMeasure;

import java.util.Date;
import java.util.Map;

@JsonDeserialize(using = RTimeSeriesDataDeserializer.class)
public class RTimeSeriesData {
    private Date date;
    private Map<RMeasure, Double> data;

    public RTimeSeriesData(Date date, Map<RMeasure, Double> data) {
        this.date = date;
        this.data = data;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Map<RMeasure, Double> getData() {
        return data;
    }

    public void setData(Map<RMeasure, Double> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "RTimeSeriesData{" +
                "date=" + date +
                ", data=" + data +
                '}';
    }
}
