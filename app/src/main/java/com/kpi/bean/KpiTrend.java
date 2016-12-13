package com.kpi.bean;

import java.util.List;


public class KpiTrend {
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
        private String datato;
        private String datafrom;
        private String imgType;
        private Object data;
        private String searchType;
        private String msg;
        private String lstKpiUrl;

        private List<DataListDetailEntity> dataListDetail;

        public void setDatato(String datato) {
            this.datato = datato;
        }

        public void setDatafrom(String datafrom) {
            this.datafrom = datafrom;
        }

        public void setImgType(String imgType) {
            this.imgType = imgType;
        }

        public void setData(Object data) {
            this.data = data;
        }

        public void setSearchType(String searchType) {
            this.searchType = searchType;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public void setLstKpiUrl(String lstKpiUrl) {
            this.lstKpiUrl = lstKpiUrl;
        }

        public void setDataListDetail(List<DataListDetailEntity> dataListDetail) {
            this.dataListDetail = dataListDetail;
        }

        public String getDatato() {
            return datato;
        }

        public String getDatafrom() {
            return datafrom;
        }

        public String getImgType() {
            return imgType;
        }

        public Object getData() {
            return data;
        }

        public String getSearchType() {
            return searchType;
        }

        public String getMsg() {
            return msg;
        }

        public String getLstKpiUrl() {
            return lstKpiUrl;
        }

        public List<DataListDetailEntity> getDataListDetail() {
            return dataListDetail;
        }

        public static class DataListDetailEntity {
            private String DDate;
            private Object DDatefrom;
            private Object DDateto;
            private int addCount;
            private int customerCount;
            private Object database;
            private String dateMd;
            private String dateYmd;
            private int scanCount;

            public void setDDate(String DDate) {
                this.DDate = DDate;
            }

            public void setDDatefrom(Object DDatefrom) {
                this.DDatefrom = DDatefrom;
            }

            public void setDDateto(Object DDateto) {
                this.DDateto = DDateto;
            }

            public void setAddCount(int addCount) {
                this.addCount = addCount;
            }

            public void setCustomerCount(int customerCount) {
                this.customerCount = customerCount;
            }

            public void setDatabase(Object database) {
                this.database = database;
            }

            public void setDateMd(String dateMd) {
                this.dateMd = dateMd;
            }

            public void setDateYmd(String dateYmd) {
                this.dateYmd = dateYmd;
            }

            public void setScanCount(int scanCount) {
                this.scanCount = scanCount;
            }

            public String getDDate() {
                return DDate;
            }

            public Object getDDatefrom() {
                return DDatefrom;
            }

            public Object getDDateto() {
                return DDateto;
            }

            public int getAddCount() {
                return addCount;
            }

            public int getCustomerCount() {
                return customerCount;
            }

            public Object getDatabase() {
                return database;
            }

            public String getDateMd() {
                return dateMd;
            }

            public String getDateYmd() {
                return dateYmd;
            }

            public int getScanCount() {
                return scanCount;
            }
        }
    }
}
