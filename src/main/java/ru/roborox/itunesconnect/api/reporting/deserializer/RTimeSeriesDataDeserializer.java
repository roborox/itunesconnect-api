package ru.roborox.itunesconnect.api.reporting.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.node.NumericNode;
import com.fasterxml.jackson.databind.node.TextNode;
import ru.roborox.itunesconnect.api.reporting.model.RTimeSeriesData;
import ru.roborox.itunesconnect.api.reporting.model.enums.RMeasure;

import java.io.IOException;
import java.util.HashMap;

public class RTimeSeriesDataDeserializer extends StdDeserializer<RTimeSeriesData> {
    protected RTimeSeriesDataDeserializer() {
        super(RTimeSeriesData.class);
    }

    @Override
    public RTimeSeriesData deserialize(JsonParser jp, DeserializationContext ctx) throws IOException {
        final TreeNode node = jp.getCodec().readTree(jp);
        final HashMap<RMeasure, Double> data = new HashMap<>();
        node.fieldNames().forEachRemaining(field -> {
            if (!field.equals("date")) {
                final RMeasure key = RMeasure.fromId(field);
                final double value = ((NumericNode) node.get(field)).doubleValue();
                data.put(key, value);
            }
        });
        return new RTimeSeriesData(ctx.parseDate(((TextNode) node.get("date")).textValue()), data);
    }
}
