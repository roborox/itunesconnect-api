package ru.roborox.itunesconnect.api.analytics.serialize;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import ru.roborox.itunesconnect.api.analytics.model.TimeSeriesItem;

import java.io.IOException;

public class TimeSeriesItemSerializer extends JsonSerializer<TimeSeriesItem> {
    @Override
    public void serialize(TimeSeriesItem value, JsonGenerator gen, SerializerProvider serializers) throws IOException, JsonProcessingException {
        gen.writeStartObject();
        gen.writeFieldName("date");
        serializers.defaultSerializeDateValue(value.getDate(), gen);
        gen.writeNumberField(value.getMeasure().getId(), value.getValue());
        gen.writeEndObject();
    }
}
