package ru.roborox.itunesconnect.api.reporting.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import ru.roborox.itunesconnect.api.reporting.serialize.RTimeSeriesDataDeserializer;
import ru.roborox.itunesconnect.api.reporting.model.enums.RMeasure;
import ru.roborox.itunesconnect.api.reporting.serialize.RTimeSeriesDataSerializer;

import java.util.Date;
import java.util.Map;

@JsonDeserialize(using = RTimeSeriesDataDeserializer.class)
@JsonSerialize(using = RTimeSeriesDataSerializer.class)
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
