package ru.roborox.itunesconnect.api;

import org.apache.commons.lang3.time.DateUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.roborox.itunesconnect.api.analytics.model.*;
import ru.roborox.itunesconnect.api.analytics.model.enums.Dimension;
import ru.roborox.itunesconnect.api.analytics.model.enums.Measure;
import ru.roborox.itunesconnect.api.analytics.model.enums.Period;
import ru.roborox.itunesconnect.api.common.Sort;

import java.io.IOException;
import java.util.Date;

import static org.testng.Assert.assertEquals;

public class ItunesConnectApiTest extends AbstractItunesConnectApiTest {
    private UserInfo userInfo;
    private Date start;
    private Date end;

    @BeforeMethod
    @Override
    public void setUp() throws Exception {
        super.setUp();
        userInfo = getAnalyticsApi().getUserInfo();
        System.out.println("userInfo=" + userInfo);
        end = new Date();
        start = DateUtils.addDays(end, -120);
    }

    @Test
    public void getAnalyticsForAllApps() throws IOException {
        forEachApp(app -> {
            final MeasuresResponse response = getAnalyticsApi().getMeasures(new MeasuresRequest(app.getAdamId(), Period.DAY, Measure.values(), start, end));
            System.out.println(response.getResults());

            for (Measure measure : Measure.values()) {
                final TimeSeriesGroup group = new TimeSeriesGroup(measure, Dimension.TERRITORY, Sort.ASCENDING, 3);
                final TimeSeriesResponse byTerritory = getAnalyticsApi().getTimeSeries(new TimeSeriesRequest(app.getAdamId(), Period.DAY, measure, start, end, group));
                if (byTerritory.getResults() != null) {
                    assertEquals(byTerritory.getSize(), byTerritory.getResults().size());
                }
                System.out.println("measure=" + measure + " results=" + byTerritory);
            }
        });
    }

    protected void forEachApp(IOConsumer<App> appConsumer) throws IOException {
        for (ContentProvider contentProvider : userInfo.getContentProviders()) {
            System.out.println("using " + contentProvider);
            getAnalyticsApi().setProvider(contentProvider.getProviderId());
            assertEquals(getAnalyticsApi().getUserInfo().getProviderId(), contentProvider.getProviderId());
            for (App app : getAnalyticsApi().getApps().getResults()) {
                System.out.println("processing " + app);
                appConsumer.accept(app);
            }
        }
    }
}
