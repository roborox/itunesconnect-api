package ru.roborox.itunesconnect.api.analytics.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import ru.roborox.itunesconnect.api.analytics.serialize.TimeSeriesItemDeserializer;
import ru.roborox.itunesconnect.api.analytics.model.enums.Measure;
import ru.roborox.itunesconnect.api.analytics.serialize.TimeSeriesItemSerializer;

import java.util.Date;

@JsonDeserialize(using = TimeSeriesItemDeserializer.class)
@JsonSerialize(using = TimeSeriesItemSerializer.class)
public class TimeSeriesItem {
    private Date date;
    private Measure measure;
    private Double value;

    public TimeSeriesItem(Date date, Measure measure, Double value) {
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

    public Measure getMeasure() {
        return measure;
    }

    public void setMeasure(Measure measure) {
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
