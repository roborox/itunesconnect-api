package ru.roborox.itunesconnect.api.model;

import ru.roborox.itunesconnect.api.model.enums.Period;
import ru.roborox.itunesconnect.api.model.enums.MeasureType;

import java.util.Date;

public class MeasuresRequest {
    private String[] adamId;
    private Period frequency;
    private MeasureType[] measures;
    private Date startTime;
    private Date endTime;

    public MeasuresRequest() {
    }

    public MeasuresRequest(String[] adamId, Period frequency, MeasureType[] measures, Date startTime, Date endTime) {
        this.adamId = adamId;
        this.frequency = frequency;
        this.measures = measures;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String[] getAdamId() {
        return adamId;
    }

    public void setAdamId(String[] adamId) {
        this.adamId = adamId;
    }

    public Period getFrequency() {
        return frequency;
    }

    public void setFrequency(Period frequency) {
        this.frequency = frequency;
    }

    public MeasureType[] getMeasures() {
        return measures;
    }

    public void setMeasures(MeasureType[] measures) {
        this.measures = measures;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
