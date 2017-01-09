package ru.roborox.itunesconnect.api.reporting;

import ru.roborox.itunesconnect.api.common.AbstractAppleApi;
import ru.roborox.itunesconnect.api.login.ConnectTokens;
import ru.roborox.itunesconnect.api.reporting.model.TimeSeriesRequest;
import ru.roborox.itunesconnect.api.reporting.model.TimeSeriesResponse;

import java.io.IOException;
import java.net.MalformedURLException;

public class ReportingApi extends AbstractAppleApi {
    public static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";

    public ReportingApi(String url, ConnectTokens tokens) throws MalformedURLException {
        super(url, tokens, DATE_FORMAT);
    }

    public TimeSeriesResponse getTimeSeries(TimeSeriesRequest request) throws IOException {
        return execute(post("/data/timeseries", request), TimeSeriesResponse[].class)[0];
    }
}
