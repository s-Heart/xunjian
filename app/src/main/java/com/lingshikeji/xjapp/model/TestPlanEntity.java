package com.lingshikeji.xjapp.model;

import java.io.Serializable;

/**
 * Created by tony on 2017/4/4.
 */

public class TestPlanEntity implements Serializable {

    /**
     * sampleinterval : 1
     * samplequantity : 1
     * starttime : 2017-04-04T00:00:00.000Z
     * temperaturesensorcount : 1
     * humiditysensorcount : 1
     * temperatureExt : 1
     * humidityExt : 1
     * meantemperature : 1
     * meanhumidity : 1
     * lang : zh_CN
     * template : default
     * id_ref : null
     * id : 2
     * createdAt : 2017-04-04T06:36:03.000Z
     * updatedAt : 2017-04-04T06:36:03.000Z
     */

    private int sampleinterval;
    private String samplequantity;
    private String starttime;
    private String temperaturesensorcount;
    private String humiditysensorcount;
    private String temperatureExt;
    private String humidityExt;
    private String meantemperature;
    private String meanhumidity;
    private String lang;
    private String template;
    private Object id_ref;
    private int id;
    private String createdAt;
    private String updatedAt;

    public int getSampleinterval() {
        return sampleinterval;
    }

    public void setSampleinterval(int sampleinterval) {
        this.sampleinterval = sampleinterval;
    }

    public String getSamplequantity() {
        return samplequantity;
    }

    public void setSamplequantity(String samplequantity) {
        this.samplequantity = samplequantity;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getTemperaturesensorcount() {
        return temperaturesensorcount;
    }

    public void setTemperaturesensorcount(String temperaturesensorcount) {
        this.temperaturesensorcount = temperaturesensorcount;
    }

    public String getHumiditysensorcount() {
        return humiditysensorcount;
    }

    public void setHumiditysensorcount(String humiditysensorcount) {
        this.humiditysensorcount = humiditysensorcount;
    }

    public String getTemperatureExt() {
        return temperatureExt;
    }

    public void setTemperatureExt(String temperatureExt) {
        this.temperatureExt = temperatureExt;
    }

    public String getHumidityExt() {
        return humidityExt;
    }

    public void setHumidityExt(String humidityExt) {
        this.humidityExt = humidityExt;
    }

    public String getMeantemperature() {
        return meantemperature;
    }

    public void setMeantemperature(String meantemperature) {
        this.meantemperature = meantemperature;
    }

    public String getMeanhumidity() {
        return meanhumidity;
    }

    public void setMeanhumidity(String meanhumidity) {
        this.meanhumidity = meanhumidity;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public Object getId_ref() {
        return id_ref;
    }

    public void setId_ref(Object id_ref) {
        this.id_ref = id_ref;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}
