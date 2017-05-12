package com.example.user.utils.string;

import android.content.Context;

import java.text.DecimalFormat;

/**
 * Created by huangfangyi on 2016/12/24.
 * qq 84543217
 */


public class TextFormater {
    private static final int GB_SP_DIFF = 160;
    private static final int[] secPosvalueList = new int[]{1601, 1637, 1833, 2078, 2274, 2302, 2433, 2594, 2787, 3106, 3212, 3472, 3635, 3722, 3730, 3858, 4027, 4086, 4390, 4558, 4684, 4925, 5249, 5600};
    private static final char[] firstLetter = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'w', 'x', 'y', 'z'};

    public TextFormater() {
    }

    public static String getDataSize(long var0) {
        DecimalFormat var2 = new DecimalFormat("###.00");
        return var0 < 1024L?var0 + "bytes":(var0 < 1048576L?var2.format((double)((float)var0 / 1024.0F)) + "KB":(var0 < 1073741824L?var2.format((double)((float)var0 / 1024.0F / 1024.0F)) + "MB":(var0 < 0L?var2.format((double)((float)var0 / 1024.0F / 1024.0F / 1024.0F)) + "GB":"error")));
    }

    public static String getKBDataSize(long var0) {
        DecimalFormat var2 = new DecimalFormat("###.00");
        return var0 < 1024L?var0 + "KB":(var0 < 1048576L?var2.format((double)((float)var0 / 1024.0F)) + "MB":(var0 < 1073741824L?var2.format((double)((float)var0 / 1024.0F / 1024.0F)) + "GB":"error"));
    }

    public static String formatStr(Context var0, int var1, String var2) {
        String var3 = var0.getText(var1).toString();
        return String.format(var3, new Object[]{var2});
    }

    public static String getFirstLetter(String var0) {
        String var1 = var0.toLowerCase();
        StringBuffer var2 = new StringBuffer();

        for(int var5 = 0; var5 < var1.length(); ++var5) {
            char var3 = var1.charAt(var5);
            char[] var4 = new char[]{var3};
            byte[] var6 = (new String(var4)).getBytes();
            if(var6[0] < 128 && var6[0] > 0) {
                var2.append(var4);
            } else {
                var2.append(convert(var6));
            }
        }

        return var2.toString().substring(0, 1);
    }

    private static char convert(byte[] var0) {
        char var1 = 45;
        boolean var2 = false;

        int var3;
        for(var3 = 0; var3 < var0.length; ++var3) {
            var0[var3] = (byte)(var0[var3] - 160);
        }

        int var4 = var0[0] * 100 + var0[1];

        for(var3 = 0; var3 < 23; ++var3) {
            if(var4 >= secPosvalueList[var3] && var4 < secPosvalueList[var3 + 1]) {
                var1 = firstLetter[var3];
                break;
            }
        }

        return var1;
    }
}

