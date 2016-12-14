package ru.roborox.itunesconnect.api.model;

public class SigninRequest {
    private String accountName;
    private String password;
    private boolean rememberMe;

    public SigninRequest() {
    }

    public SigninRequest(String accountName, String password, boolean rememberMe) {
        this.accountName = accountName;
        this.password = password;
        this.rememberMe = rememberMe;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isRememberMe() {
        return rememberMe;
    }

    public void setRememberMe(boolean rememberMe) {
        this.rememberMe = rememberMe;
    }
}
