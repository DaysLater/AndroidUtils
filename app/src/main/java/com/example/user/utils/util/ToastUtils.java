package com.example.user.utils.util;

import android.content.Context;
import android.widget.Toast;

/**
 * <pre>
 *     author: Blankj
 *     blog  : http://blankj.com
 *     time  : 2016/9/29
 *     desc  :
 * </pre>
 */
public class ToastUtils {
    public static void showLong(Context context, String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
    }

    public static void showShort(Context context, String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT);
    }
}
