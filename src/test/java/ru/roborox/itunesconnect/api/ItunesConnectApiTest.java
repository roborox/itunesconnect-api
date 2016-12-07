package ru.roborox.itunesconnect.api;

import org.testng.annotations.BeforeMethod;
import ru.roborox.itunesconnect.api.login.ItunesConnectLoginApi;

public abstract class ItunesConnectApiTest extends ApiTest {
    private ItunesConnectApi api;

    @BeforeMethod
    @Override
    public void setUp() throws Exception {
        super.setUp();
        api = new ItunesConnectApi(new ItunesConnectLoginApi().login(getLogin(), getPassword()));
    }

    public ItunesConnectApi getApi() {
        return api;
    }
}
