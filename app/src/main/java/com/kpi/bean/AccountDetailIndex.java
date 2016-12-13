package com.kpi.bean;

import java.util.List;


public class AccountDetailIndex {

    private DataEntity data;

    private boolean success;

    public DataEntity getData() {
        return data;
    }

    public void setData(DataEntity data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public static class DataEntity {


        private CustomerSoapEntity customerSoap;
        private String imageurl;
        private String msg;

        private List<DataListTotilEntity> dataListTotil;

        public CustomerSoapEntity getCustomerSoap() {
            return customerSoap;
        }

        public void setCustomerSoap(CustomerSoapEntity customerSoap) {
            this.customerSoap = customerSoap;
        }

        public String getImageurl() {
            return imageurl;
        }

        public void setImageurl(String imageurl) {
            this.imageurl = imageurl;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public List<DataListTotilEntity> getDataListTotil() {
            return dataListTotil;
        }

        public void setDataListTotil(List<DataListTotilEntity> dataListTotil) {
            this.dataListTotil = dataListTotil;
        }

        public static class CustomerSoapEntity {
            private Object age;
            private Object allowActivityDM;
            private Object allowActivityEDM;
            private Object allowActivityMobile;
            private Object allowActivitySMS;
            private Object allowActivityWechat;
            private Object allowAfternoonContact;
            private Object allowEveningContact;
            private Object allowMorningContact;
            private Object allowRightDM;
            private Object allowRightEDM;
            private Object allowRightMobile;
            private Object allowRightSMS;
            private Object allowRightWechat;
            private Object birthD;
            private Object birthM;
            private Object birthY;
            private Object birthday;
            private Object cardNumber;
            private Object cardType;
            private Object career;
            private Object child;
            private Object code;
            private Object country;
            private Object createdCounter;
            private Object createdSales;
            private Object createdTime;
            private Object createdUser;
            private String customerId;
            private Object database;
            private Object education;
            private Object email;
            private Object emailStatus;
            private Object enrollTime;
            private Object fax;
            private Object firstName;
            private Object firstScanTime;
            private Object gender;
            private Object homeTel;
            private Object joinedCounter;
            private Object joinedSales;
            private String lastName;
            private Object lastUpdateTime;
            private Object lastUpdateUser;
            private Object married;
            private Object masterCustomerId;
            private Object membershipType;
            private Object mgmId;
            private Object mgmTime;
            private Object mgmType;
            private String mobile;
            private String mobileArea;
            private Object mobileStatus;
            private Object officeTel;
            private Object posCode;
            private Object rawId;
            private Object remark;
            private String remark1;
            private Object remark2;
            private Object remark3;
            private Object remark4;
            private Object remark5;
            private Object serviceCounter;
            private Object sourceType;
            private Object status;
            private Object tel;
            private Object wechatId;
            private Object wechatJoinedTime;

            public Object getAge() {
                return age;
            }

            public void setAge(Object age) {
                this.age = age;
            }

            public Object getAllowActivityDM() {
                return allowActivityDM;
            }

            public void setAllowActivityDM(Object allowActivityDM) {
                this.allowActivityDM = allowActivityDM;
            }

            public Object getAllowActivityEDM() {
                return allowActivityEDM;
            }

            public void setAllowActivityEDM(Object allowActivityEDM) {
                this.allowActivityEDM = allowActivityEDM;
            }

            public Object getAllowActivityMobile() {
                return allowActivityMobile;
            }

            public void setAllowActivityMobile(Object allowActivityMobile) {
                this.allowActivityMobile = allowActivityMobile;
            }

            public Object getAllowActivitySMS() {
                return allowActivitySMS;
            }

            public void setAllowActivitySMS(Object allowActivitySMS) {
                this.allowActivitySMS = allowActivitySMS;
            }

            public Object getAllowActivityWechat() {
                return allowActivityWechat;
            }

            public void setAllowActivityWechat(Object allowActivityWechat) {
                this.allowActivityWechat = allowActivityWechat;
            }

            public Object getAllowAfternoonContact() {
                return allowAfternoonContact;
            }

            public void setAllowAfternoonContact(Object allowAfternoonContact) {
                this.allowAfternoonContact = allowAfternoonContact;
            }

            public Object getAllowEveningContact() {
                return allowEveningContact;
            }

            public void setAllowEveningContact(Object allowEveningContact) {
                this.allowEveningContact = allowEveningContact;
            }

            public Object getAllowMorningContact() {
                return allowMorningContact;
            }

            public void setAllowMorningContact(Object allowMorningContact) {
                this.allowMorningContact = allowMorningContact;
            }

            public Object getAllowRightDM() {
                return allowRightDM;
            }

            public void setAllowRightDM(Object allowRightDM) {
                this.allowRightDM = allowRightDM;
            }

            public Object getAllowRightEDM() {
                return allowRightEDM;
            }

            public void setAllowRightEDM(Object allowRightEDM) {
                this.allowRightEDM = allowRightEDM;
            }

            public Object getAllowRightMobile() {
                return allowRightMobile;
            }

            public void setAllowRightMobile(Object allowRightMobile) {
                this.allowRightMobile = allowRightMobile;
            }

            public Object getAllowRightSMS() {
                return allowRightSMS;
            }

            public void setAllowRightSMS(Object allowRightSMS) {
                this.allowRightSMS = allowRightSMS;
            }

            public Object getAllowRightWechat() {
                return allowRightWechat;
            }

            public void setAllowRightWechat(Object allowRightWechat) {
                this.allowRightWechat = allowRightWechat;
            }

            public Object getBirthD() {
                return birthD;
            }

            public void setBirthD(Object birthD) {
                this.birthD = birthD;
            }

            public Object getBirthM() {
                return birthM;
            }

            public void setBirthM(Object birthM) {
                this.birthM = birthM;
            }

            public Object getBirthY() {
                return birthY;
            }

            public void setBirthY(Object birthY) {
                this.birthY = birthY;
            }

            public Object getBirthday() {
                return birthday;
            }

            public void setBirthday(Object birthday) {
                this.birthday = birthday;
            }

            public Object getCardNumber() {
                return cardNumber;
            }

            public void setCardNumber(Object cardNumber) {
                this.cardNumber = cardNumber;
            }

            public Object getCardType() {
                return cardType;
            }

            public void setCardType(Object cardType) {
                this.cardType = cardType;
            }

            public Object getCareer() {
                return career;
            }

            public void setCareer(Object career) {
                this.career = career;
            }

            public Object getChild() {
                return child;
            }

            public void setChild(Object child) {
                this.child = child;
            }

            public Object getCode() {
                return code;
            }

            public void setCode(Object code) {
                this.code = code;
            }

            public Object getCountry() {
                return country;
            }

            public void setCountry(Object country) {
                this.country = country;
            }

            public Object getCreatedCounter() {
                return createdCounter;
            }

            public void setCreatedCounter(Object createdCounter) {
                this.createdCounter = createdCounter;
            }

            public Object getCreatedSales() {
                return createdSales;
            }

            public void setCreatedSales(Object createdSales) {
                this.createdSales = createdSales;
            }

            public Object getCreatedTime() {
                return createdTime;
            }

            public void setCreatedTime(Object createdTime) {
                this.createdTime = createdTime;
            }

            public Object getCreatedUser() {
                return createdUser;
            }

            public void setCreatedUser(Object createdUser) {
                this.createdUser = createdUser;
            }

            public String getCustomerId() {
                return customerId;
            }

            public void setCustomerId(String customerId) {
                this.customerId = customerId;
            }

            public Object getDatabase() {
                return database;
            }

            public void setDatabase(Object database) {
                this.database = database;
            }

            public Object getEducation() {
                return education;
            }

            public void setEducation(Object education) {
                this.education = education;
            }

            public Object getEmail() {
                return email;
            }

            public void setEmail(Object email) {
                this.email = email;
            }

            public Object getEmailStatus() {
                return emailStatus;
            }

            public void setEmailStatus(Object emailStatus) {
                this.emailStatus = emailStatus;
            }

            public Object getEnrollTime() {
                return enrollTime;
            }

            public void setEnrollTime(Object enrollTime) {
                this.enrollTime = enrollTime;
            }

            public Object getFax() {
                return fax;
            }

            public void setFax(Object fax) {
                this.fax = fax;
            }

            public Object getFirstName() {
                return firstName;
            }

            public void setFirstName(Object firstName) {
                this.firstName = firstName;
            }

            public Object getFirstScanTime() {
                return firstScanTime;
            }

            public void setFirstScanTime(Object firstScanTime) {
                this.firstScanTime = firstScanTime;
            }

            public Object getGender() {
                return gender;
            }

            public void setGender(Object gender) {
                this.gender = gender;
            }

            public Object getHomeTel() {
                return homeTel;
            }

            public void setHomeTel(Object homeTel) {
                this.homeTel = homeTel;
            }

            public Object getJoinedCounter() {
                return joinedCounter;
            }

            public void setJoinedCounter(Object joinedCounter) {
                this.joinedCounter = joinedCounter;
            }

            public Object getJoinedSales() {
                return joinedSales;
            }

            public void setJoinedSales(Object joinedSales) {
                this.joinedSales = joinedSales;
            }

            public String getLastName() {
                return lastName;
            }

            public void setLastName(String lastName) {
                this.lastName = lastName;
            }

            public Object getLastUpdateTime() {
                return lastUpdateTime;
            }

            public void setLastUpdateTime(Object lastUpdateTime) {
                this.lastUpdateTime = lastUpdateTime;
            }

            public Object getLastUpdateUser() {
                return lastUpdateUser;
            }

            public void setLastUpdateUser(Object lastUpdateUser) {
                this.lastUpdateUser = lastUpdateUser;
            }

            public Object getMarried() {
                return married;
            }

            public void setMarried(Object married) {
                this.married = married;
            }

            public Object getMasterCustomerId() {
                return masterCustomerId;
            }

            public void setMasterCustomerId(Object masterCustomerId) {
                this.masterCustomerId = masterCustomerId;
            }

            public Object getMembershipType() {
                return membershipType;
            }

            public void setMembershipType(Object membershipType) {
                this.membershipType = membershipType;
            }

            public Object getMgmId() {
                return mgmId;
            }

            public void setMgmId(Object mgmId) {
                this.mgmId = mgmId;
            }

            public Object getMgmTime() {
                return mgmTime;
            }

            public void setMgmTime(Object mgmTime) {
                this.mgmTime = mgmTime;
            }

            public Object getMgmType() {
                return mgmType;
            }

            public void setMgmType(Object mgmType) {
                this.mgmType = mgmType;
            }

            public String getMobile() {
                return mobile;
            }

            public void setMobile(String mobile) {
                this.mobile = mobile;
            }

            public String getMobileArea() {
                return mobileArea;
            }

            public void setMobileArea(String mobileArea) {
                this.mobileArea = mobileArea;
            }

            public Object getMobileStatus() {
                return mobileStatus;
            }

            public void setMobileStatus(Object mobileStatus) {
                this.mobileStatus = mobileStatus;
            }

            public Object getOfficeTel() {
                return officeTel;
            }

            public void setOfficeTel(Object officeTel) {
                this.officeTel = officeTel;
            }

            public Object getPosCode() {
                return posCode;
            }

            public void setPosCode(Object posCode) {
                this.posCode = posCode;
            }

            public Object getRawId() {
                return rawId;
            }

            public void setRawId(Object rawId) {
                this.rawId = rawId;
            }

            public Object getRemark() {
                return remark;
            }

            public void setRemark(Object remark) {
                this.remark = remark;
            }

            public String getRemark1() {
                return remark1;
            }

            public void setRemark1(String remark1) {
                this.remark1 = remark1;
            }

            public Object getRemark2() {
                return remark2;
            }

            public void setRemark2(Object remark2) {
                this.remark2 = remark2;
            }

            public Object getRemark3() {
                return remark3;
            }

            public void setRemark3(Object remark3) {
                this.remark3 = remark3;
            }

            public Object getRemark4() {
                return remark4;
            }

            public void setRemark4(Object remark4) {
                this.remark4 = remark4;
            }

            public Object getRemark5() {
                return remark5;
            }

            public void setRemark5(Object remark5) {
                this.remark5 = remark5;
            }

            public Object getServiceCounter() {
                return serviceCounter;
            }

            public void setServiceCounter(Object serviceCounter) {
                this.serviceCounter = serviceCounter;
            }

            public Object getSourceType() {
                return sourceType;
            }

            public void setSourceType(Object sourceType) {
                this.sourceType = sourceType;
            }

            public Object getStatus() {
                return status;
            }

            public void setStatus(Object status) {
                this.status = status;
            }

            public Object getTel() {
                return tel;
            }

            public void setTel(Object tel) {
                this.tel = tel;
            }

            public Object getWechatId() {
                return wechatId;
            }

            public void setWechatId(Object wechatId) {
                this.wechatId = wechatId;
            }

            public Object getWechatJoinedTime() {
                return wechatJoinedTime;
            }

            public void setWechatJoinedTime(Object wechatJoinedTime) {
                this.wechatJoinedTime = wechatJoinedTime;
            }
        }

        public static class DataListTotilEntity {
            private Object area;
            private Object database;
            private Object ddate;
            private Object ddatefrom;
            private Object ddatefromMom;
            private Object ddateto;
            private Object ddatetoMom;
            private Object lastUpdateTime;
            private Object limit;
            private Object order;
            private String productId;
            private String productName;
            private Object scanAddCount;
            private Object scanAddCountMom;
            private int scanCount;
            private String scanCountMom;
            private int scanCustomerCount;
            private String scanCustomerCountMom;

            public Object getArea() {
                return area;
            }

            public void setArea(Object area) {
                this.area = area;
            }

            public Object getDatabase() {
                return database;
            }

            public void setDatabase(Object database) {
                this.database = database;
            }

            public Object getDdate() {
                return ddate;
            }

            public void setDdate(Object ddate) {
                this.ddate = ddate;
            }

            public Object getDdatefrom() {
                return ddatefrom;
            }

            public void setDdatefrom(Object ddatefrom) {
                this.ddatefrom = ddatefrom;
            }

            public Object getDdatefromMom() {
                return ddatefromMom;
            }

            public void setDdatefromMom(Object ddatefromMom) {
                this.ddatefromMom = ddatefromMom;
            }

            public Object getDdateto() {
                return ddateto;
            }

            public void setDdateto(Object ddateto) {
                this.ddateto = ddateto;
            }

            public Object getDdatetoMom() {
                return ddatetoMom;
            }

            public void setDdatetoMom(Object ddatetoMom) {
                this.ddatetoMom = ddatetoMom;
            }

            public Object getLastUpdateTime() {
                return lastUpdateTime;
            }

            public void setLastUpdateTime(Object lastUpdateTime) {
                this.lastUpdateTime = lastUpdateTime;
            }

            public Object getLimit() {
                return limit;
            }

            public void setLimit(Object limit) {
                this.limit = limit;
            }

            public Object getOrder() {
                return order;
            }

            public void setOrder(Object order) {
                this.order = order;
            }

            public String getProductId() {
                return productId;
            }

            public void setProductId(String productId) {
                this.productId = productId;
            }

            public String getProductName() {
                return productName;
            }

            public void setProductName(String productName) {
                this.productName = productName;
            }

            public Object getScanAddCount() {
                return scanAddCount;
            }

            public void setScanAddCount(Object scanAddCount) {
                this.scanAddCount = scanAddCount;
            }

            public Object getScanAddCountMom() {
                return scanAddCountMom;
            }

            public void setScanAddCountMom(Object scanAddCountMom) {
                this.scanAddCountMom = scanAddCountMom;
            }

            public int getScanCount() {
                return scanCount;
            }

            public void setScanCount(int scanCount) {
                this.scanCount = scanCount;
            }

            public String getScanCountMom() {
                return scanCountMom;
            }

            public void setScanCountMom(String scanCountMom) {
                this.scanCountMom = scanCountMom;
            }

            public int getScanCustomerCount() {
                return scanCustomerCount;
            }

            public void setScanCustomerCount(int scanCustomerCount) {
                this.scanCustomerCount = scanCustomerCount;
            }

            public String getScanCustomerCountMom() {
                return scanCustomerCountMom;
            }

            public void setScanCustomerCountMom(String scanCustomerCountMom) {
                this.scanCustomerCountMom = scanCustomerCountMom;
            }
        }
    }
}
