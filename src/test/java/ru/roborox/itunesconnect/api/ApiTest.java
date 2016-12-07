package ru.roborox.itunesconnect.api;

import org.testng.annotations.BeforeMethod;

import java.util.Properties;

public abstract class ApiTest {
    private String login;
    private String password;

    @BeforeMethod
    public void setUp() throws Exception {
        final Properties props = new Properties();
        props.load(getClass().getClassLoader().getResourceAsStream("app.properties"));
        login = props.getProperty("itunesConnectLogin");
        password = props.getProperty("itunesConnectPassword");
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
