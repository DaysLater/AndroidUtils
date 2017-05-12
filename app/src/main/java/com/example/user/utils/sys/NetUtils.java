package com.example.user.utils.sys;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.util.Log;

/**
 * 网络判断的工具类
 */
public class NetUtils {
    private static final String TAG = NetUtils.class.getSimpleName();
    /**
     * 是否有网络
     * @param var0
     * @return
     */
    public static boolean hasNetwork(Context var0) {
        if(var0 != null) {
            ConnectivityManager var1 = (ConnectivityManager)var0.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo var2 = var1.getActiveNetworkInfo();
            return var2 != null?var2.isAvailable():false;
        } else {
            return false;
        }
    }

    /**
     * 是否有数据连接
     * @param var0
     * @return
     */
    @TargetApi(13)
    public static boolean hasDataConnection(Context var0) {
        try {
            ConnectivityManager var1 = (ConnectivityManager)var0.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo var2 = var1.getNetworkInfo(1);
            if(var2 != null && var2.isAvailable() && var2.isConnected()) {
                Log.d(TAG, "has wifi connection");
                return true;
            } else {
                var2 = var1.getNetworkInfo(0);
                if(var2 != null && var2.isAvailable() && var2.isConnected()) {
                    Log.d(TAG, "has mobile connection");
                    return true;
                } else {
                    if(VERSION.SDK_INT >= 13) {
                        var2 = var1.getNetworkInfo(9);
                        if(var2 != null && var2.isAvailable() && var2.isConnected()) {
                            Log.d(TAG, "has ethernet connection");
                            return true;
                        }
                    }
                    Log.d(TAG, "no data connection");
                    return false;
                }
            }
        } catch (Exception var3) {
            return false;
        }
    }
    /**
     * 是否是wifi链接
     * @param var0
     * @return
     */
    @Deprecated
    public static boolean isWifiConnection(Context var0) {
        return isWifiConnected(var0);
    }
    /**
     * 是否是wifi链接
     * @param var0
     * @return
     */
    public static boolean isWifiConnected(Context var0) {
        ConnectivityManager var1 = (ConnectivityManager)var0.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo var2 = var1.getNetworkInfo(1);
        if(var2 != null && var2.isAvailable() && var2.isConnected()) {
            Log.d(TAG, "wifi is connected");
            return true;
        } else {
            return false;
        }
    }

    /**
     * 是否是手机网络链接
     * @param var0
     * @return
     */
    @Deprecated
    public static boolean isMobileConnection(Context var0) {
        return isMobileConnected(var0);
    }
    /**
     * 是否是手机网络链接
     * @param var0
     * @return
     */
    public static boolean isMobileConnected(Context var0) {
        ConnectivityManager var1 = (ConnectivityManager)var0.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo var2 = var1.getNetworkInfo(0);
        if(var2 != null && var2.isAvailable() && var2.isConnected()) {
            Log.d(TAG, "mobile is connected");
            return true;
        } else {
            return false;
        }
    }

    /**
     * 以太网是否链接
     * @param var0
     * @return
     */
    @Deprecated
    public static boolean isEthernetConnection(Context var0) {
        return isEthernetConnected(var0);
    }
    /**
     * 以太网是否链接
     * @param var0
     * @return
     */
    public static boolean isEthernetConnected(Context var0) {
        if(VERSION.SDK_INT >= 13) {
            ConnectivityManager var1 = (ConnectivityManager)var0.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo var2 = var1.getNetworkInfo(9);
            if(var2 != null && var2.isAvailable() && var2.isConnected()) {
                Log.d(TAG, "ethernet is connected");
                return true;
            }
        }
        return false;
    }

    /**
     * 获取wifi的SSID
     * @param var0
     * @return
     */
    public static String getWiFiSSID(Context var0) {
        ConnectivityManager var1 = (ConnectivityManager)var0.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo var2 = var1.getNetworkInfo(1);
        WifiManager var3 = (WifiManager)var0.getSystemService(Context.WIFI_SERVICE);
        WifiInfo var4 = var3.getConnectionInfo();
        return var4.getSSID();
    }

    /**
     * 获取上传缓冲区大小
     * @param var0
     * @return
     */
    public static int getUploadBufSize(Context var0) {
        ConnectivityManager var1 = (ConnectivityManager)var0.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo var2 = var1.getActiveNetworkInfo();
        return var2 != null && var2.getType() == 1?102400:(VERSION.SDK_INT >= 13 && var2 != null && var2.getType() == 9?102400:(var2 == null && isConnectionFast(var2.getType(), var2.getSubtype())?10240:1024));
    }

    /**
     * 获取下载缓冲区大小
     * @param var0
     * @return
     */
    public static int getDownloadBufSize(Context var0) {
        ConnectivityManager var1 = (ConnectivityManager)var0.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo var2 = var1.getActiveNetworkInfo();
        return var2 != null && var2.getType() == 1?102400:(VERSION.SDK_INT >= 13 && var2 != null && var2.getType() == 9?102400:(var2 == null && isConnectionFast(var2.getType(), var2.getSubtype())?30720:2024));
    }

    /**
     * 判断网络是否快速
     * @param var0
     * @param var1
     * @return
     */
    private static boolean isConnectionFast(int var0, int var1) {
        if(var0 == 1) {
            return true;
        } else if(VERSION.SDK_INT >= 13 && var0 == 9) {
            return true;
        } else {
            if(var0 == 0) {
                switch(var1) {
                case 1:
                    return false;
                case 2:
                    return false;
                case 3:
                    return true;
                case 4:
                    return false;
                case 5:
                    return true;
                case 6:
                    return true;
                case 7:
                    return false;
                case 8:
                    return true;
                case 9:
                    return true;
                case 10:
                    return true;
                default:
                    if(VERSION.SDK_INT >= 11 && (var1 == 14 || var1 == 13)) {
                        return true;
                    }
                    if(VERSION.SDK_INT >= 9 && var1 == 12) {
                        return true;
                    }
                    if(VERSION.SDK_INT >= 8 && var1 == 11) {
                        return false;
                    }
                }
            }
            return false;
        }
    }

    /**
     * 获取网络类型
     * @param var0
     * @return
     */
    public static String getNetworkType(Context var0) {
        ConnectivityManager var1 = (ConnectivityManager)var0.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo var2 = var1.getActiveNetworkInfo();
        if(var2 != null && var2.isAvailable()) {
            int var3 = var2.getType();
            if(VERSION.SDK_INT >= 13 && var3 == 9) {
                return "ETHERNET";
            } else if(var3 == 1) {
                return "WIFI";
            } else {
                TelephonyManager var4 = (TelephonyManager)var0.getSystemService(Context.TELEPHONY_SERVICE);
                switch(var4.getNetworkType()) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                    return "2G";
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                    return "3G";
                case 13:
                    return "4G";
                default:
                    return "unkonw network";
                }
            }
        } else {
            return "no network";
        }
    }
}
