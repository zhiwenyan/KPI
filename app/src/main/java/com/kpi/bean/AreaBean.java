package com.kpi.bean;


public class AreaBean {
    private String area;  //地区
    private String scanCount; //件数
    private String scanCountMom; //环
    private String scanCustomerCount; //人数
    private String scanCustomerCountMom;  //环比

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getScanCount() {
        return scanCount;
    }

    public void setScanCount(String scanCount) {
        this.scanCount = scanCount;
    }

    public String getScanCountMom() {
        return scanCountMom;
    }

    public void setScanCountMom(String scanCountMom) {
        this.scanCountMom = scanCountMom;
    }

    public String getScanCustomerCount() {
        return scanCustomerCount;
    }

    public void setScanCustomerCount(String scanCustomerCount) {
        this.scanCustomerCount = scanCustomerCount;
    }

    public String getScanCustomerCountMom() {
        return scanCustomerCountMom;
    }

    public void setScanCustomerCountMom(String scanCustomerCountMom) {
        this.scanCustomerCountMom = scanCustomerCountMom;
    }
}
