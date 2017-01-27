package ru.roborox.itunesconnect.api.login;

import org.apache.http.client.CookieStore;
import org.apache.http.cookie.Cookie;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class NotRecordingCookieStore implements CookieStore {
    private final List<Cookie> cookies;

    public NotRecordingCookieStore(Cookie... cookies) {
        this.cookies = Collections.unmodifiableList(Arrays.asList(cookies));
    }

    @Override
    public void addCookie(Cookie cookie) {

    }

    @Override
    public List<Cookie> getCookies() {
        return cookies;
    }

    @Override
    public boolean clearExpired(Date date) {
        return false;
    }

    @Override
    public void clear() {

    }
}
