package ru.roborox.itunesconnect.api.analytics.model;

public class ContentProvider {
    private String providerId;
    private String providerName;

    public ContentProvider() {
    }

    public ContentProvider(String providerId, String providerName) {
        this.providerId = providerId;
        this.providerName = providerName;
    }

    public String getProviderId() {
        return providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    @Override
    public String toString() {
        return "ContentProvider{" +
                "providerId='" + providerId + '\'' +
                ", providerName='" + providerName + '\'' +
                '}';
    }
}
