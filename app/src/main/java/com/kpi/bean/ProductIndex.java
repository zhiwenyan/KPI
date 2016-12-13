package com.kpi.bean;

import java.util.List;

public class ProductIndex {


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
        private int code;
        private String imageurl;
        private String msg;
        private List<DataListTotilEntity> dataListTotil;

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
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

        public static class DataListTotilEntity {
            private Object area;
            private Object areaId;
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

            public Object getAreaId() {
                return areaId;
            }

            public void setAreaId(Object areaId) {
                this.areaId = areaId;
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
