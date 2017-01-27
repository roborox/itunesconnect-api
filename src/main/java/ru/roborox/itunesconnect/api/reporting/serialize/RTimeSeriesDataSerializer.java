package ru.roborox.itunesconnect.api.reporting.serialize;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import ru.roborox.itunesconnect.api.reporting.model.RTimeSeriesData;
import ru.roborox.itunesconnect.api.reporting.model.enums.RMeasure;

import java.io.IOException;
import java.util.Map;

public class RTimeSeriesDataSerializer extends JsonSerializer<RTimeSeriesData> {
    @Override
    public void serialize(RTimeSeriesData value, JsonGenerator gen, SerializerProvider serializers) throws IOException, JsonProcessingException {
        gen.writeStartObject();
        gen.writeFieldName("date");
        serializers.defaultSerializeDateValue(value.getDate(), gen);
        for (Map.Entry<RMeasure, Double> entry : value.getData().entrySet()) {
            gen.writeNumberField(entry.getKey().getId(), entry.getValue());
        }
        gen.writeEndObject();
    }
}
