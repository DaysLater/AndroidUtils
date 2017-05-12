package com.example.user.utils.sys;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 项目名称：QianShanDoctor
 * 类描述：StatusBarUtils 状态栏工具类
 * 创建人：slj
 * 创建时间：2016-6-30 11:01
 * 修改人：slj
 * 修改时间：2016-6-30 11:01
 * 修改备注：
 * 邮箱:slj@bjlingzhuo.com
 */
public class StatusBarUtils {
    private static String MIUI = "Xiaomi";
    private static String FLYME = "Meizu";
    private static String HUAWEI = "Huawei";
    /**
     * 设置沉浸式状态栏
     *
     * @param context 需要传入一个baseActivity
     */
    public static void setBaseStatusBar(Activity context) {
        //判断Sdk版本号
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            context.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //透明导航栏
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                context.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                context.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
                context.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                context.getWindow().setStatusBarColor(Color.TRANSPARENT);
            }
            String model = getBuildBrand();
            if (model != null) {
                if (model.equals(MIUI)) {
                    StatusBarUtils.setMiuiStatusBarDarkMode(context, true);//设置小米透明状态栏的颜色
                }
                if (model.equals(FLYME)) {
                    StatusBarUtils.setMeizuStatusBarDarkIcon(context, true);//设置魅族状态栏的颜色
                }
            }
        }
    }
    /**
     * 设置沉浸式状态栏
     *
     * @param context 需要传入一个Activity
     */
    public static void setStatusBar(Activity context) {
        //判断Sdk版本号
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            context.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //透明导航栏
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                context.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                context.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
                context.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                context.getWindow().setStatusBarColor(Color.TRANSPARENT);
            }
            String model = getBuildBrand();
            if (model != null) {
                if (model.equals(MIUI)) {
                    StatusBarUtils.setMiuiStatusBarDarkMode(context, true);//设置小米透明状态栏的颜色
                }
                if (model.equals(FLYME)) {
                    StatusBarUtils.setMeizuStatusBarDarkIcon(context, true);//设置魅族状态栏的颜色
                }
            }
        }
    }
    /**
     * 设置沉浸式状态栏
     *
     * @param context 需要传入一个Activity
     * @param isOpenNavigation 是否让导航栏透明
     */
    public static void setStatusBar(Activity context ,boolean isOpenNavigation ) {
        //判断Sdk版本号
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            context.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            if (isOpenNavigation == true){
                //透明导航栏
                context.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            }
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                context.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//                context.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                context.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
                context.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                context.getWindow().setStatusBarColor(Color.TRANSPARENT);
                if (isOpenNavigation == true){
                    //透明导航栏
                    context.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
                }
            }
            String model = getBuildBrand();
            if (model != null) {
                if (model.equals(MIUI)) {
                    StatusBarUtils.setMiuiStatusBarDarkMode(context, true);//设置小米透明状态栏的颜色
                }
                if (model.equals(FLYME)) {
                    StatusBarUtils.setMeizuStatusBarDarkIcon(context, true);//设置魅族状态栏的颜色
                }
            }
        }
    }
    /**
     * 用于获取状态栏的高度。 使用Resource对象获取（推荐这种方式）
     *
     * @return 返回状态栏高度的像素值。
     */
    public static int getStatusBarHeight(Context context) {
        int result = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen",
                "android");
        if (resourceId > 0) {
            result = context.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    //小米状态栏设置
    public static boolean setMiuiStatusBarDarkMode(Activity activity, boolean darkmode) {
        Class<? extends Window> clazz = activity.getWindow().getClass();
        try {
            int darkModeFlag = 0;
            Class<?> layoutParams = Class.forName("android.view.MiuiWindowManager$LayoutParams");
            Field field = layoutParams.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE");
            darkModeFlag = field.getInt(layoutParams);
            Method extraFlagField = clazz.getMethod("setExtraFlags", int.class, int.class);
            extraFlagField.invoke(activity.getWindow(), darkmode ? darkModeFlag : 0, darkModeFlag);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    //魅族状态栏设置
    public static boolean setMeizuStatusBarDarkIcon(Activity activity, boolean dark) {
        boolean result = false;
        if (activity != null) {
            try {
                WindowManager.LayoutParams lp = activity.getWindow().getAttributes();
                Field darkFlag = WindowManager.LayoutParams.class
                        .getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
                Field meizuFlags = WindowManager.LayoutParams.class
                        .getDeclaredField("meizuFlags");
                darkFlag.setAccessible(true);
                meizuFlags.setAccessible(true);
                int bit = darkFlag.getInt(null);
                int value = meizuFlags.getInt(lp);
                if (dark) {
                    value |= bit;
                } else {
                    value &= ~bit;
                }
                meizuFlags.setInt(lp, value);
                activity.getWindow().setAttributes(lp);
                result = true;
            } catch (Exception e) {
            }
        }
        return result;
    }
    /**
     * 获取手机型号
     * @return 手机型号
     */
    private static String getBuildBrand(){
        String MIUI = "Xiaomi";
        String FLYME = "Meizu";
        String HUAWEI = "HUAWEI";
        String QIHU = "360";
        String result = null;
        String brand = Build.BRAND;//手机品牌
        String model = Build.MANUFACTURER;// CPU厂商

        if (brand.equals(MIUI) || model.equals(MIUI)){
            result = MIUI;
        } else if (brand.equals(FLYME)|| model.equals(FLYME)){
            result = FLYME;
        } else if (brand.equals(HUAWEI)|| model.equals(HUAWEI)){
            result = HUAWEI;
        }else if (brand.equals(QIHU)|| model.equals(QIHU)){
            result = QIHU;
        }
        return result;
    }
    /**
     * 强制竖屏
     * @param context activity
     */
    public static void setPortrait(Activity context){
        if (context.getRequestedOrientation() != ActivityInfo.SCREEN_ORIENTATION_PORTRAIT) {
            context.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
    }
    /**
     * 强制横屏
     * @param context activity
     */
    public static void setLandScape(Activity context){
        if (context.getRequestedOrientation() != ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) {
            context.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }
    }
}
