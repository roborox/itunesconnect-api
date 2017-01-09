package ru.roborox.itunesconnect.api.reporting.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.TextNode;
import ru.roborox.itunesconnect.api.reporting.model.TimeSeriesData;
import ru.roborox.itunesconnect.api.reporting.model.enums.MeasureType;

import java.io.IOException;
import java.util.HashMap;

public class TimeSeriesDataDeserializer extends StdDeserializer<TimeSeriesData> {
    protected TimeSeriesDataDeserializer() {
        super(TimeSeriesData.class);
    }

    @Override
    public TimeSeriesData deserialize(JsonParser jp, DeserializationContext ctx) throws IOException {
        final TreeNode node = jp.getCodec().readTree(jp);
        final HashMap<MeasureType, Double> data = new HashMap<>();
        node.fieldNames().forEachRemaining(field -> {
            if (!field.equals("date")) {
                final MeasureType key = MeasureType.fromId(field);
                final double value = ((DoubleNode) node.get(field)).doubleValue();
                data.put(key, value);
            }
        });
        return new TimeSeriesData(ctx.parseDate(((TextNode) node.get("date")).textValue()), data);
    }
}
