package ru.roborox.itunesconnect.api.model;

import java.util.List;

public class UserInfo {
    private String firstName;
    private String lastName;
    private String userDisplayName;
    private String providerId;
    private String providerName;
    private String userName;
    private List<ContentProvider> contentProviders;

    public UserInfo() {
    }

    public UserInfo(List<ContentProvider> contentProviders) {
        this.contentProviders = contentProviders;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserDisplayName() {
        return userDisplayName;
    }

    public void setUserDisplayName(String userDisplayName) {
        this.userDisplayName = userDisplayName;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<ContentProvider> getContentProviders() {
        return contentProviders;
    }

    public void setContentProviders(List<ContentProvider> contentProviders) {
        this.contentProviders = contentProviders;
    }
}
