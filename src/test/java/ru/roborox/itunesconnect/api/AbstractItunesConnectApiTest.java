package ru.roborox.itunesconnect.api;

import org.testng.annotations.BeforeMethod;
import ru.roborox.itunesconnect.api.analytics.ItunesAnalyticsApi;
import ru.roborox.itunesconnect.api.login.ConnectTokens;
import ru.roborox.itunesconnect.api.login.ItunesConnectLoginApi;

public abstract class AbstractItunesConnectApiTest extends ApiTest {
    private ItunesAnalyticsApi analyticsApi;

    @BeforeMethod
    @Override
    public void setUp() throws Exception {
        super.setUp();
        final ItunesConnectLoginApi itunesConnectLoginApi = new ItunesConnectLoginApi(Const.ITUNESCONNECT_HOSTNAME, Const.OLYMPUS_URL);
        final ConnectTokens tokens = itunesConnectLoginApi.login(getLogin(), getPassword());
        logger.info("tokens={}", tokens);
        analyticsApi = new ItunesAnalyticsApi(tokens, Const.ANALYTICS_URL, true);
    }

    public ItunesAnalyticsApi getAnalyticsApi() {
        return analyticsApi;
    }
}
