package ru.roborox.itunesconnect.api.reporting.model;

public class TimeSeriesMetadata {
    private String key;
    private String title;
    private String contentSpecificTypeId;
    private String contentSpecificTypeName;
    private String artistName;
    private String contentGrpCd;
    private String supportedPlatformName;
    private String rptgDesc;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContentSpecificTypeId() {
        return contentSpecificTypeId;
    }

    public void setContentSpecificTypeId(String contentSpecificTypeId) {
        this.contentSpecificTypeId = contentSpecificTypeId;
    }

    public String getContentSpecificTypeName() {
        return contentSpecificTypeName;
    }

    public void setContentSpecificTypeName(String contentSpecificTypeName) {
        this.contentSpecificTypeName = contentSpecificTypeName;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getContentGrpCd() {
        return contentGrpCd;
    }

    public void setContentGrpCd(String contentGrpCd) {
        this.contentGrpCd = contentGrpCd;
    }

    public String getSupportedPlatformName() {
        return supportedPlatformName;
    }

    public void setSupportedPlatformName(String supportedPlatformName) {
        this.supportedPlatformName = supportedPlatformName;
    }

    public String getRptgDesc() {
        return rptgDesc;
    }

    public void setRptgDesc(String rptgDesc) {
        this.rptgDesc = rptgDesc;
    }
}
