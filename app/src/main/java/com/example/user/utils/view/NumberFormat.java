package com.example.user.utils.view;

import android.text.Html;

import java.text.DecimalFormat;

/**
 * double类型转String位数保留两位小数
 */
public class NumberFormat {
    // public static String formatRound(double data) {
    // DecimalFormat df = new DecimalFormat("#0.00");
    // return df.format(data);
    // }
    public static double parseDouble(String s) {
        if (s == null) {
            return 0;
        }
        try {
            return Double.parseDouble(s);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    /**
     * 默认给f加上前缀￥ 可修改 和后缀,不需要就填null
     * @param f
     * @param end
     * @return
     */
    public static CharSequence formatSpecialPrice(double f, String end) {
        return formatSpecialPrice(f, "￥", end);
    }

    /**
     * 给f加上前缀 可修改 和后缀,不需要就填null
     * @param f
     * @param start
     * @param end
     * @return
     */
    public static CharSequence formatSpecialPrice(double f, String start,
                                                  String end) {
        DecimalFormat df = new DecimalFormat("#0.00");
        String s = df.format(f);
        String[] ss = s.split("\\.");
        if (ss.length != 2) {
            return "";
        }
        if (end == null) {
            end = "";
        }
        if (start == null) {
            start = "";
        }
        return Html.fromHtml("<small>" + start + "</small>" + ss[0]
                + ".<small>" + ss[1] + end + "</small>");
    }

    /**
     * 保留两位小数
     * @param f
     * @return
     */
    public static String doubleToString(double f) {
        long t = Math.round(f * 100);
        StringBuilder sb = new StringBuilder();
        sb.append(t / 100).append(".");
        long num = t % 100;
        if (num < 9) {
            sb.append("0");
        }
        sb.append(num);
        return sb.toString();
    }

    /**
     * 保留两位小数
     * @param f
     * @param end
     * @return
     */
    public static String doubleToString(double f, String end) {
        long t = Math.round(f * 100);
        StringBuilder sb = new StringBuilder();
        sb.append(t / 100).append(".");
        long num = t % 100;
        if (num < 9) {
            sb.append("0");
        }
        sb.append(num).append(end);
        return sb.toString();
    }

//    public static String formatPrice(float f) {
//        return String.format("%.02f", f);
//    }
//
//    public static String formatPrice(double d) {
//        return String.format("%.02f", d);
//    }

}
