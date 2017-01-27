package ru.roborox.itunesconnect.api;

import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeMethod;
import ru.roborox.itunesconnect.api.common.Utils;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.TimeZone;

public abstract class ApiTest {
    protected final Logger logger = LoggerFactory.getLogger(getClass());

    private String login;
    private String password;
    protected final DateFormat dateFormat = Utils.createDateFormat("dd-MM-yyyy");

    public Date getStartOfDay(Date date, TimeZone timeZone) {
        final Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.setTimeZone(timeZone);
        return DateUtils.truncate(cal, Calendar.DAY_OF_MONTH).getTime();
    }

    @BeforeMethod
    public void setUp() throws Exception {
        final Properties props = new Properties();
        props.load(getClass().getClassLoader().getResourceAsStream("app.properties"));
        login = props.getProperty("itunesConnectLogin");
        password = props.getProperty("itunesConnectPassword");
        logger.info("using {}", login);
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
