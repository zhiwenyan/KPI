package com.kpi.bean;

import java.util.List;


public class KpiTrendTime {



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
        private Object datato;
        private Object datafrom;
        private String imgType;
        private String data;
        private String searchType;
        private String msg;
        private String lstKpiUrl;


        private List<DataListDetailEntity> dataListDetail;

        public void setDatato(Object datato) {
            this.datato = datato;
        }

        public void setDatafrom(Object datafrom) {
            this.datafrom = datafrom;
        }

        public void setImgType(String imgType) {
            this.imgType = imgType;
        }

        public void setData(String data) {
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

        public Object getDatato() {
            return datato;
        }

        public Object getDatafrom() {
            return datafrom;
        }

        public String getImgType() {
            return imgType;
        }

        public String getData() {
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
            private String DHour;
            private int addCount;
            private int customerCount;
            private Object database;
            private Object dateMd;
            private Object dateYmd;
            private int scanCount;

            public void setDDate(String DDate) {
                this.DDate = DDate;
            }

            public void setDHour(String DHour) {
                this.DHour = DHour;
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

            public void setDateMd(Object dateMd) {
                this.dateMd = dateMd;
            }

            public void setDateYmd(Object dateYmd) {
                this.dateYmd = dateYmd;
            }

            public void setScanCount(int scanCount) {
                this.scanCount = scanCount;
            }

            public String getDDate() {
                return DDate;
            }

            public String getDHour() {
                return DHour;
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

            public Object getDateMd() {
                return dateMd;
            }

            public Object getDateYmd() {
                return dateYmd;
            }

            public int getScanCount() {
                return scanCount;
            }
        }
    }
}
