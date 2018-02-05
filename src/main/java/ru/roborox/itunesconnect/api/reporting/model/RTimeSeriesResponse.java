package ru.roborox.itunesconnect.api.reporting.model;

import java.util.List;
import java.util.Map;

public class RTimeSeriesResponse {
    private String status;
    private String requestId;
    private Map<String, Object> meta;
    private List<RTimeSeries> result;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public Map<String, Object> getMeta() {
        return meta;
    }

    public void setMeta(Map<String, Object> meta) {
        this.meta = meta;
    }

    public List<RTimeSeries> getResult() {
        return result;
    }

    public void setResult(List<RTimeSeries> result) {
        this.result = result;
    }

}
