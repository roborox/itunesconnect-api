package ru.roborox.itunesconnect.api;

import org.apache.commons.lang3.time.DateUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.roborox.itunesconnect.api.model.*;
import ru.roborox.itunesconnect.api.model.enums.Period;
import ru.roborox.itunesconnect.api.model.enums.TimeSeriesMeasure;

import java.io.IOException;
import java.util.Date;

import static org.testng.Assert.assertTrue;

public class AnalyticsApiTest extends AbstractAnalyticsApiTest {
    private UserInfo userInfo;

    @BeforeMethod
    @Override
    public void setUp() throws Exception {
        super.setUp();
        userInfo = getApi().getUserInfo();
    }

    @Test
    public void getTimeSeries() throws IOException {
        getApi().setProvider(userInfo.getContentProviders().get(0).getProviderId());

        final AppResponse apps = getApi().getApps();
        assertTrue(apps.getSize() != 0);

        final App firstApp = apps.getResults().get(0);
        final TimeSeriesResponse timeSeries = getApi().getTimeSeries(new TimeSeriesRequest(firstApp.getAdamId(), Period.DAY, new TimeSeriesMeasure[]{TimeSeriesMeasure.IMPRESSIONS_TOTAL_UNIQUE}, DateUtils.addDays(new Date(), -35), DateUtils.addDays(new Date(), -5)));

        assertTrue(timeSeries.getSize() != 0);
    }
}
