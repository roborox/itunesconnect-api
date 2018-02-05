package ru.roborox.itunesconnect.api;

import java.io.IOException;
import java.text.ParseException;
import java.util.Arrays;

import org.testng.annotations.Test;

import ru.roborox.itunesconnect.api.analytics.model.App;
import ru.roborox.itunesconnect.api.reporting.model.RTimeSeriesFilter;
import ru.roborox.itunesconnect.api.reporting.model.RTimeSeriesRequest;
import ru.roborox.itunesconnect.api.reporting.model.RTimeSeries;
import ru.roborox.itunesconnect.api.reporting.model.enums.Interval;
import ru.roborox.itunesconnect.api.reporting.model.enums.RDimension;
import ru.roborox.itunesconnect.api.reporting.model.enums.RMeasureType;
import ru.roborox.itunesconnect.api.reporting.model.enums.RSort;

public class ReportingApiTest extends AbstractItunesConnectApiTest {
    @Test
    public void getRoyaltyForAllApps() throws IOException, ParseException {
        double total = 0;
        for (App app : getAnalyticsApi().getApps().getResults()) {
            logger.info("processing {}", app.getName());
            final RTimeSeriesFilter filter = new RTimeSeriesFilter(RDimension.CONTENT, app.getAdamId());
            final RTimeSeriesRequest req = new RTimeSeriesRequest(
                    Interval.DAY, RDimension.CONTENT, start, end, RSort.ASC, 100, filter, RMeasureType.ROYALTY_UTC);
            final RTimeSeries series = getReportingApi().getTimeSeries(req);
            if (series != null) {
                final double perApp = Arrays.stream(series.getData()).mapToDouble(d -> d.getData().get(RMeasureType.ROYALTY_UTC)).sum();
                total += perApp;
                logger.info("sum for {} is {}", app.getName(), perApp);
            }
        }
        logger.info("total={}", total);
    }

}
