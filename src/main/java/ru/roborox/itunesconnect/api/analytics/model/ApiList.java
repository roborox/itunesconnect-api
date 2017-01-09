package ru.roborox.itunesconnect.api.analytics.model;

import java.util.Arrays;
import java.util.List;

public class ApiList<T> {
    private int size;
    private List<T> results;

    public ApiList() {
    }

    public ApiList(int size, T... results) {
        this.size = size;
        this.results = Arrays.asList(results);
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<T> getResults() {
        return results;
    }

    public void setResults(List<T> results) {
        this.results = results;
    }
}
