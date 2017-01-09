package ru.roborox.itunesconnect.api.analytics.model;

public class AppResponse extends ApiList<App> {
    public AppResponse() {
    }

    public AppResponse(int size, App... results) {
        super(size, results);
    }
}
