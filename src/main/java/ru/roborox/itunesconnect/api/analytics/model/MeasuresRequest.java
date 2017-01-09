package ru.roborox.itunesconnect.api.analytics.model;

import ru.roborox.itunesconnect.api.analytics.model.enums.MeasureType;
import ru.roborox.itunesconnect.api.analytics.model.enums.Period;

import java.util.Arrays;
import java.util.Date;

public class MeasuresRequest {
    private String[] adamId;
    private Period frequency;
    private MeasureType[] measures;
    private Date startTime;
    private Date endTime;

    public MeasuresRequest() {
    }

    public MeasuresRequest(String adamId, Period frequency, MeasureType[] measures, Date startTime, Date endTime) {
        this.adamId = new String[]{adamId};
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MeasuresRequest that = (MeasuresRequest) o;

        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        if (!Arrays.equals(adamId, that.adamId)) return false;
        if (frequency != that.frequency) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        if (!Arrays.equals(measures, that.measures)) return false;
        if (!startTime.equals(that.startTime)) return false;
        return endTime.equals(that.endTime);
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(adamId);
        result = 31 * result + frequency.hashCode();
        result = 31 * result + Arrays.hashCode(measures);
        result = 31 * result + startTime.hashCode();
        result = 31 * result + endTime.hashCode();
        return result;
    }
}
