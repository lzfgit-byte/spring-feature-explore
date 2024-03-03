package com.ilzf.util;


public class StringUtil {

    public static String wrapperLog(String... args) {
        return "-----" + String.join(",", args) + "----";
    }
}
