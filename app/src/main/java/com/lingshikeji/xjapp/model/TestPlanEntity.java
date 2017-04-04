package com.lingshikeji.xjapp.model;

import java.io.Serializable;
import java.util.List;


/**
 * Author: tony(110618445@qq.com)
 * Date: 2017/4/4
 * Time: 下午3:36
 * Description:
 */
public class TestPlanEntity implements Serializable {

    /**
     * contributors : [{"username":"admin","email":"admin@admin.com","lang":"zh_CN","template":"default","id_ref":"1","provider":"local","id":1,"createdAt":"2017-03-27T15:09:12.000Z","updatedAt":"2017-03-27T15:09:12.000Z"}]
     * testdatas : []
     * createdBy : {"username":"admin","email":"admin@admin.com","lang":"zh_CN","template":"default","id_ref":"1","provider":"local","id":1,"createdAt":"2017-03-27T15:09:12.000Z","updatedAt":"2017-03-27T15:09:12.000Z"}
     * updatedBy : {"username":"admin","email":"admin@admin.com","lang":"zh_CN","template":"default","id_ref":"1","provider":"local","id":1,"createdAt":"2017-03-27T15:09:12.000Z","updatedAt":"2017-03-27T15:09:12.000Z"}
     * instrument : {"name":"突突突","model":"看看","serialnumber":"啦啦啦啦","certnumber":"来来来","techInfo":"啦啦啦啦","validdate":"2045-12-31T16:00:00.000Z","manufacture":"哈哈","remark":"哈哈哈","lang":"zh_CN","template":"default","id_ref":null,"id":3,"createdAt":"2017-04-02T13:57:05.000Z","updatedAt":"2017-04-02T13:57:05.000Z","createdBy":1,"updatedBy":1,"owner":null}
     * device : {"name":"ฅ(♡ơ \u2083ơ)ฅ超级666","contact":"shishaojie","address":"haidian","model":"666","serialnumber":"666","manufacture":"666厂商","remark":"就是溜","lang":"zh_CN","template":"default","id_ref":null,"id":13,"createdAt":"2017-04-02T12:30:18.000Z","updatedAt":"2017-04-02T12:30:18.000Z","createdBy":1,"updatedBy":1}
     * standard : {"name":"模拟测试标准","standardcode":"SIMSTANDAR1","description":"模拟测试依据技术条件","lang":"zh_CN","template":"default","id_ref":null,"id":1,"createdAt":"2017-04-02T03:38:32.000Z","updatedAt":"2017-04-02T03:39:27.000Z","createdBy":1,"updatedBy":1}
     * sampleinterval : 5
     * samplequantity : 1
     * starttime : 2017-04-05T00:00:00.000Z
     * temperaturesensorcount : 1
     * humiditysensorcount : 1
     * temperatureExt : 2
     * humidityExt : 22
     * meantemperature : 1
     * meanhumidity : 1
     * lang : zh_CN
     * template : default
     * id_ref : null
     * id : 3
     * createdAt : 2017-04-04T06:39:11.000Z
     * updatedAt : 2017-04-04T06:39:11.000Z
     */

    private InstrumentBean instrument;
    private DeviceBean device;
    private StandardBean standard;
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
    private List<?> testdatas;


    public InstrumentBean getInstrument() {
        return instrument;
    }

    public void setInstrument(InstrumentBean instrument) {
        this.instrument = instrument;
    }

    public DeviceBean getDevice() {
        return device;
    }

    public void setDevice(DeviceBean device) {
        this.device = device;
    }

    public StandardBean getStandard() {
        return standard;
    }

    public void setStandard(StandardBean standard) {
        this.standard = standard;
    }

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


    public List<?> getTestdatas() {
        return testdatas;
    }

    public void setTestdatas(List<?> testdatas) {
        this.testdatas = testdatas;
    }


    public static class InstrumentBean {
        /**
         * name : 突突突
         * model : 看看
         * serialnumber : 啦啦啦啦
         * certnumber : 来来来
         * techInfo : 啦啦啦啦
         * validdate : 2045-12-31T16:00:00.000Z
         * manufacture : 哈哈
         * remark : 哈哈哈
         * lang : zh_CN
         * template : default
         * id_ref : null
         * id : 3
         * createdAt : 2017-04-02T13:57:05.000Z
         * updatedAt : 2017-04-02T13:57:05.000Z
         * createdBy : 1
         * updatedBy : 1
         * owner : null
         */

        private String name;
        private String model;
        private String serialnumber;
        private String certnumber;
        private String techInfo;
        private String validdate;
        private String manufacture;
        private String remark;
        private String lang;
        private String template;
        private Object id_ref;
        private int id;
        private String createdAt;
        private String updatedAt;
        private int createdBy;
        private int updatedBy;
        private Object owner;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public String getSerialnumber() {
            return serialnumber;
        }

        public void setSerialnumber(String serialnumber) {
            this.serialnumber = serialnumber;
        }

        public String getCertnumber() {
            return certnumber;
        }

        public void setCertnumber(String certnumber) {
            this.certnumber = certnumber;
        }

        public String getTechInfo() {
            return techInfo;
        }

        public void setTechInfo(String techInfo) {
            this.techInfo = techInfo;
        }

        public String getValiddate() {
            return validdate;
        }

        public void setValiddate(String validdate) {
            this.validdate = validdate;
        }

        public String getManufacture() {
            return manufacture;
        }

        public void setManufacture(String manufacture) {
            this.manufacture = manufacture;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
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

        public int getCreatedBy() {
            return createdBy;
        }

        public void setCreatedBy(int createdBy) {
            this.createdBy = createdBy;
        }

        public int getUpdatedBy() {
            return updatedBy;
        }

        public void setUpdatedBy(int updatedBy) {
            this.updatedBy = updatedBy;
        }

        public Object getOwner() {
            return owner;
        }

        public void setOwner(Object owner) {
            this.owner = owner;
        }
    }

    public static class DeviceBean {
        /**
         * name : ฅ(♡ơ ₃ơ)ฅ超级666
         * contact : shishaojie
         * address : haidian
         * model : 666
         * serialnumber : 666
         * manufacture : 666厂商
         * remark : 就是溜
         * lang : zh_CN
         * template : default
         * id_ref : null
         * id : 13
         * createdAt : 2017-04-02T12:30:18.000Z
         * updatedAt : 2017-04-02T12:30:18.000Z
         * createdBy : 1
         * updatedBy : 1
         */

        private String name;
        private String contact;
        private String address;
        private String model;
        private String serialnumber;
        private String manufacture;
        private String remark;
        private String lang;
        private String template;
        private Object id_ref;
        private int id;
        private String createdAt;
        private String updatedAt;
        private int createdBy;
        private int updatedBy;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getContact() {
            return contact;
        }

        public void setContact(String contact) {
            this.contact = contact;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public String getSerialnumber() {
            return serialnumber;
        }

        public void setSerialnumber(String serialnumber) {
            this.serialnumber = serialnumber;
        }

        public String getManufacture() {
            return manufacture;
        }

        public void setManufacture(String manufacture) {
            this.manufacture = manufacture;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
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

        public int getCreatedBy() {
            return createdBy;
        }

        public void setCreatedBy(int createdBy) {
            this.createdBy = createdBy;
        }

        public int getUpdatedBy() {
            return updatedBy;
        }

        public void setUpdatedBy(int updatedBy) {
            this.updatedBy = updatedBy;
        }
    }

    public static class StandardBean {
        /**
         * name : 模拟测试标准
         * standardcode : SIMSTANDAR1
         * description : 模拟测试依据技术条件
         * lang : zh_CN
         * template : default
         * id_ref : null
         * id : 1
         * createdAt : 2017-04-02T03:38:32.000Z
         * updatedAt : 2017-04-02T03:39:27.000Z
         * createdBy : 1
         * updatedBy : 1
         */

        private String name;
        private String standardcode;
        private String description;
        private String lang;
        private String template;
        private Object id_ref;
        private int id;
        private String createdAt;
        private String updatedAt;
        private int createdBy;
        private int updatedBy;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getStandardcode() {
            return standardcode;
        }

        public void setStandardcode(String standardcode) {
            this.standardcode = standardcode;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
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

        public int getCreatedBy() {
            return createdBy;
        }

        public void setCreatedBy(int createdBy) {
            this.createdBy = createdBy;
        }

        public int getUpdatedBy() {
            return updatedBy;
        }

        public void setUpdatedBy(int updatedBy) {
            this.updatedBy = updatedBy;
        }
    }

}
