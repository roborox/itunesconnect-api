package ru.roborox.itunesconnect.api.reporting;

import ru.roborox.itunesconnect.api.common.AbstractAppleApi;
import ru.roborox.itunesconnect.api.login.ConnectTokens;
import ru.roborox.itunesconnect.api.reporting.model.TimeSeriesRequest;
import ru.roborox.itunesconnect.api.reporting.model.TimeSeriesResponse;

import java.io.IOException;
import java.net.MalformedURLException;

public class ReportingApi extends AbstractAppleApi {
    public static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";

    public ReportingApi(String url, ConnectTokens tokens, boolean log) throws MalformedURLException {
        super(url, tokens, DATE_FORMAT, log);
    }

    public TimeSeriesResponse getTimeSeries(TimeSeriesRequest request) throws IOException {
        final TimeSeriesResponse[] result = execute(post("/data/timeseries", request), TimeSeriesResponse[].class);
        if (result.length > 0) {
            return result[0];
        } else {
            return null;
        }
    }
}
