package ru.roborox.itunesconnect.api.login;

import org.apache.http.client.CookieStore;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;

import java.util.Optional;

public class TokensCookieStore extends BasicCookieStore implements CookieStore {
    public static final String ITCTX = "itctx";
    public static final String MYACINFO = "myacinfo";

    private String itctx;
    private String myacinfo;

    @Override
    public synchronized void addCookie(Cookie cookie) {
        super.addCookie(cookie);
        switch (cookie.getName()) {
            case ITCTX:
                itctx = cookie.getValue();
                break;
            case MYACINFO:
                myacinfo = cookie.getValue();
        }
    }

    public Optional<ConnectTokens> getTokens() {
        if (itctx != null && myacinfo != null) {
            return Optional.of(new ConnectTokens(itctx, myacinfo));
        } else {
            return Optional.empty();
        }
    }
}
