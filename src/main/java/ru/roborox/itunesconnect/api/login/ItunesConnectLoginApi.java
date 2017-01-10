package ru.roborox.itunesconnect.api.login;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.CookieStore;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.fluent.Executor;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.cookie.ClientCookie;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieSpecProvider;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.impl.cookie.BrowserCompatSpecFactory;
import ru.roborox.itunesconnect.api.Const;
import ru.roborox.itunesconnect.api.analytics.model.AuthServiceConfig;
import ru.roborox.itunesconnect.api.analytics.model.SigninRequest;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

public class ItunesConnectLoginApi {
    public static final String SIGNIN_PATH = "/auth/signin";
    public static final String APP_CONFIG_PATH = "/app/config";
    public static final String SESSION_PATH = "/session";

    private final ObjectMapper objectMapper = new ObjectMapper();
    private final String itunesConnectHostname;
    private final String olympusUrl;

    public ItunesConnectLoginApi(String itunesConnectHostname, String olympusUrl) {
        this.itunesConnectHostname = itunesConnectHostname;
        this.olympusUrl = olympusUrl;
    }

    public ConnectTokens login(String login, String password) throws IOException, URISyntaxException {
        final TokensCookieStore cookieStore = new TokensCookieStore();
        final Executor executor = createExecutor(cookieStore);
        connect(executor, login, password);
        final Optional<ConnectTokens> result = cookieStore.getTokens();
        if (result.isPresent()) {
            return result.get();
        } else {
            throw new IOException("Unable to login: needed cookies not found");
        }
    }

    public Executor createExecutor(ConnectTokens tokens) throws MalformedURLException {
        @SuppressWarnings("deprecation") final Registry<CookieSpecProvider> cookieSpecRegistry =
                RegistryBuilder.<CookieSpecProvider>create().register(CookieSpecs.DEFAULT, new BrowserCompatSpecFactory()).build();
        final CloseableHttpClient client = HttpClients.custom().setDefaultCookieSpecRegistry(cookieSpecRegistry).build();
        return Executor.newInstance(client).use(createCookieStore(tokens));
    }

    private CookieStore createCookieStore(ConnectTokens tokens) throws MalformedURLException {
        final CookieStore store = new BasicCookieStore();
        store.addCookie(createCookie("itctx", tokens.getItctx()));
        store.addCookie(createCookie("myacinfo", tokens.getMyacinfo()));
        return store;
    }

    private Cookie createCookie(String name, String value) throws MalformedURLException {
        final BasicClientCookie cookie = new BasicClientCookie(name, value);
        cookie.setAttribute(ClientCookie.DOMAIN_ATTR, Const.COOKIE_DOMAIN);
        cookie.setPath("/");
        cookie.setDomain(Const.COOKIE_DOMAIN);
        return cookie;
    }

    private void connect(Executor executor, String login, String password) throws IOException, URISyntaxException {
        final AuthServiceConfig config = getConfig(executor);
        signin(executor, config.getAuthServiceUrl(), config.getAuthServiceKey(), login, password);
        session(executor);
    }

    private void signin(Executor executor, String authServiceUrl, String authServiceKey, String login, String password) throws IOException {
        final SigninRequest request = new SigninRequest(login, password, false);
        executor.execute(Request.Post(authServiceUrl + SIGNIN_PATH).bodyString(objectMapper.writeValueAsString(request), ContentType.APPLICATION_JSON).addHeader("X-Apple-Widget-Key", authServiceKey));
    }

    private void session(Executor executor) throws IOException {
        executor.execute(Request.Get(olympusUrl + SESSION_PATH));
    }

    private AuthServiceConfig getConfig(Executor executor) throws URISyntaxException, IOException {
        final URI configUrl = new URIBuilder(olympusUrl + APP_CONFIG_PATH).addParameter("hostname", itunesConnectHostname).build();
        return objectMapper.readValue(executor.execute(Request.Get(configUrl)).returnContent().asString(), AuthServiceConfig.class);
    }

    private Executor createExecutor(CookieStore cookieStore) {
        @SuppressWarnings("deprecation") final Registry<CookieSpecProvider> cookieSpecRegistry =
                RegistryBuilder.<CookieSpecProvider>create().register(CookieSpecs.DEFAULT, new BrowserCompatSpecFactory()).build();
        final CloseableHttpClient client = HttpClients.custom().setDefaultCookieSpecRegistry(cookieSpecRegistry).setDefaultCookieStore(cookieStore).build();
        return Executor.newInstance(client);
    }
}
