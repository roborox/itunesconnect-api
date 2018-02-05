package ru.roborox.itunesconnect.api.reporting.serialize;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Map;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import ru.roborox.itunesconnect.api.Const;
import ru.roborox.itunesconnect.api.reporting.model.RTimeSeriesData;
import ru.roborox.itunesconnect.api.reporting.model.enums.RMeasureType;

public class RTimeSeriesDataSerializer extends JsonSerializer<RTimeSeriesData> {
    @Override
    public void serialize(RTimeSeriesData value, JsonGenerator gen, SerializerProvider serializers) throws IOException, JsonProcessingException {
        gen.writeStartObject();
        gen.writeFieldName("day");
        if (value.getDay() != null) {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            format.setTimeZone(Const.TIME_ZONE_UTC);
            gen.writeString(format.format(value.getDay()));
        } else {
            gen.writeNull();
        }
        for (Map.Entry<RMeasureType, Double> entry : value.getData().entrySet()) {
            gen.writeNumberField(entry.getKey().getId(), entry.getValue());
        }
        gen.writeEndObject();
    }
}
