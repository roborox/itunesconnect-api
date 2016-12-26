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
    public void getAllMeasures() throws IOException {
        final App firstApp = getFirstApp();
        final List<Measures> results = getApi().getMeasures(new MeasuresRequest(firstApp.getAdamId(), Period.DAY, MeasureType.values(), DateUtils.addDays(new Date(), -35), DateUtils.addDays(new Date(), -5))).getResults();
        assertEquals(results.size(), MeasureType.values().length);
    }

    private App getFirstApp() throws IOException {
        return getApps().get(0);
    }

    private List<App> getApps() throws IOException {
        final List<ContentProvider> providers = userInfo.getContentProviders();
        getApi().setProvider(providers.get(providers.size() - 1).getProviderId());
        final AppResponse apps = getApi().getApps();
        assertTrue(apps.getSize() != 0);
        for (App app : apps.getResults()) {
            System.out.println(app.getName());
        }
        return apps.getResults();
    }
}
