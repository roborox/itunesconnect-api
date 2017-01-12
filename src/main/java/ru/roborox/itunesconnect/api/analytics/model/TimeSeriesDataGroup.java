package ru.roborox.itunesconnect.api.analytics.model;

public class TimeSeriesDataGroup {
    private String key;
    private String title;

    public TimeSeriesDataGroup() {
    }

    public TimeSeriesDataGroup(String key, String title) {
        this.key = key;
        this.title = title;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "group{" +
                "key='" + key + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
