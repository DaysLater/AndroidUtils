/*
                   _ooOoo_
                  o8888888o
                  88" . "88
                  (| -_- |)
                  O\  =  /O
               ____/`---'\____
             .'  \\|     |//  `.
            /  \\|||  :  |||//  \
           /  _||||| -:- |||||-  \
           |   | \\\  -  /// |   |
           | \_|  ''\---/''  |   |
           \  .-\__  `-`  ___/-. /
         ___`. .'  /--.--\  `. . __
      ."" '<  `.___\_<|>_/___.'  >'"".
     | | :  `- \`.;`\ _ /`;.`/ - ` : | |
     \  \ `-.   \_ __\ /__ _/   .-` /  /
======`-.____`-.___\_____/___.-`____.-'======
                   `=---='
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
         佛祖保佑       永无BUG
*/
//          佛曰:
//                  写字楼里写字间，写字间里程序员；
//                  程序人员写程序，又拿程序换酒钱。
//                  酒醒只在网上坐，酒醉还来网下眠；
//                  酒醉酒醒日复日，网上网下年复年。
//                  但愿老死电脑间，不愿鞠躬老板前；
//                  奔驰宝马贵者趣，公交自行程序员。
//                  别人笑我忒疯癫，我笑自己命太贱；

package com.example.user.utils.media.GildeTools;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * 项目名称：QianShan
 * 类描述：GlideUtils 通过Glide下载图片
 * 创建人：slj
 * 创建时间：2016-7-22 15:10
 * 修改人：slj
 * 修改时间：2016-7-22 15:10
 * 修改备注：
 * 邮箱:slj@bjlingzhuo.com
 */
public class GlideUtils {
    /**
     *  Glide 获取图片 有默认图片及错误图片
     * @param context  上下文对象
     * @param url  图片地址
     * @param view 图片要显示的ImageView
     */
    public static void downLoadImage(Context context, String url, ImageView view,int plcaeId,int errorId){
        Glide.with(context)
                .load(url)
                .placeholder(plcaeId)
                .error(errorId)
                .into(view);
    }

    /**
     * Glide 下载图片 带默认图片
     * @param context
     * @param url 下载地址
     * @param view 显示的ImageView
     */
    public static void downLoadImageNomal(Context context, String url, ImageView view,int plcaeId){
        Glide.with(context)
                .load(url)
                .placeholder(plcaeId)
                .into(view);
    }
    /**
     * Glide 下载图片 带下载错误图片
     * @param context
     * @param url 下载地址
     * @param view 显示的ImageView
     */
    public static void downLoadImageError(Context context, String url, ImageView view,int errorId){
        Glide.with(context)
                .load(url)
                .error(errorId)
                .into(view);
    }

    /**
     * Gilde 下载图片转换成圆形图片的方法
     * @param context
     * @param url 下砸地址
     * @param view 显示的ImageView
     */
    public static void downLoadCircleImage(Context context, String url, ImageView view,int plcaeId,int errorId){
        Glide.with(context)
                .load(url)
                .placeholder(plcaeId)
                .error(errorId)
                .transform(new GlideCircleTransform(context))
                .into(view);
    }
    /**
     * Gilde 下载图片转换成圆形图片的方法
     * @param context
     * @param srcId  图片ID
     * @param view 显示的ImageView
     */
    public static void downLoadCircleImage(Context context, int srcId, ImageView view,int plcaeId,int errorId){
        Glide.with(context)
                .load(srcId)
                .placeholder(plcaeId)
                .error(errorId)
                .transform(new GlideCircleTransform(context))
                .into(view);
    }
    /**
     *  Glide 下载图片并转换成默认圆角角度大小图片的方法 默认为4dp
     * @param context
     * @param url 下载地址
     * @param view 显示的ImageView
     */
    public  static void downLoadRoundTransform(Context context, String url, ImageView view,int plcaeId,int errorId){
        Glide.with(context)
                .load(url)
                .placeholder(plcaeId)
                .error(errorId)
                .transform(new GlideRoundTransform(context))
                .into(view);
    }
    /**
     *  Glide 下载图片并转换成自定义圆角角度大小图片的方法
     * @param context
     * @param url 下载地址
     * @param view 显示的ImageView
     * @param dp 自定义圆角的角度大小
     */
    public  static void downLoadRoundTransform(Context context, String url, int dp,ImageView view,int plcaeId,int errorId){
        Glide.with(context)
                .load(url)
                .placeholder(plcaeId)
                .error(errorId)
                .transform(new GlideRoundTransform(context,dp))
                .into(view);
    }
}
