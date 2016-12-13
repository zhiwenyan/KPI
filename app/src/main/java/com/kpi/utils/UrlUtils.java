package com.kpi.utils;

/**
 * 请求网址的工具类
 */
public class UrlUtils {
    public static String KpiIndex_url = "http://192.168.0.19:4444/report/refreshKpiAndroid.do?format=json&companyId=TONGYI&brandId=001";

    public static String qSearchType = "1";
    public static String searchType = "0";
    public static String imageType = "1";
    public static String pDate;

    public static String pDateFrom = "";
    public static String pDateTo = "";

    public static String DDatefrom = "";
    public static String DDateto = "";
    public static String DDatefromMom = "";
    public static String DDatetoMom = "";


    public static String btn = "1";
    public static String type = "1";
    public static String order = "SCAN_COUNT";


    public static String product_btn = "1";

    public String AreaPer_Url = "http://192.168.0.19:4444/report/searchKp0003Android.do?format=json&btn=1&DDatefrom=20160323&DDateto=20160323&DDatefromMom=20160322&DDatetoMom=20160322&type=1&order=SCAN_COUNT&limit=5";
    public String KpiTrend_url;
    public String home_KpiTrend_url;     //首页显示如图的URL；

    public String Product_Url;

    public String Account_url;
    public static int page = 0;
    public static String accountId;
    public String account_url1;
    public static String selectDay = "7";

    public String account_url2;

    public static String selectTime = "7";


    //异常的查询日期
    public static String DDateTime = DateUtil.CurrentDay();
    //日扫码量限制
    public static String limit;


    public static String product;

    public static String area;

    public UrlUtils() {
        //KPI指数
        this.KpiTrend_url = "http://192.168.0.19:4444/report/searchAndroid.do?searchType=" + searchType + "&imageType=" + imageType + "&pDateFrom=" + pDateFrom + "&pDateTo=" + pDateTo + "&pDate=" + pDate + "&qSearchType=" + qSearchType + "&format=json";
        this.home_KpiTrend_url = "http://192.168.0.19:4444/report/searchAndroid.do?searchType=" + searchType + "&imageType=2&pDateFrom=&pDateTo&pDate=" + DateUtil.CurrentDay() + "&qSearchType=1&format=json";

        //区域表现
        this.AreaPer_Url = "http://192.168.0.19:4444/report/searchKp0003Android.do?format=json&btn=" + btn + "&DDatefrom=" + DDatefrom + "&DDateto=" + DDateto + "&DDatefromMom=" + DDatefromMom + "&DDatetoMom=" + DDatetoMom + "&type=" + type + "&order=" + order + "&limit=5";
        //产品表现
        this.Product_Url = "http://192.168.0.19:4444/report/searchKp0004Android.do?format=json&product=" + product + "&area=" + area + "&btn=" + product_btn + "&DDatefrom=" + DDatefrom + "&DDateto=" + DDateto + "&DDatefromMom=" + DDatefromMom + "&DDatetoMom=" + DDatetoMom + "";

        //异常客户
        this.Account_url = "http://192.168.0.19:4444/report/searchKp0005Android.do?format=json&type=1&limit=" + limit + "&page=" + page + "&btn=5&DDatefrom&DDateto&DDatefromMom&DDatetoMom&DDateTime=" + DDateTime + "";
        //客户明细
        this.account_url1 = "http://192.168.0.19:4444/report/searchKp0005_DetailAndroid.do?format=json&customerId=" + accountId + "&selectDay=" + selectDay + "&btn=2";
        //日产品分布
        this.account_url2 = "http://192.168.0.19:4444/report/searchKpi0005_Detail_GridAndroid.do?format=json&customerId=" + accountId + "&btn=2&selectTime=" + selectTime + "";
    }
}
