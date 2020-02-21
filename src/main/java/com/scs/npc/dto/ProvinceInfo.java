package com.scs.npc.dto;/*@ClassName ProvinceInfo
 *@Description:todo
 *@author yc_shang
 *@Date2020/2/21
 *@Version 1.0
 **/

public class ProvinceInfo {
    private String provinceName;
    private Integer provinceConfirmedCount;
    private Integer provinceSuspectedCount;
    private Integer provinceCuredCount;
    private Integer provinceDeadCount;


    public ProvinceInfo() {
    }

    public ProvinceInfo(String provinceName, Integer provinceConfirmedCount, Integer provinceSuspectedCount, Integer provinceCuredCount, Integer provinceDeadCount) {
        this.provinceName = provinceName;
        this.provinceConfirmedCount = provinceConfirmedCount;
        this.provinceSuspectedCount = provinceSuspectedCount;
        this.provinceCuredCount = provinceCuredCount;
        this.provinceDeadCount = provinceDeadCount;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public Integer getProvinceConfirmedCount() {
        return provinceConfirmedCount;
    }

    public void setProvinceConfirmedCount(Integer provinceConfirmedCount) {
        this.provinceConfirmedCount = provinceConfirmedCount;
    }

    public Integer getProvinceSuspectedCount() {
        return provinceSuspectedCount;
    }

    public void setProvinceSuspectedCount(Integer provinceSuspectedCount) {
        this.provinceSuspectedCount = provinceSuspectedCount;
    }

    public Integer getProvinceCuredCount() {
        return provinceCuredCount;
    }

    public void setProvinceCuredCount(Integer provinceCuredCount) {
        this.provinceCuredCount = provinceCuredCount;
    }

    public Integer getProvinceDeadCount() {
        return provinceDeadCount;
    }

    public void setProvinceDeadCount(Integer provinceDeadCount) {
        this.provinceDeadCount = provinceDeadCount;
    }
}
