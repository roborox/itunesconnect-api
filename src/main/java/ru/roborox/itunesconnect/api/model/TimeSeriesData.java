package ru.roborox.itunesconnect.api.model;

import java.util.Date;

public class TimeSeriesData {
    private Date date;
    private Integer pageViewUnique;
    private Integer impressionsTotalUnique;
    private Integer sales;
    private Integer units;
    private Integer payingUsers;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getPageViewUnique() {
        return pageViewUnique;
    }

    public void setPageViewUnique(Integer pageViewUnique) {
        this.pageViewUnique = pageViewUnique;
    }

    public Integer getImpressionsTotalUnique() {
        return impressionsTotalUnique;
    }

    public void setImpressionsTotalUnique(Integer impressionsTotalUnique) {
        this.impressionsTotalUnique = impressionsTotalUnique;
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    public Integer getUnits() {
        return units;
    }

    public void setUnits(Integer units) {
        this.units = units;
    }

    public Integer getPayingUsers() {
        return payingUsers;
    }

    public void setPayingUsers(Integer payingUsers) {
        this.payingUsers = payingUsers;
    }
}
