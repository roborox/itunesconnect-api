package ru.roborox.itunesconnect.api;

import org.apache.commons.lang3.time.DateUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.roborox.itunesconnect.api.analytics.model.*;
import ru.roborox.itunesconnect.api.analytics.model.enums.MeasureType;
import ru.roborox.itunesconnect.api.analytics.model.enums.Period;
import ru.roborox.itunesconnect.api.reporting.model.TimeSeriesFilter;
import ru.roborox.itunesconnect.api.reporting.model.TimeSeriesRequest;
import ru.roborox.itunesconnect.api.reporting.model.TimeSeriesResponse;
import ru.roborox.itunesconnect.api.reporting.model.enums.Dimension;
import ru.roborox.itunesconnect.api.reporting.model.enums.Interval;
import ru.roborox.itunesconnect.api.reporting.model.enums.Sort;

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
        final Date start = DateUtils.addDays(new Date(), -35);
        final Date end = new Date();
        final List<Measures> results = getAnalyticsApi().getMeasures(new MeasuresRequest(firstApp.getAdamId(), Period.DAY, MeasureType.values(), start, end)).getResults();
        assertEquals(results.size(), MeasureType.values().length);

        final TimeSeriesFilter filter = new TimeSeriesFilter(Dimension.CONTENT, "1177085726");
        final TimeSeriesResponse timeSeries = getReportingApi().getTimeSeries(new TimeSeriesRequest(Interval.DAY, Dimension.CONTENT, start, end, Sort.ASCENDING, 100, filter, ru.roborox.itunesconnect.api.reporting.model.enums.MeasureType.ROYALTY_UTC));
        System.out.println(timeSeries);
        assertTrue(timeSeries.getData().length != 0);
        assertEquals(timeSeries.getMetadata().getKey(), "1177085726");
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