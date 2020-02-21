package com.scs.npc.dto;/*@ClassName Rumors
 *@Description:todo
 *@author yc_shang
 *@Date2020/2/21
 *@Version 1.0
 **/

public class Rumors {
    private String rumorType;
    private String title;
    private String body;
    private String mainSummary;

    public Rumors() {
    }

    public Rumors(String rumorType, String title, String body, String mainSummary) {
        this.rumorType = rumorType;
        this.title = title;
        this.body = body;
        this.mainSummary = mainSummary;
    }

    public String getRumorType() {
        return rumorType;
    }

    public void setRumorType(String rumorType) {
        this.rumorType = rumorType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getMainSummary() {
        return mainSummary;
    }

    public void setMainSummary(String mainSummary) {
        this.mainSummary = mainSummary;
    }
}
