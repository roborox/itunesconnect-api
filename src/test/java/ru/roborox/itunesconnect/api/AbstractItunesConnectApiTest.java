package ru.roborox.itunesconnect.api;

import org.testng.annotations.BeforeMethod;
import ru.roborox.itunesconnect.api.analytics.ItunesAnalyticsApi;
import ru.roborox.itunesconnect.api.login.ConnectTokens;
import ru.roborox.itunesconnect.api.login.ItunesConnectLoginApi;
import ru.roborox.itunesconnect.api.reporting.ReportingApi;

public abstract class AbstractItunesConnectApiTest extends ApiTest {
    private ItunesAnalyticsApi analyticsApi;
    private ReportingApi reportingApi;

    @BeforeMethod
    @Override
    public void setUp() throws Exception {
        super.setUp();
        final ItunesConnectLoginApi itunesConnectLoginApi = new ItunesConnectLoginApi(Const.ITUNESCONNECT_HOSTNAME, Const.OLYMPUS_URL);
        final ConnectTokens tokens = itunesConnectLoginApi.login(getLogin(), getPassword());
        analyticsApi = new ItunesAnalyticsApi(Const.ANALYTICS_URL, tokens);
        reportingApi = new ReportingApi(Const.REPORTING_URL, tokens);
    }

    public ItunesAnalyticsApi getAnalyticsApi() {
        return analyticsApi;
    }

    public ReportingApi getReportingApi() {
        return reportingApi;
    }
}
