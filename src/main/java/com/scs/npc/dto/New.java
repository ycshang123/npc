package com.scs.npc.dto;/*@ClassName New
 *@Description:todo
 *@author yc_shang
 *@Date2020/2/21
 *@Version 1.0
 **/

public class New {
    private Integer provinceId;
    private  String infoSource;
    private String sourceUrl;
    private String provinceName;
    private String title;
    private String summary;

    public New() {
    }

    public New(Integer provinceId, String infoSource, String sourceUrl, String provinceName, String title, String summary) {
        this.provinceId = provinceId;
        this.infoSource = infoSource;
        this.sourceUrl = sourceUrl;
        this.provinceName = provinceName;
        this.title = title;
        this.summary = summary;
    }

    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    public String getInfoSource() {
        return infoSource;
    }

    public void setInfoSource(String infoSource) {
        this.infoSource = infoSource;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}
