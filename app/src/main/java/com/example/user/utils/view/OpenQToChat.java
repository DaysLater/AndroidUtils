package com.example.user.utils.view;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.widget.Toast;

import java.util.List;

/**
 * 项目名称：AndroidUtils
 * 类描述：OpenQToChat 描述: 跳转咨询qq聊天的工具类
 * 创建人：songlijie
 * 创建时间：2017/5/15 14:56
 * 邮箱:814326663@qq.com
 */
public class OpenQToChat {

    /**
     * 打开QQ去咨询个人QQ
     *
     * @param context 上下文对象
     * @param qq      要跳转的QQ号
     */
    public static void OpenQQToChatNumal(Context context, String qq) {
        if (isQQClientAvailable(context)) {
            String qqUrl = "mqqwpa://im/chat?chat_type=wpa&uin=" + qq + "&version=1";
            context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(qqUrl)));
        } else {
            Toast.makeText(context, "您的手机暂未安装QQ客户端", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * 打开QQ去企业QQ
     *
     * @param context 上下文对象
     * @param qq      要跳转的QQ号
     */
    public static void OpenQQToChatCompany(Context context, String qq) {
        if (isQQClientAvailable(context)) {
            String url = "mqqwpa://im/chat?chat_type=crm&uin=" + qq + "&version=1&src_type=web&web_src=http:://wpa.b.qq.com";
            context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
        } else {
            Toast.makeText(context, "您的手机暂未安装QQ客户端", Toast.LENGTH_SHORT).show();
        }
    }


    /**
     * 判断qq是否可用
     * @param context 上下文对象
     * @return true or false
     */
    public static boolean isQQClientAvailable(Context context) {
        final PackageManager packageManager = context.getPackageManager();
        List<PackageInfo> pinfo = packageManager.getInstalledPackages(0);
        if (pinfo != null) {
            for (int i = 0; i < pinfo.size(); i++) {
                String pn = pinfo.get(i).packageName;
                if (pn.equals("com.tencent.mobileqq")) {
                    return true;
                }
            }
        }
        return false;
    }
}
