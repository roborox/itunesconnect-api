package ru.roborox.itunesconnect.api;

import org.testng.annotations.BeforeMethod;
import ru.roborox.itunesconnect.api.login.ItunesConnectLoginApi;

public abstract class AbstractAnalyticsApiTest extends ApiTest {
    private ItunesAnalyticsApi api;

    @BeforeMethod
    @Override
    public void setUp() throws Exception {
        super.setUp();
        api = new ItunesAnalyticsApi("https://analytics.itunes.apple.com/analytics/api/v1", new ItunesConnectLoginApi().login(getLogin(), getPassword()));
    }

    public ItunesAnalyticsApi getApi() {
        return api;
    }
}
