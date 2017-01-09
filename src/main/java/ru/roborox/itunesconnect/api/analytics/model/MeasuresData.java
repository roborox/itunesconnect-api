package ru.roborox.itunesconnect.api.analytics.model;

import java.util.Date;

public class MeasuresData {
    private Date date;
    private double value;

    public MeasuresData() {
    }

    public MeasuresData(Date date, double value) {
        this.date = date;
        this.value = value;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
