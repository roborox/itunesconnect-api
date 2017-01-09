package ru.roborox.itunesconnect.api.analytics;

import ru.roborox.itunesconnect.api.common.AbstractAppleApi;
import ru.roborox.itunesconnect.api.login.ConnectTokens;
import ru.roborox.itunesconnect.api.analytics.model.*;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.stream.Collectors;

/**
 * analytics.itunes.apple.com java api
 * NOT THREAD SAFE
 */
public class ItunesAnalyticsApi extends AbstractAppleApi {

    public ItunesAnalyticsApi(String analyticsUrl, ConnectTokens tokens) throws MalformedURLException {
        super(analyticsUrl, tokens, "yyyy-MM-dd'T'HH:mm:ss'Z'");
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
}
