package ru.roborox.itunesconnect.api;

import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;
import org.testng.annotations.BeforeMethod;

import ru.roborox.itunesconnect.api.analytics.ItunesAnalyticsApi;
import ru.roborox.itunesconnect.api.login.ConnectTokens;
import ru.roborox.itunesconnect.api.login.ItunesConnectLoginApi;
import ru.roborox.itunesconnect.api.reporting.ReportingApi;

public abstract class AbstractItunesConnectApiTest extends ApiTest {
    private ItunesAnalyticsApi analyticsApi;
    private ReportingApi reportingApi;

    protected Date start;
    protected Date end;

    @BeforeMethod
    @Override
    public void setUp() throws Exception {
        super.setUp();
        final ItunesConnectLoginApi itunesConnectLoginApi = new ItunesConnectLoginApi(Const.ITUNESCONNECT_HOSTNAME, Const.OLYMPUS_URL);
        final ConnectTokens tokens = itunesConnectLoginApi.login(getLogin(), getPassword());
        logger.info("tokens={}", tokens);
        analyticsApi = new ItunesAnalyticsApi(tokens, Const.ANALYTICS_URL, true);
        reportingApi = new ReportingApi(tokens, Const.REPORTING_URL_BASE + "777", true);
        end = getStartOfDay(new Date(), Const.TIME_ZONE_UTC);
        start = DateUtils.addDays(end, -180);
    }

    public ItunesAnalyticsApi getAnalyticsApi() {
        return analyticsApi;
    }

    public ReportingApi getReportingApi() {
        return reportingApi;
    }
}
