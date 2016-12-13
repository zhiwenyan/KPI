package com.kpi.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 密码进行MD5加密工具类
 */
public class MD5Utils {

    public static String md5(String str) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());
            byte b[] = md.digest();
            int i;
            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                //      System.out.print(i + ",");
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            return buf.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return str;
    }


    public static final String EncoderPwdByMd5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        // 确定计算方法
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        //  BASE64Encoder base64en = new BASE64Encoder();
        // 加密后的字符串
        // String newstr = base64en.encode(md5.digest(str.getBytes("utf-8")));
        return "";
    }

    public static void main(String[] args) {
        System.out.println(MD5Utils.md5("admin") + "----" + MD5Utils.md5("admin").length());


        try {
            System.out.println(MD5Utils.EncoderPwdByMd5("2"));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
