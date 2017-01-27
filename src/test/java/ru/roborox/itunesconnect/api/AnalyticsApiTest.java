package ru.roborox.itunesconnect.api;

import org.testng.annotations.Test;
import ru.roborox.itunesconnect.api.analytics.model.App;
import ru.roborox.itunesconnect.api.analytics.model.TimeSeriesGroup;
import ru.roborox.itunesconnect.api.analytics.model.TimeSeriesRequest;
import ru.roborox.itunesconnect.api.analytics.model.TimeSeriesResponse;
import ru.roborox.itunesconnect.api.analytics.model.enums.Dimension;
import ru.roborox.itunesconnect.api.analytics.model.enums.Measure;
import ru.roborox.itunesconnect.api.analytics.model.enums.Period;
import ru.roborox.itunesconnect.api.common.Sort;

import java.io.IOException;

public class AnalyticsApiTest extends AbstractItunesConnectApiTest {

    @Test
    public void getUnitsForAllApps() throws IOException {
        getTimeSeriesForAllApps(adamId -> new TimeSeriesRequest(adamId, Period.DAY, Measure.UNITS, start, end, null));
    }

    @Test
    public void getUnitsForAllAppsByTerritory() throws IOException {
        final TimeSeriesGroup group = new TimeSeriesGroup(Measure.UNITS, Dimension.TERRITORY, Sort.ASCENDING, 3);
        getTimeSeriesForAllApps(adamId -> new TimeSeriesRequest(adamId, Period.DAY, Measure.UNITS, start, end, group));
    }

    private void getTimeSeriesForAllApps(IOFunction<String, TimeSeriesRequest> requestFunction) throws IOException {
        int total = 0;
        for (App app : getAnalyticsApi().getApps().getResults()) {
            logger.info("processing {}", app.getName());
            final TimeSeriesResponse byTerritory = getAnalyticsApi().getTimeSeries(requestFunction.apply(app.getAdamId()));
            if (byTerritory.getResults() != null) {
                final int sum = byTerritory.getResults().stream()
                        .flatMap(t -> t.getData().stream())
                        .mapToInt(item -> item.getValue().intValue())
                        .sum();
                logger.info("total sum for {} is {}", app.getName(), sum);
                total += sum;
            } else {
                logger.info("no results for {}", app.getName());
            }
        }
        logger.info("total sum for all apps is {}", total);
    }

    private interface IOFunction<T, R> {
        R apply(T t) throws IOException;
    }
}
