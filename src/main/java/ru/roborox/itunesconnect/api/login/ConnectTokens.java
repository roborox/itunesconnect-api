package ru.roborox.itunesconnect.api.login;

public class ConnectTokens {
    private final String itctx;
    private final String myacinfo;

    public ConnectTokens(String itctx, String myacinfo) {
        this.itctx = itctx;
        this.myacinfo = myacinfo;
    }

    public String getItctx() {
        return itctx;
    }

    public String getMyacinfo() {
        return myacinfo;
    }
}
