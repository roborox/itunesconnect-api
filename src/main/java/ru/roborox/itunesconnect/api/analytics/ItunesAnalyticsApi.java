package ru.roborox.itunesconnect.api.analytics;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.roborox.itunesconnect.api.analytics.model.*;
import ru.roborox.itunesconnect.api.common.AbstractAppleApi;
import ru.roborox.itunesconnect.api.login.ConnectTokens;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.stream.Collectors;

import static ru.roborox.itunesconnect.api.common.Utils.*;

/**
 * analytics.itunes.apple.com java api
 */
public class ItunesAnalyticsApi extends AbstractAppleApi {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    static {
        objectMapper.setDateFormat(createDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'"));
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public ItunesAnalyticsApi(ConnectTokens tokens, String analyticsUrl, boolean log) throws MalformedURLException {
        super(createExecutor(createBasicCookieStore(tokens)), objectMapper, analyticsUrl, log);
    }

    public UserInfo getUserInfo() throws IOException {
        return execute(get("/settings/user-info"), UserInfo.class);
    }

    public AppResponse getApps() throws IOException {
        return execute(get("/app-info/app"), AppResponse.class);
    }

    public void setProvider(String providerId) throws IOException {
        execute(get("/settings/provider/" + providerId));
    }

    public MeasuresResponse getMeasures(MeasuresRequest request) throws IOException {
        final MeasuresResponse response = execute(post("/data/app/detail/measures", request), MeasuresResponse.class);
        if (response.getResults() != null) {
            for (Measures measures : response.getResults()) {
                if (measures.getData() != null) {
                    measures.setData(measures.getData().stream().filter(d -> d.getValue() != -1).collect(Collectors.toList()));
                }
            }
        }
        return response;
    }

    public TimeSeriesResponse getTimeSeries(TimeSeriesRequest request) throws IOException {
        final TimeSeriesResponse response = execute(post("/data/time-series", request), TimeSeriesResponse.class);
        if (response.getResults() != null) {
            for (TimeSeriesData data : response.getResults()) {
                data.setData(data.getData().stream().filter(d -> d.getValue() != -1).collect(Collectors.toList()));
            }
        }
        return response;
    }
}
