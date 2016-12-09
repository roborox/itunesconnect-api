package ru.roborox.itunesconnect.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class App {
    private String name;
    private String adamId;
    private boolean bundle;
    private String iconUrl;
    private String assetToken;
    private String[] platforms;
    private boolean enabled;
    private int appOptInRate;

    public App() {
    }

    public App(String name, String adamId) {
        this.name = name;
        this.adamId = adamId;
        this.enabled = true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdamId() {
        return adamId;
    }

    public void setAdamId(String adamId) {
        this.adamId = adamId;
    }

    @JsonProperty("isBundle")
    public boolean isBundle() {
        return bundle;
    }

    public void setBundle(boolean bundle) {
        this.bundle = bundle;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getAssetToken() {
        return assetToken;
    }

    public void setAssetToken(String assetToken) {
        this.assetToken = assetToken;
    }

    public String[] getPlatforms() {
        return platforms;
    }

    public void setPlatforms(String[] platforms) {
        this.platforms = platforms;
    }

    @JsonProperty("isEnabled")
    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public int getAppOptInRate() {
        return appOptInRate;
    }

    public void setAppOptInRate(int appOptInRate) {
        this.appOptInRate = appOptInRate;
    }
}
