package com.astontech.hr.common;

/**
 * Created by barrsmit1 on 6/14/2016.
 */
public class StringHelper {

    public static boolean isNullOrEmpty(String s) {
        return s == null || s.trim().length() == 0;
    }

    public static String addSpace(String s) {
        return isNullOrEmpty(s) ? "" : s + " ";
    }

    public static String getNullForEmpty(String s) {
        return isNullOrEmpty(s) ? null : s;
    }
}
