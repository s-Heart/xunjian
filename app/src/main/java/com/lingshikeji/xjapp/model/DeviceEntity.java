package com.lingshikeji.xjapp.model;

import java.util.List;

/**
 * Author: tony(110618445@qq.com)
 * Date: 2017/4/2
 * Time: 下午12:45
 * Description:
 */
public class DeviceEntity {


    /**
     * contributors : [{"username":"admin","email":"admin@admin.com","lang":"zh_CN","template":"default","id_ref":"1","provider":"local","id":1,"createdAt":"2017-03-27T15:09:12.000Z","updatedAt":"2017-03-27T15:09:12.000Z"}]
     * createdBy : {"username":"admin","email":"admin@admin.com","lang":"zh_CN","template":"default","id_ref":"1","provider":"local","id":1,"createdAt":"2017-03-27T15:09:12.000Z","updatedAt":"2017-03-27T15:09:12.000Z"}
     * updatedBy : {"username":"admin","email":"admin@admin.com","lang":"zh_CN","template":"default","id_ref":"1","provider":"local","id":1,"createdAt":"2017-03-27T15:09:12.000Z","updatedAt":"2017-03-27T15:09:12.000Z"}
     * name : 模拟测试设备
     * contact : 模拟联系人
     * address : 北京市海淀区上庄路135号
     * model : SIM-TEST
     * serialnumber : 55648812347789214
     * manufacture : 模拟制造商
     * remark : 备注信息
     * lang : zh_CN
     * template : default
     * id_ref : null
     * id : 1
     * createdAt : 2017-04-02T02:50:21.000Z
     * updatedAt : 2017-04-02T02:51:33.000Z
     */

    private CreatedByBean createdBy;
    private UpdatedByBean updatedBy;
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
    private List<ContributorsBean> contributors;

    public CreatedByBean getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(CreatedByBean createdBy) {
        this.createdBy = createdBy;
    }

    public UpdatedByBean getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(UpdatedByBean updatedBy) {
        this.updatedBy = updatedBy;
    }

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

    public List<ContributorsBean> getContributors() {
        return contributors;
    }

    public void setContributors(List<ContributorsBean> contributors) {
        this.contributors = contributors;
    }

    public static class CreatedByBean {
        /**
         * username : admin
         * email : admin@admin.com
         * lang : zh_CN
         * template : default
         * id_ref : 1
         * provider : local
         * id : 1
         * createdAt : 2017-03-27T15:09:12.000Z
         * updatedAt : 2017-03-27T15:09:12.000Z
         */

        private String username;
        private String email;
        private String lang;
        private String template;
        private String id_ref;
        private String provider;
        private int id;
        private String createdAt;
        private String updatedAt;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
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

        public String getId_ref() {
            return id_ref;
        }

        public void setId_ref(String id_ref) {
            this.id_ref = id_ref;
        }

        public String getProvider() {
            return provider;
        }

        public void setProvider(String provider) {
            this.provider = provider;
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

    public static class UpdatedByBean {
        /**
         * username : admin
         * email : admin@admin.com
         * lang : zh_CN
         * template : default
         * id_ref : 1
         * provider : local
         * id : 1
         * createdAt : 2017-03-27T15:09:12.000Z
         * updatedAt : 2017-03-27T15:09:12.000Z
         */

        private String username;
        private String email;
        private String lang;
        private String template;
        private String id_ref;
        private String provider;
        private int id;
        private String createdAt;
        private String updatedAt;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
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

        public String getId_ref() {
            return id_ref;
        }

        public void setId_ref(String id_ref) {
            this.id_ref = id_ref;
        }

        public String getProvider() {
            return provider;
        }

        public void setProvider(String provider) {
            this.provider = provider;
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

    public static class ContributorsBean {
        /**
         * username : admin
         * email : admin@admin.com
         * lang : zh_CN
         * template : default
         * id_ref : 1
         * provider : local
         * id : 1
         * createdAt : 2017-03-27T15:09:12.000Z
         * updatedAt : 2017-03-27T15:09:12.000Z
         */

        private String username;
        private String email;
        private String lang;
        private String template;
        private String id_ref;
        private String provider;
        private int id;
        private String createdAt;
        private String updatedAt;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
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

        public String getId_ref() {
            return id_ref;
        }

        public void setId_ref(String id_ref) {
            this.id_ref = id_ref;
        }

        public String getProvider() {
            return provider;
        }

        public void setProvider(String provider) {
            this.provider = provider;
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
}
