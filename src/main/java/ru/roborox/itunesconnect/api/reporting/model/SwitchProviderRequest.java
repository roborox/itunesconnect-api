package ru.roborox.itunesconnect.api.reporting.model;

public class SwitchProviderRequest {
    //{"dsId":"10525191494","contentProviderId":118372822,"expirationDate":null,"ipAddress":null}
    private String dsId;
    private String contentProviderId;

    public SwitchProviderRequest(String dsId, String contentProviderId) {
        this.dsId = dsId;
        this.contentProviderId = contentProviderId;
    }

    public String getDsId() {
        return dsId;
    }

    public void setDsId(String dsId) {
        this.dsId = dsId;
    }

    public String getContentProviderId() {
        return contentProviderId;
    }

    public void setContentProviderId(String contentProviderId) {
        this.contentProviderId = contentProviderId;
    }
}
