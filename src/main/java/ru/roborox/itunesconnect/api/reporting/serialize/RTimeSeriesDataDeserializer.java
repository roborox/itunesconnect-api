package ru.roborox.itunesconnect.api.reporting.serialize;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.node.NumericNode;
import com.fasterxml.jackson.databind.node.TextNode;

import ru.roborox.itunesconnect.api.Const;
import ru.roborox.itunesconnect.api.reporting.model.RTimeSeriesData;
import ru.roborox.itunesconnect.api.reporting.model.enums.RMeasureType;

public class RTimeSeriesDataDeserializer extends StdDeserializer<RTimeSeriesData> {
    protected RTimeSeriesDataDeserializer() {
        super(RTimeSeriesData.class);
    }

    @Override
    public RTimeSeriesData deserialize(JsonParser jp, DeserializationContext ctx) throws IOException {
        final TreeNode node = jp.getCodec().readTree(jp);
        final HashMap<RMeasureType, Double> data = new HashMap<>();
        node.fieldNames().forEachRemaining(field -> {
            if (!field.equals("day")) {
                final RMeasureType key = RMeasureType.fromId(field);
                final double value = ((NumericNode) node.get(field)).doubleValue();
                data.put(key, value);
            }
        });
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        format.setTimeZone(Const.TIME_ZONE_UTC);
        try {
            return new RTimeSeriesData(format.parse(((TextNode) node.get("day")).textValue()), data);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
