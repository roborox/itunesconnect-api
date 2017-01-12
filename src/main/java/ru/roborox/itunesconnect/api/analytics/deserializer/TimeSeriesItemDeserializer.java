package ru.roborox.itunesconnect.api.analytics.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.node.NumericNode;
import com.fasterxml.jackson.databind.node.TextNode;
import ru.roborox.itunesconnect.api.analytics.model.TimeSeriesItem;
import ru.roborox.itunesconnect.api.analytics.model.enums.AnalyticsMeasure;

import java.io.IOException;

public class TimeSeriesItemDeserializer extends StdDeserializer<TimeSeriesItem> {
    protected TimeSeriesItemDeserializer() {
        super(TimeSeriesItem.class);
    }

    @Override
    public TimeSeriesItem deserialize(JsonParser jp, DeserializationContext ctx) throws IOException {
        final TreeNode node = jp.getCodec().readTree(jp);
        final AnalyticsMeasure[] measure = new AnalyticsMeasure[1];
        final Double[] value = new Double[1];
        node.fieldNames().forEachRemaining(field -> {
            if (!field.equals("date")) {
                measure[0] = AnalyticsMeasure.fromId(field);
                value[0] = ((NumericNode) node.get(field)).doubleValue();
            }
        });
        return new TimeSeriesItem(ctx.parseDate(((TextNode) node.get("date")).textValue()), measure[0], value[0]);
    }
}
