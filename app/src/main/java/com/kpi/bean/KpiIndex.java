package com.kpi.bean;


public class KpiIndex {


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


        private DataListEntity dataList;

        public void setDataList(DataListEntity dataList) {
            this.dataList = dataList;
        }

        public DataListEntity getDataList() {
            return dataList;
        }

        public static class DataListEntity {
            private String ScanCountMonthName;
            private String CustomerCountWeekMom;
            private String ScanCountWeekMom;
            private int AddCustomerCount;
            private String ScanCountMonthMom;
            private String ScanCountYearMom;
            private int CustomerCountToday;
            private int ScanCountToday;
            private String CustomerCountYearName;
            private double ScanCountMonth;
            private String CustomerCountMonthMom;
            private String ScanCountWeekName;
            private String CustomerCountWeekName;
            private int ScanQuantityCount;
            private double ScanCountWeek;
            private String ScanCountYearName;
            private double CustomerCountMonth;
            private double CustomerCountWeek;
            private String CustomerCountYearMom;
            private double ScanCountYear;
            private double CustomerCountYear;
            private String CustomerCountTodayMom;
            private int ScanCustomerCount;
            private String ScanCountTodayMom;
            private String CustomerCountMonthName;

            public void setScanCountMonthName(String ScanCountMonthName) {
                this.ScanCountMonthName = ScanCountMonthName;
            }

            public void setCustomerCountWeekMom(String CustomerCountWeekMom) {
                this.CustomerCountWeekMom = CustomerCountWeekMom;
            }

            public void setScanCountWeekMom(String ScanCountWeekMom) {
                this.ScanCountWeekMom = ScanCountWeekMom;
            }

            public void setAddCustomerCount(int AddCustomerCount) {
                this.AddCustomerCount = AddCustomerCount;
            }

            public void setScanCountMonthMom(String ScanCountMonthMom) {
                this.ScanCountMonthMom = ScanCountMonthMom;
            }

            public void setScanCountYearMom(String ScanCountYearMom) {
                this.ScanCountYearMom = ScanCountYearMom;
            }

            public void setCustomerCountToday(int CustomerCountToday) {
                this.CustomerCountToday = CustomerCountToday;
            }

            public void setScanCountToday(int ScanCountToday) {
                this.ScanCountToday = ScanCountToday;
            }

            public void setCustomerCountYearName(String CustomerCountYearName) {
                this.CustomerCountYearName = CustomerCountYearName;
            }

            public void setScanCountMonth(double ScanCountMonth) {
                this.ScanCountMonth = ScanCountMonth;
            }

            public void setCustomerCountMonthMom(String CustomerCountMonthMom) {
                this.CustomerCountMonthMom = CustomerCountMonthMom;
            }

            public void setScanCountWeekName(String ScanCountWeekName) {
                this.ScanCountWeekName = ScanCountWeekName;
            }

            public void setCustomerCountWeekName(String CustomerCountWeekName) {
                this.CustomerCountWeekName = CustomerCountWeekName;
            }

            public void setScanQuantityCount(int ScanQuantityCount) {
                this.ScanQuantityCount = ScanQuantityCount;
            }

            public void setScanCountWeek(double ScanCountWeek) {
                this.ScanCountWeek = ScanCountWeek;
            }

            public void setScanCountYearName(String ScanCountYearName) {
                this.ScanCountYearName = ScanCountYearName;
            }

            public void setCustomerCountMonth(double CustomerCountMonth) {
                this.CustomerCountMonth = CustomerCountMonth;
            }

            public void setCustomerCountWeek(double CustomerCountWeek) {
                this.CustomerCountWeek = CustomerCountWeek;
            }

            public void setCustomerCountYearMom(String CustomerCountYearMom) {
                this.CustomerCountYearMom = CustomerCountYearMom;
            }

            public void setScanCountYear(double ScanCountYear) {
                this.ScanCountYear = ScanCountYear;
            }

            public void setCustomerCountYear(double CustomerCountYear) {
                this.CustomerCountYear = CustomerCountYear;
            }

            public void setCustomerCountTodayMom(String CustomerCountTodayMom) {
                this.CustomerCountTodayMom = CustomerCountTodayMom;
            }

            public void setScanCustomerCount(int ScanCustomerCount) {
                this.ScanCustomerCount = ScanCustomerCount;
            }

            public void setScanCountTodayMom(String ScanCountTodayMom) {
                this.ScanCountTodayMom = ScanCountTodayMom;
            }

            public void setCustomerCountMonthName(String CustomerCountMonthName) {
                this.CustomerCountMonthName = CustomerCountMonthName;
            }

            public String getScanCountMonthName() {
                return ScanCountMonthName;
            }

            public String getCustomerCountWeekMom() {
                return CustomerCountWeekMom;
            }

            public String getScanCountWeekMom() {
                return ScanCountWeekMom;
            }

            public int getAddCustomerCount() {
                return AddCustomerCount;
            }

            public String getScanCountMonthMom() {
                return ScanCountMonthMom;
            }

            public String getScanCountYearMom() {
                return ScanCountYearMom;
            }

            public int getCustomerCountToday() {
                return CustomerCountToday;
            }

            public int getScanCountToday() {
                return ScanCountToday;
            }

            public String getCustomerCountYearName() {
                return CustomerCountYearName;
            }

            public double getScanCountMonth() {
                return ScanCountMonth;
            }

            public String getCustomerCountMonthMom() {
                return CustomerCountMonthMom;
            }

            public String getScanCountWeekName() {
                return ScanCountWeekName;
            }

            public String getCustomerCountWeekName() {
                return CustomerCountWeekName;
            }

            public int getScanQuantityCount() {
                return ScanQuantityCount;
            }

            public double getScanCountWeek() {
                return ScanCountWeek;
            }

            public String getScanCountYearName() {
                return ScanCountYearName;
            }

            public double getCustomerCountMonth() {
                return CustomerCountMonth;
            }

            public double getCustomerCountWeek() {
                return CustomerCountWeek;
            }

            public String getCustomerCountYearMom() {
                return CustomerCountYearMom;
            }

            public double getScanCountYear() {
                return ScanCountYear;
            }

            public double getCustomerCountYear() {
                return CustomerCountYear;
            }

            public String getCustomerCountTodayMom() {
                return CustomerCountTodayMom;
            }

            public int getScanCustomerCount() {
                return ScanCustomerCount;
            }

            public String getScanCountTodayMom() {
                return ScanCountTodayMom;
            }

            public String getCustomerCountMonthName() {
                return CustomerCountMonthName;
            }
        }
    }
}
