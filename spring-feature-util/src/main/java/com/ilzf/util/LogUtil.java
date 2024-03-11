package com.ilzf.util;

public class LogUtil {
    public static void log(String... args) {
        System.out.println(StringUtil.wrapperLog(args));
    }

    public static void log(int args) {
        System.out.println(args);
    }
}
