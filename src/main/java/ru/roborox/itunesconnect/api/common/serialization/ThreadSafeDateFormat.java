package ru.roborox.itunesconnect.api.common.serialization;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.util.Date;

public class ThreadSafeDateFormat extends DateFormat {
    private final DateFormat prototype;
    private final ThreadLocal<DateFormat> localFormat = new ThreadLocal<DateFormat>() {
        @Override
        protected DateFormat initialValue() {
            return (DateFormat) prototype.clone();
        }
    };

    public ThreadSafeDateFormat(DateFormat prototype) {
        this.prototype = prototype;
    }

    @Override
    public StringBuffer format(Date date, StringBuffer toAppendTo, FieldPosition fieldPosition) {
        return localFormat.get().format(date, toAppendTo, fieldPosition);
    }

    @Override
    public Date parse(String source, ParsePosition pos) {
        return localFormat.get().parse(source, pos);
    }
}
