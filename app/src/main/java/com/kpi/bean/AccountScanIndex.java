package com.kpi.bean;

import java.util.List;

public class AccountScanIndex {

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
        private String msg;

        private List<DetailListEntity> detailList;

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public List<DetailListEntity> getDetailList() {
            return detailList;
        }

        public void setDetailList(List<DetailListEntity> detailList) {
            this.detailList = detailList;
        }

        public static class DetailListEntity {
            private Object condition;
            private int count;
            private String countMom;
            private String customerId;
            private Object database;
            private Object ddate;
            private Object ddatefrom;
            private Object ddatefromMom;
            private Object ddateto;
            private Object ddatetoMom;
            private Object order;
            private Object pageCount;
            private Object pageStart;

            public Object getCondition() {
                return condition;
            }

            public void setCondition(Object condition) {
                this.condition = condition;
            }

            public int getCount() {
                return count;
            }

            public void setCount(int count) {
                this.count = count;
            }

            public String getCountMom() {
                return countMom;
            }

            public void setCountMom(String countMom) {
                this.countMom = countMom;
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

            public Object getOrder() {
                return order;
            }

            public void setOrder(Object order) {
                this.order = order;
            }

            public Object getPageCount() {
                return pageCount;
            }

            public void setPageCount(Object pageCount) {
                this.pageCount = pageCount;
            }

            public Object getPageStart() {
                return pageStart;
            }

            public void setPageStart(Object pageStart) {
                this.pageStart = pageStart;
            }
        }
    }
}
