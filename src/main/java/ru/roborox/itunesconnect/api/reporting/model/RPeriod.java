package ru.roborox.itunesconnect.api.reporting.model;

import java.util.Date;

import ru.roborox.itunesconnect.api.reporting.model.enums.Interval;

public class RPeriod {
    private Interval key;
    private Date startDate;
    private Date endDate;
    
    public RPeriod(Interval key, Date startDate, Date endDate) {
        this.key = key;
        this.startDate = startDate;
        this.endDate = endDate;
    }
    
    public RPeriod() {
    }

    public Interval getKey() {
        return key;
    }

    public void setKey(Interval key) {
        this.key = key;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

}
