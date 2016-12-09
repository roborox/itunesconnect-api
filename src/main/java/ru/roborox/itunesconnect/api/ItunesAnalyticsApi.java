package ru.roborox.itunesconnect.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Response;
import org.apache.http.entity.ContentType;
import ru.roborox.itunesconnect.api.login.ConnectTokens;
import ru.roborox.itunesconnect.api.model.*;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

/**
 * analytics.itunes.apple.com java api
 * NOT THREAD SAFE
 */
public class ItunesAnalyticsApi {
    private final ObjectMapper objectMapper;
    private final String analyticsUrl;
    private final ConnectTokens tokens;

    public ItunesAnalyticsApi(String analyticsUrl, ConnectTokens tokens) {
        this.analyticsUrl = analyticsUrl;
        this.tokens = tokens;
        this.objectMapper = new ObjectMapper();
        final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        this.objectMapper.setDateFormat(dateFormat);
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

    public TimeSeriesResponse getTimeSeries(TimeSeriesRequest request) throws IOException {
        return execute(post("/data/time-series", request), TimeSeriesResponse.class);
    }

    public MeasuresResponse getMeasures(MeasuresRequest request) throws IOException {
        return execute(post("/data/app/detail/measures", request), MeasuresResponse.class);
    }

    private <T> T execute(Request request, Class<T> tClass) throws IOException {
        return objectMapper.readValue(execute(request).returnContent().asString(), tClass);
    }

    private Request get(String path) {
        return Request.Get(analyticsUrl + path);
    }

    private Request post(String path, Object request) throws JsonProcessingException {
        return Request.Post(analyticsUrl + path).bodyString(objectMapper.writeValueAsString(request), ContentType.APPLICATION_JSON);
    }

    private Response execute(Request request) throws IOException {
        return request
                .addHeader("Cookie", "itctx=" + tokens.getItctx() + ";myacinfo" + "=" + tokens.getMyacinfo())
                .addHeader("X-Requested-By", "analytics.itunes.apple.com")
                .addHeader("Accept", "application/json, text/plain, */*")
                .execute();
    }
}
