package ru.roborox.itunesconnect.api;

import org.apache.commons.lang3.time.DateUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.roborox.itunesconnect.api.model.*;
import ru.roborox.itunesconnect.api.model.enums.Period;
import ru.roborox.itunesconnect.api.model.enums.MeasureType;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import static org.testng.Assert.assertEquals;
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
        final App firstApp = getFirstApp();
        final TimeSeriesResponse timeSeries = getApi().getTimeSeries(new TimeSeriesRequest(new String[]{firstApp.getAdamId()}, Period.DAY, new MeasureType[]{MeasureType.IMPRESSIONS_TOTAL_UNIQUE}, DateUtils.addDays(new Date(), -35), DateUtils.addDays(new Date(), -5), null, new String[0]));
        assertTrue(timeSeries.getSize() != 0);
    }

    @Test
    public void getAllMeasures() throws IOException {
        final App firstApp = getFirstApp();
        final List<Measures> results = getApi().getMeasures(new MeasuresRequest(new String[]{firstApp.getAdamId()}, Period.DAY, MeasureType.values(), DateUtils.addDays(new Date(), -35), DateUtils.addDays(new Date(), -5))).getResults();
        assertEquals(results.size(), MeasureType.values().length);
    }

    private App getFirstApp() throws IOException {
        getApi().setProvider(userInfo.getContentProviders().get(0).getProviderId());

        final AppResponse apps = getApi().getApps();
        assertTrue(apps.getSize() != 0);

        return apps.getResults().get(0);
    }
}