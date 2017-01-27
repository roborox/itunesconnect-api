package ru.roborox.itunesconnect.api.reporting.model;

public class UserInfo {
    private String name;
    private String dsId;
    private String contentProviderId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContentProviderId() {
        return contentProviderId;
    }

    public String getDsId() {
        return dsId;
    }

    public void setDsId(String dsId) {
        this.dsId = dsId;
    }

    public void setContentProviderId(String contentProviderId) {
        this.contentProviderId = contentProviderId;
    }
}
