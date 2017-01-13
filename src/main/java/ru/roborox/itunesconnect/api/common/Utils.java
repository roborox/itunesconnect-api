package ru.roborox.itunesconnect.api.common;

import org.apache.http.client.CookieStore;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.fluent.Executor;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.cookie.ClientCookie;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieSpecProvider;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.impl.cookie.BrowserCompatSpecFactory;
import ru.roborox.itunesconnect.api.Const;
import ru.roborox.itunesconnect.api.login.ConnectTokens;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

public class Utils {
    public static Executor createExecutor(CookieStore cookieStore) {
        @SuppressWarnings("deprecation") final Registry<CookieSpecProvider> cookieSpecRegistry =
                RegistryBuilder.<CookieSpecProvider>create().register(CookieSpecs.DEFAULT, new BrowserCompatSpecFactory()).build();
        final CloseableHttpClient client = HttpClients.custom()
                .setDefaultCookieSpecRegistry(cookieSpecRegistry)
                .setDefaultCookieStore(cookieStore)
                .build();
        return Executor.newInstance(client);
    }

    public static CookieStore createBasicCookieStore(ConnectTokens tokens) {
        final BasicCookieStore store = new BasicCookieStore();
        store.addCookie(createCookie("itctx", tokens.getItctx()));
        store.addCookie(createCookie("myacinfo", tokens.getMyacinfo()));
        return store;
    }

    public static Cookie createCookie(String name, String value) {
        final BasicClientCookie cookie = new BasicClientCookie(name, value);
        cookie.setAttribute(ClientCookie.DOMAIN_ATTR, Const.COOKIE_DOMAIN);
        cookie.setPath("/");
        cookie.setDomain(Const.COOKIE_DOMAIN);
        return cookie;
    }

    public static DateFormat createDateFormat(String pattern) {
        final SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return dateFormat;
    }
}
