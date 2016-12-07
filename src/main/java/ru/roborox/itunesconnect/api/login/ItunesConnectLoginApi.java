package ru.roborox.itunesconnect.api.login;

import org.apache.commons.lang3.tuple.Pair;
import org.apache.http.client.CookieStore;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.fluent.Executor;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.cookie.CookieSpecProvider;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.cookie.BrowserCompatSpecFactory;
import org.json.JSONObject;
import ru.roborox.itunesconnect.api.Const;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

public class ItunesConnectLoginApi {

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

    private void connect(Executor executor, String login, String password) throws IOException, URISyntaxException {
        final Pair<String, String> config = getConfig(executor);
        signin(executor, config.getRight(), config.getLeft(), login, password);
        session(executor);
    }

    private void signin(Executor executor, String authServiceUrl, String authServiceKey, String login, String password) throws IOException {
        final JSONObject signinData = new JSONObject()
                .put("accountName", login)
                .put("password", password)
                .put("rememberMe", false);
        executor.execute(Request.Post(authServiceUrl + Const.SIGNIN_PATH).bodyString(signinData.toString(), ContentType.APPLICATION_JSON).addHeader("X-Apple-Widget-Key", authServiceKey));
    }

    private void session(Executor executor) throws IOException {
        executor.execute(Request.Get(Const.OLYMPUS_URL + Const.SESSION_PATH));
    }

    private Pair<String, String> getConfig(Executor executor) throws URISyntaxException, IOException {
        final URI configUrl = new URIBuilder(Const.OLYMPUS_URL + Const.APP_CONFIG_PATH).addParameter("hostname", Const.ITUNESCONNECT_HOSTNAME).build();
        final JSONObject config = new JSONObject(executor.execute(Request.Get(configUrl)).returnContent().asString());
        return Pair.of(config.getString("authServiceKey"), config.getString("authServiceUrl"));
    }

    private Executor createExecutor(CookieStore cookieStore) {
        @SuppressWarnings("deprecation") final Registry<CookieSpecProvider> cookieSpecRegistry =
                RegistryBuilder.<CookieSpecProvider>create().register(CookieSpecs.DEFAULT, new BrowserCompatSpecFactory()).build();
        final CloseableHttpClient client = HttpClients.custom().setDefaultCookieSpecRegistry(cookieSpecRegistry).setDefaultCookieStore(cookieStore).build();
        return Executor.newInstance(client);
    }
}
