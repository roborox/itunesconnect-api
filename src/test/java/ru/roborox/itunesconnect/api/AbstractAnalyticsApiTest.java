package ru.roborox.itunesconnect.api;

import org.testng.annotations.BeforeMethod;
import ru.roborox.itunesconnect.api.login.ItunesConnectLoginApi;

public abstract class AbstractAnalyticsApiTest extends ApiTest {
    private ItunesAnalyticsApi api;

    @BeforeMethod
    @Override
    public void setUp() throws Exception {
        super.setUp();
        final ItunesConnectLoginApi itunesConnectLoginApi = new ItunesConnectLoginApi(Const.ITUNESCONNECT_HOSTNAME, Const.OLYMPUS_URL);
        api = new ItunesAnalyticsApi(Const.ANALYTICS_URL, itunesConnectLoginApi.login(getLogin(), getPassword()));
    }

    public ItunesAnalyticsApi getApi() {
        return api;
    }
}
