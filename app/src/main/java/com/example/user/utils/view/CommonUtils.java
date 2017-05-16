package com.example.user.utils.view;

/**
 * Created by Developer-X on 2016/5/23.
 *
 * 防止重复点击工具类
 */
public class CommonUtils {
    private static long lastClickTime;

    /**
     * 防止重复点击给个时间间隔
     * @return
     */
    public static boolean isFastDoubleClick() {
        long time = System.currentTimeMillis();
        long timeD = time - lastClickTime;
        if (0 < timeD && timeD < 800) {
            return true;
        }
        lastClickTime = time;
        return false;
    }

}
