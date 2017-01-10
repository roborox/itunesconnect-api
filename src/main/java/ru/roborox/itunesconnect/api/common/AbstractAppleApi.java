package ru.roborox.itunesconnect.api.common;

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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.roborox.itunesconnect.api.Const;
import ru.roborox.itunesconnect.api.login.ConnectTokens;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

public class AbstractAppleApi {
    protected final Logger logger = LoggerFactory.getLogger(AbstractAppleApi.class);

    private final ObjectMapper objectMapper;
    private final Executor executor;
    private final String url;
    private final boolean log;

    public AbstractAppleApi(String url, ConnectTokens tokens, String dateFormatString, boolean log) throws MalformedURLException {
        this.url = url;
        this.log = log;

        this.objectMapper = new ObjectMapper();
        final SimpleDateFormat dateFormat = new SimpleDateFormat(dateFormatString);
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
        cookie.setDomain(new URL(url).getHost());
        return cookie;
    }

    protected <T> T execute(Request request, Class<T> tClass) throws IOException {
        final String content = new String(execute(request).returnContent().asBytes(), Const.UTF_8);
        if (log) {
            logger.info("for {} content={}", request, content);
        }
        return objectMapper.readValue(content, tClass);
    }

    protected Request get(String path) {
        return Request.Get(url + path);
    }

    protected Request post(String path, Object request) throws JsonProcessingException {
        return Request.Post(url + path).bodyString(objectMapper.writeValueAsString(request), ContentType.APPLICATION_JSON);
    }

    protected Response execute(Request request) throws IOException {
        return executor.execute(request
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
