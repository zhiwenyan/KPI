package com.kpi.bean;

import java.util.List;


public class AreaPerformance {

    private DataEntity data;


    private boolean success;

    public void setData(DataEntity data) {
        this.data = data;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public DataEntity getData() {
        return data;
    }

    public boolean isSuccess() {
        return success;
    }

    public static class DataEntity {
        private String limit;
        private String msg;


        private List<DataListAllEntity> dataListAll;

        private List<DataListDescEntity> dataListDesc;


        private List<DataListAscEntity> dataListAsc;

        public void setLimit(String limit) {
            this.limit = limit;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public void setDataListAll(List<DataListAllEntity> dataListAll) {
            this.dataListAll = dataListAll;
        }

        public void setDataListDesc(List<DataListDescEntity> dataListDesc) {
            this.dataListDesc = dataListDesc;
        }

        public void setDataListAsc(List<DataListAscEntity> dataListAsc) {
            this.dataListAsc = dataListAsc;
        }

        public String getLimit() {
            return limit;
        }

        public String getMsg() {
            return msg;
        }

        public List<DataListAllEntity> getDataListAll() {
            return dataListAll;
        }

        public List<DataListDescEntity> getDataListDesc() {
            return dataListDesc;
        }

        public List<DataListAscEntity> getDataListAsc() {
            return dataListAsc;
        }

        public static class DataListAllEntity {
            private Object DDatefrom;
            private Object DDatefromMom;
            private Object DDateto;
            private Object DDatetoMom;
            private String area;
            private Object database;
            private Object ddate;
            private Object lastUpdateTime;
            private Object limit;
            private Object order;
            private Object scanAddCount;
            private Object scanAddCountMom;
            private int scanCount;
            private String scanCountMom;
            private int scanCustomerCount;
            private String scanCustomerCountMom;
            private Object type;

            public void setDDatefrom(Object DDatefrom) {
                this.DDatefrom = DDatefrom;
            }

            public void setDDatefromMom(Object DDatefromMom) {
                this.DDatefromMom = DDatefromMom;
            }

            public void setDDateto(Object DDateto) {
                this.DDateto = DDateto;
            }

            public void setDDatetoMom(Object DDatetoMom) {
                this.DDatetoMom = DDatetoMom;
            }

            public void setArea(String area) {
                this.area = area;
            }

            public void setDatabase(Object database) {
                this.database = database;
            }

            public void setDdate(Object ddate) {
                this.ddate = ddate;
            }

            public void setLastUpdateTime(Object lastUpdateTime) {
                this.lastUpdateTime = lastUpdateTime;
            }

            public void setLimit(Object limit) {
                this.limit = limit;
            }

            public void setOrder(Object order) {
                this.order = order;
            }

            public void setScanAddCount(Object scanAddCount) {
                this.scanAddCount = scanAddCount;
            }

            public void setScanAddCountMom(Object scanAddCountMom) {
                this.scanAddCountMom = scanAddCountMom;
            }

            public void setScanCount(int scanCount) {
                this.scanCount = scanCount;
            }

            public void setScanCountMom(String scanCountMom) {
                this.scanCountMom = scanCountMom;
            }

            public void setScanCustomerCount(int scanCustomerCount) {
                this.scanCustomerCount = scanCustomerCount;
            }

            public void setScanCustomerCountMom(String scanCustomerCountMom) {
                this.scanCustomerCountMom = scanCustomerCountMom;
            }

            public void setType(Object type) {
                this.type = type;
            }

            public Object getDDatefrom() {
                return DDatefrom;
            }

            public Object getDDatefromMom() {
                return DDatefromMom;
            }

            public Object getDDateto() {
                return DDateto;
            }

            public Object getDDatetoMom() {
                return DDatetoMom;
            }

            public String getArea() {
                return area;
            }

            public Object getDatabase() {
                return database;
            }

            public Object getDdate() {
                return ddate;
            }

            public Object getLastUpdateTime() {
                return lastUpdateTime;
            }

            public Object getLimit() {
                return limit;
            }

            public Object getOrder() {
                return order;
            }

            public Object getScanAddCount() {
                return scanAddCount;
            }

            public Object getScanAddCountMom() {
                return scanAddCountMom;
            }

            public int getScanCount() {
                return scanCount;
            }

            public String getScanCountMom() {
                return scanCountMom;
            }

            public int getScanCustomerCount() {
                return scanCustomerCount;
            }

            public String getScanCustomerCountMom() {
                return scanCustomerCountMom;
            }

            public Object getType() {
                return type;
            }
        }

        public static class DataListDescEntity {
            private Object DDatefrom;
            private Object DDatefromMom;
            private Object DDateto;
            private Object DDatetoMom;
            private String area;
            private Object database;
            private Object ddate;
            private Object lastUpdateTime;
            private Object limit;
            private Object order;
            private Object scanAddCount;
            private Object scanAddCountMom;
            private int scanCount;
            private String scanCountMom;
            private int scanCustomerCount;
            private String scanCustomerCountMom;
            private Object type;

            public void setDDatefrom(Object DDatefrom) {
                this.DDatefrom = DDatefrom;
            }

            public void setDDatefromMom(Object DDatefromMom) {
                this.DDatefromMom = DDatefromMom;
            }

            public void setDDateto(Object DDateto) {
                this.DDateto = DDateto;
            }

            public void setDDatetoMom(Object DDatetoMom) {
                this.DDatetoMom = DDatetoMom;
            }

            public void setArea(String area) {
                this.area = area;
            }

            public void setDatabase(Object database) {
                this.database = database;
            }

            public void setDdate(Object ddate) {
                this.ddate = ddate;
            }

            public void setLastUpdateTime(Object lastUpdateTime) {
                this.lastUpdateTime = lastUpdateTime;
            }

            public void setLimit(Object limit) {
                this.limit = limit;
            }

            public void setOrder(Object order) {
                this.order = order;
            }

            public void setScanAddCount(Object scanAddCount) {
                this.scanAddCount = scanAddCount;
            }

            public void setScanAddCountMom(Object scanAddCountMom) {
                this.scanAddCountMom = scanAddCountMom;
            }

            public void setScanCount(int scanCount) {
                this.scanCount = scanCount;
            }

            public void setScanCountMom(String scanCountMom) {
                this.scanCountMom = scanCountMom;
            }

            public void setScanCustomerCount(int scanCustomerCount) {
                this.scanCustomerCount = scanCustomerCount;
            }

            public void setScanCustomerCountMom(String scanCustomerCountMom) {
                this.scanCustomerCountMom = scanCustomerCountMom;
            }

            public void setType(Object type) {
                this.type = type;
            }

            public Object getDDatefrom() {
                return DDatefrom;
            }

            public Object getDDatefromMom() {
                return DDatefromMom;
            }

            public Object getDDateto() {
                return DDateto;
            }

            public Object getDDatetoMom() {
                return DDatetoMom;
            }

            public String getArea() {
                return area;
            }

            public Object getDatabase() {
                return database;
            }

            public Object getDdate() {
                return ddate;
            }

            public Object getLastUpdateTime() {
                return lastUpdateTime;
            }

            public Object getLimit() {
                return limit;
            }

            public Object getOrder() {
                return order;
            }

            public Object getScanAddCount() {
                return scanAddCount;
            }

            public Object getScanAddCountMom() {
                return scanAddCountMom;
            }

            public int getScanCount() {
                return scanCount;
            }

            public String getScanCountMom() {
                return scanCountMom;
            }

            public int getScanCustomerCount() {
                return scanCustomerCount;
            }

            public String getScanCustomerCountMom() {
                return scanCustomerCountMom;
            }

            public Object getType() {
                return type;
            }
        }

        public static class DataListAscEntity {
            private Object DDatefrom;
            private Object DDatefromMom;
            private Object DDateto;
            private Object DDatetoMom;
            private String area;
            private Object database;
            private Object ddate;
            private Object lastUpdateTime;
            private Object limit;
            private Object order;
            private Object scanAddCount;
            private Object scanAddCountMom;
            private int scanCount;
            private String scanCountMom;
            private int scanCustomerCount;
            private String scanCustomerCountMom;
            private Object type;

            public void setDDatefrom(Object DDatefrom) {
                this.DDatefrom = DDatefrom;
            }

            public void setDDatefromMom(Object DDatefromMom) {
                this.DDatefromMom = DDatefromMom;
            }

            public void setDDateto(Object DDateto) {
                this.DDateto = DDateto;
            }

            public void setDDatetoMom(Object DDatetoMom) {
                this.DDatetoMom = DDatetoMom;
            }

            public void setArea(String area) {
                this.area = area;
            }

            public void setDatabase(Object database) {
                this.database = database;
            }

            public void setDdate(Object ddate) {
                this.ddate = ddate;
            }

            public void setLastUpdateTime(Object lastUpdateTime) {
                this.lastUpdateTime = lastUpdateTime;
            }

            public void setLimit(Object limit) {
                this.limit = limit;
            }

            public void setOrder(Object order) {
                this.order = order;
            }

            public void setScanAddCount(Object scanAddCount) {
                this.scanAddCount = scanAddCount;
            }

            public void setScanAddCountMom(Object scanAddCountMom) {
                this.scanAddCountMom = scanAddCountMom;
            }

            public void setScanCount(int scanCount) {
                this.scanCount = scanCount;
            }

            public void setScanCountMom(String scanCountMom) {
                this.scanCountMom = scanCountMom;
            }

            public void setScanCustomerCount(int scanCustomerCount) {
                this.scanCustomerCount = scanCustomerCount;
            }

            public void setScanCustomerCountMom(String scanCustomerCountMom) {
                this.scanCustomerCountMom = scanCustomerCountMom;
            }

            public void setType(Object type) {
                this.type = type;
            }

            public Object getDDatefrom() {
                return DDatefrom;
            }

            public Object getDDatefromMom() {
                return DDatefromMom;
            }

            public Object getDDateto() {
                return DDateto;
            }

            public Object getDDatetoMom() {
                return DDatetoMom;
            }

            public String getArea() {
                return area;
            }

            public Object getDatabase() {
                return database;
            }

            public Object getDdate() {
                return ddate;
            }

            public Object getLastUpdateTime() {
                return lastUpdateTime;
            }

            public Object getLimit() {
                return limit;
            }

            public Object getOrder() {
                return order;
            }

            public Object getScanAddCount() {
                return scanAddCount;
            }

            public Object getScanAddCountMom() {
                return scanAddCountMom;
            }

            public int getScanCount() {
                return scanCount;
            }

            public String getScanCountMom() {
                return scanCountMom;
            }

            public int getScanCustomerCount() {
                return scanCustomerCount;
            }

            public String getScanCustomerCountMom() {
                return scanCustomerCountMom;
            }

            public Object getType() {
                return type;
            }
        }
    }
}
