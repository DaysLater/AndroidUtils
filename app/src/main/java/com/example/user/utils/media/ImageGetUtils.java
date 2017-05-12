package com.example.user.utils.media;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 项目名称：FileUploadAndImageText
 * 类描述：ImageGetUtils 描述:ImageGetUtils 获取手机中所有的图片
 * 创建人：songlijie
 * 创建时间：2016/12/2 13:57
 * 邮箱:814326663@qq.com
 */
public class ImageGetUtils {
    /**
     * 获取手机中所有的图片
     * @param context
     * @return
     */
    public static List<CustomGallery> getAllIMage(Context context){
        List<CustomGallery> galleryList = new ArrayList<>();
    try {
        final String[] columns = {MediaStore.Images.Media.DATA,
                MediaStore.Images.Media._ID, MediaStore.Images.Media.DATE_TAKEN};
        final String orderBy = MediaStore.Images.Media._ID;
//        final String orderBy = MediaStore.Images.Media.DATE_TAKEN;
        ContentResolver mContentResolver =context.getContentResolver();
        Cursor imagecursor =  mContentResolver.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, columns, null, null, orderBy);
        if (imagecursor != null && imagecursor.getCount() > 0) {
            while (imagecursor.moveToNext()) {
                CustomGallery item = new CustomGallery();
                int dataColumnIndex = imagecursor.getColumnIndex(MediaStore.Images.Media.DATA);
                int imagecursorColumnIndex = imagecursor.getColumnIndex(MediaStore.Images.Media.DATE_TAKEN);
                File file = new File(imagecursor.getString(dataColumnIndex));
                if (file != null && file.length() > 0) {
                    long longDate = imagecursor.getLong(imagecursorColumnIndex);
                    item.mTime =longDate;
                    item.mPath = imagecursor.getString(dataColumnIndex);
                    item.mName = imagecursor.getString(dataColumnIndex).substring(imagecursor.getString(dataColumnIndex).lastIndexOf("/")+1);
                    item.sdcardPath = "file://" + imagecursor.getString(dataColumnIndex);
                    galleryList.add(item);
                }
            }
            imagecursor.close();
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
        return galleryList;
    }

    /**
     * 获取最新图片地址路径
     * @param context 上下文对象
     * @return mPath 地址路径
     */
    public static String getNewestImagePath(Context context){
        List<CustomGallery> mage = getAllIMage(context);
        CustomGallery gallery = mage.get(mage.size() - 1);
        String mPath = gallery.mPath;
        return mPath;
    }
    /**
     * 获取最新图片在SD中的路径
     * @param context 上下文对象
     * @return sdcardPath  SD卡路径
     */
    public static String getNewestImageSDPath(Context context){
        List<CustomGallery> mage = getAllIMage(context);
        CustomGallery gallery = mage.get(mage.size() - 1);
        String sdcardPath = gallery.sdcardPath;
        return sdcardPath;
    }

    /**
     * 获取最新照片的拍照时间
     * @param context
     * @return mTime 格式为:yyyy年MM月dd日 HH时mm分ss秒
     */
    public static String getNewestImageTakeTime(Context context){
        List<CustomGallery> mage = getAllIMage(context);
        CustomGallery gallery = mage.get(mage.size() - 1);
        Date date = new Date(gallery.mTime);
        SimpleDateFormat sf = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        String mTime = sf.format(date);
        return mTime;
    }
    /**
     * 获取最新照片的路径及所在SD卡的路径及拍照时间
     * @param context
     * @return List<String> imageInfo 最新照片集合
     */
    public static List<String> getNewestImageInfo(Context context){
        List<String> imageInfo = new ArrayList<>();
        List<CustomGallery> mage = getAllIMage(context);
        CustomGallery gallery = mage.get(mage.size() - 1);
        String sdcardPath = gallery.sdcardPath;
        String mPath = gallery.mPath;
        Date date = new Date(gallery.mTime);
        SimpleDateFormat sf = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        String mTime = sf.format(date);
        imageInfo.add(sdcardPath);
        imageInfo.add(mPath);
        imageInfo.add(mTime);
        return imageInfo;
    }
    /**
     * 获取最老图片地址路径
     * @param context 上下文对象
     * @return mPath 地址路径
     */
    public static String getOldImagePath(Context context){
        List<CustomGallery> mage = getAllIMage(context);
        CustomGallery gallery = mage.get(0);
        String mPath = gallery.mPath;
        return mPath;
    }
    /**
     * 获取最老图片在SD中的路径
     * @param context 上下文对象
     * @return sdcardPath  SD卡路径
     */
    public static String getOldImageSDPath(Context context){
        List<CustomGallery> mage = getAllIMage(context);
        CustomGallery gallery = mage.get(0);
        String sdcardPath = gallery.sdcardPath;
        return sdcardPath;
    }

    /**
     * 获取最老照片的拍照时间
     * @param context
     * @return mTime 格式为:yyyy年MM月dd日 HH时mm分ss秒
     */
    public static String getOldImageTakeTime(Context context){
        List<CustomGallery> mage = getAllIMage(context);
        CustomGallery gallery = mage.get(0);
        Date date = new Date(gallery.mTime);
        SimpleDateFormat sf = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        String mTime = sf.format(date);
        return mTime;
    }
    /**
     * 获取最老照片的路径及所在SD卡的路径及拍照时间
     * @param context
     * @return List<String> imageInfo 最新照片集合
     */
    public static List<String> getOldImageInfo(Context context){
        List<String> imageInfo = new ArrayList<>();
        List<CustomGallery> mage = getAllIMage(context);
        CustomGallery gallery = mage.get(0);
        String sdcardPath = gallery.sdcardPath;
        String mPath = gallery.mPath;
        Date date = new Date(gallery.mTime);
        SimpleDateFormat sf = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        String mTime = sf.format(date);
        imageInfo.add(sdcardPath);
        imageInfo.add(mPath);
        imageInfo.add(mTime);
        return imageInfo;
    }
    /**
     * 获取所有相片路径
     * @param context
     * @return List<String>
     */
    public static List<String> getAllImagePath(Context context){
        List<String> imagePath = new ArrayList<>();
        List<CustomGallery> mage = getAllIMage(context);
        for (int i = 0; i < mage.size(); i++) {
            CustomGallery gallery = mage.get(i);
            String mPath = gallery.mPath;
            imagePath.add(mPath);
        }
        return imagePath;
    }
}
