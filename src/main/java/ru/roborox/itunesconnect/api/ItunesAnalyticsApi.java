package ru.roborox.itunesconnect.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.CookieStore;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.fluent.Executor;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Response;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieSpecProvider;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.impl.cookie.BrowserCompatSpecFactory;
import ru.roborox.itunesconnect.api.login.ConnectTokens;
import ru.roborox.itunesconnect.api.model.AppResponse;
import ru.roborox.itunesconnect.api.model.MeasuresRequest;
import ru.roborox.itunesconnect.api.model.MeasuresResponse;
import ru.roborox.itunesconnect.api.model.UserInfo;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

/**
 * analytics.itunes.apple.com java api
 * NOT THREAD SAFE
 */
public class ItunesAnalyticsApi {
    private final ObjectMapper objectMapper;
    private final Executor executor;

    private final String analyticsUrl;

    public ItunesAnalyticsApi(String analyticsUrl, ConnectTokens tokens) throws MalformedURLException {
        this.analyticsUrl = analyticsUrl;

        this.objectMapper = new ObjectMapper();
        final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        this.objectMapper.setDateFormat(dateFormat);
        this.executor = createExecutor(createCookieStore(tokens));
    }

    private CookieStore createCookieStore(ConnectTokens tokens) throws MalformedURLException {
        final CookieStore store = new BasicCookieStore();
        store.addCookie(createCookie("itctx", tokens.getItctx()));
        store.addCookie(createCookie("myacinfo", tokens.getMyacinfo()));
        return store;
    }

    private Cookie createCookie(String name, String value) throws MalformedURLException {
        final BasicClientCookie cookie = new BasicClientCookie(name, value);
        cookie.setPath("/");
        cookie.setDomain(new URL(analyticsUrl).getHost());
        return cookie;
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
        return executor.execute(request
                //.addHeader("Cookie", "itctx=" + tokens.getItctx() + ";myacinfo" + "=" + tokens.getMyacinfo())
                .addHeader("X-Requested-By", "analytics.itunes.apple.com")
                .addHeader("Accept", "application/json, text/plain, */*"));
    }

    private Executor createExecutor(CookieStore cookieStore) {
        @SuppressWarnings("deprecation") final Registry<CookieSpecProvider> cookieSpecRegistry =
                RegistryBuilder.<CookieSpecProvider>create().register(CookieSpecs.DEFAULT, new BrowserCompatSpecFactory()).build();
        final CloseableHttpClient client = HttpClients.custom().setDefaultCookieSpecRegistry(cookieSpecRegistry).build();
        return Executor.newInstance(client).use(cookieStore);
    }
}
