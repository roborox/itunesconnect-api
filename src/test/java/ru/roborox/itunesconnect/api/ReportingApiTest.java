package ru.roborox.itunesconnect.api;

import org.testng.annotations.Test;
import ru.roborox.itunesconnect.api.analytics.model.App;
import ru.roborox.itunesconnect.api.common.Sort;
import ru.roborox.itunesconnect.api.reporting.model.TimeSeriesFilter;
import ru.roborox.itunesconnect.api.reporting.model.TimeSeriesRequest;
import ru.roborox.itunesconnect.api.reporting.model.TimeSeriesResponse;
import ru.roborox.itunesconnect.api.reporting.model.enums.Dimension;
import ru.roborox.itunesconnect.api.reporting.model.enums.Interval;
import ru.roborox.itunesconnect.api.reporting.model.enums.ReportingMeasure;

import java.io.IOException;
import java.text.ParseException;
import java.util.Arrays;

public class ReportingApiTest extends AbstractItunesConnectApiTest {
    @Test
    public void getRoyaltyForAllApps() throws IOException, ParseException {
        double total = 0;
        for (App app : getAnalyticsApi().getApps().getResults()) {
            logger.info("processing {}", app.getName());
            final TimeSeriesFilter filter = new TimeSeriesFilter(Dimension.CONTENT, app.getAdamId());
            final TimeSeriesRequest req = new TimeSeriesRequest(
                    Interval.DAY, Dimension.CONTENT, start, end, Sort.ASCENDING,100, filter, ReportingMeasure.ROYALTY_UTC);
            final TimeSeriesResponse series = getReportingApi().getTimeSeries(req);
            if (series != null) {
                final double perApp = Arrays.stream(series.getData()).mapToDouble(d -> d.getData().get(ReportingMeasure.ROYALTY_UTC)).sum();
                total += perApp;
                logger.info("sum for {} is {}", app.getName(), perApp);
            }
        }
        logger.info("total={}", total);
    }

}
