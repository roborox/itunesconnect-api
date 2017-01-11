package ru.roborox.itunesconnect.api;

import org.apache.commons.lang3.time.DateUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.roborox.itunesconnect.api.analytics.model.*;
import ru.roborox.itunesconnect.api.analytics.model.enums.AnalyticsMeasure;
import ru.roborox.itunesconnect.api.analytics.model.enums.Period;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ItunesConnectApiTest extends AbstractItunesConnectApiTest {
    private UserInfo userInfo;

    @BeforeMethod
    @Override
    public void setUp() throws Exception {
        super.setUp();
        userInfo = getAnalyticsApi().getUserInfo();
    }

    @Test
    public void getMeasures() throws IOException {
        final App firstApp = getFirstApp();
        final Date start = DateUtils.addDays(new Date(), -120);
        System.out.println(start);
        final Date end = new Date();
        final List<Measures> results = getAnalyticsApi().getMeasures(new MeasuresRequest(firstApp.getAdamId(), Period.DAY, AnalyticsMeasure.values(), start, end)).getResults();
        assertEquals(results.size(), AnalyticsMeasure.values().length);
    }

    private App getFirstApp() throws IOException {
        return getApps().get(0);
    }

    private List<App> getApps() throws IOException {
        final List<ContentProvider> providers = userInfo.getContentProviders();
        getAnalyticsApi().setProvider(providers.get(0).getProviderId());
        final AppResponse apps = getAnalyticsApi().getApps();
        assertTrue(apps.getSize() != 0);
        return apps.getResults();
    }
}
