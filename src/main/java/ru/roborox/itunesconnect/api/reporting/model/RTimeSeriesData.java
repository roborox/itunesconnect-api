package ru.roborox.itunesconnect.api.reporting.model;

import java.util.Date;
import java.util.Map;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import ru.roborox.itunesconnect.api.reporting.model.enums.RMeasureType;
import ru.roborox.itunesconnect.api.reporting.serialize.RTimeSeriesDataDeserializer;
import ru.roborox.itunesconnect.api.reporting.serialize.RTimeSeriesDataSerializer;

@JsonDeserialize(using = RTimeSeriesDataDeserializer.class)
@JsonSerialize(using = RTimeSeriesDataSerializer.class)
public class RTimeSeriesData {
    private Date day;
    private Map<RMeasureType, Double> data;

    public RTimeSeriesData(Date day, Map<RMeasureType, Double> data) {
        this.day = day;
        this.data = data;
    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public Map<RMeasureType, Double> getData() {
        return data;
    }

    public void setData(Map<RMeasureType, Double> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "RTimeSeriesData{" +
                "day=" + day +
                ", data=" + data +
                '}';
    }
}
