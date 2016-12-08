package ru.roborox.itunesconnect.api.model;

import java.util.List;

public class ApiList<T> {
    private int size;
    private List<T> results;

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
