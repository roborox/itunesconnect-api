package ru.roborox.itunesconnect.api.analytics.model;

public class AuthServiceConfig {
    private String authServiceKey;
    private String authServiceUrl;

    public AuthServiceConfig() {
    }

    public AuthServiceConfig(String authServiceKey, String authServiceUrl) {

        this.authServiceKey = authServiceKey;
        this.authServiceUrl = authServiceUrl;
    }

    public String getAuthServiceKey() {
        return authServiceKey;
    }

    public void setAuthServiceKey(String authServiceKey) {
        this.authServiceKey = authServiceKey;
    }

    public String getAuthServiceUrl() {
        return authServiceUrl;
    }

    public void setAuthServiceUrl(String authServiceUrl) {
        this.authServiceUrl = authServiceUrl;
    }
}
