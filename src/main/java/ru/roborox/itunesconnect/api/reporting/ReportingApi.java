package ru.roborox.itunesconnect.api.reporting;

import static ru.roborox.itunesconnect.api.common.Utils.createDateFormat;
import static ru.roborox.itunesconnect.api.common.Utils.createExecutor;
import static ru.roborox.itunesconnect.api.common.Utils.createNotRecordingCookieStore;

import java.io.IOException;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import ru.roborox.itunesconnect.api.common.AbstractAppleApi;
import ru.roborox.itunesconnect.api.login.ConnectTokens;
import ru.roborox.itunesconnect.api.reporting.model.RTimeSeries;
import ru.roborox.itunesconnect.api.reporting.model.RTimeSeriesRequest;
import ru.roborox.itunesconnect.api.reporting.model.RTimeSeriesResponse;

public class ReportingApi extends AbstractAppleApi {
    public static final ObjectMapper objectMapper = new ObjectMapper();

    static {
        objectMapper.setDateFormat(createDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"));
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public ReportingApi(ConnectTokens tokens, String url, boolean log) throws IOException {
        super(createExecutor(createNotRecordingCookieStore(tokens)), objectMapper, url, log);
    }

    public RTimeSeries getTimeSeries(RTimeSeriesRequest request) throws IOException {
        final RTimeSeriesResponse result = execute(post("/timeseries", request), RTimeSeriesResponse.class);
        if (result.getResult() != null && result.getResult().size() > 0) {
            return result.getResult().get(0);
        } else {
            return null;
        }
    }
}
