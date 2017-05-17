package com.example.user.utils.media;

import android.content.Context;

import java.io.File;
import java.util.List;

import me.shaohui.advancedluban.Luban;
import me.shaohui.advancedluban.OnCompressListener;
import me.shaohui.advancedluban.OnMultiCompressListener;


/**
 * 项目名称：ciji_android
 * 类描述：LuBanUtils 描述: LuBan压缩图片
 * 创建人：songlijie
 * 创建时间：2017/5/9 15:10
 * 邮箱:814326663@qq.com
 */
public class LuBanUtils {

    /**
     * 压缩图片THIRD_GEAR
     *
     * @param context  上下文对象
     * @param filePah  文件地址
     * @param listener 监听
     */
    public static void ThirdGearCompressImage(Context context, String filePah, final CompressListener listener) {
        Luban.compress(context, new File(filePah))//传入的图片地址
                .putGear(Luban.THIRD_GEAR)      //设定压缩档次，默认三挡
                .launch(new OnCompressListener() { //设置回调

                    @Override
                    public void onStart() {
                        listener.onStart();
                        // TODO 压缩开始前调用，可以在方法内启动 loading UI
                    }

                    @Override
                    public void onSuccess(File file) {
                        // TODO 压缩成功后调用，返回压缩后的图片文件
                        listener.onSuccess(file.getAbsolutePath());
                    }

                    @Override
                    public void onError(Throwable e) {
                        // TODO 当压缩过去出现问题时调用
                        listener.onError(e);
                    }
                });    //启动压缩
    }

    /**
     * 压缩图片THIRD_GEAR
     *
     * @param context  上下文对象
     * @param file     文件
     * @param listener 监听
     */
    public static void ThirdGearCompressImage(Context context, File file, final CompressListener listener) {
        Luban.compress(context, file)//传入的图片地址
                .putGear(Luban.THIRD_GEAR)      //设定压缩档次，默认三挡
                .launch(new OnCompressListener() { //设置回调

                    @Override
                    public void onStart() {
                        listener.onStart();
                        // TODO 压缩开始前调用，可以在方法内启动 loading UI
                    }

                    @Override
                    public void onSuccess(File file) {
                        // TODO 压缩成功后调用，返回压缩后的图片文件
                        listener.onSuccess(file.getAbsolutePath());
                    }

                    @Override
                    public void onError(Throwable e) {
                        // TODO 当压缩过去出现问题时调用
                        listener.onError(e);
                    }
                });    //启动压缩
    }

    /**
     * 压缩图片CUSTOM_GEAR
     *
     * @param context  上下文对象
     * @param filePah  文件地址
     * @param listener 监听
     */
    public static void CustomGearCompressImage(Context context, String filePah, final CompressListener listener) {
        Luban.compress(context, new File(filePah))//传入的图片地址
                .putGear(Luban.CUSTOM_GEAR)      //设定压缩档次，默认三挡
                .launch(new OnCompressListener() { //设置回调

                    @Override
                    public void onStart() {
                        listener.onStart();
                        // TODO 压缩开始前调用，可以在方法内启动 loading UI
                    }

                    @Override
                    public void onSuccess(File file) {
                        // TODO 压缩成功后调用，返回压缩后的图片文件
                        listener.onSuccess(file.getAbsolutePath());
                    }

                    @Override
                    public void onError(Throwable e) {
                        // TODO 当压缩过去出现问题时调用
                        listener.onError(e);
                    }
                });    //启动压缩
    }

    /**
     * 压缩图片CUSTOM_GEAR
     *
     * @param context  上下文对象
     * @param file     文件
     * @param listener 监听
     */
    public static void CustomGearCompressImage(Context context, File file, final CompressListener listener) {
        Luban.compress(context, file)//传入的图片地址
                .putGear(Luban.CUSTOM_GEAR)      //设定压缩档次，默认CUSTOM_GEAR挡
                .launch(new OnCompressListener() { //设置回调

                    @Override
                    public void onStart() {
                        listener.onStart();
                        // TODO 压缩开始前调用，可以在方法内启动 loading UI
                    }

                    @Override
                    public void onSuccess(File file) {
                        // TODO 压缩成功后调用，返回压缩后的图片文件
                        listener.onSuccess(file.getAbsolutePath());
                    }

                    @Override
                    public void onError(Throwable e) {
                        // TODO 当压缩过去出现问题时调用
                        listener.onError(e);
                    }
                });    //启动压缩
    }

    /**
     * 压缩图片FIRST_GEAR
     *
     * @param context  上下文对象
     * @param filePah  文件地址
     * @param listener 监听
     */
    public static void OneGearCompressImage(Context context, String filePah, final CompressListener listener) {
        Luban.compress(context, new File(filePah))//传入的图片地址
                .putGear(Luban.FIRST_GEAR)      //设定压缩档次，默认1挡快速
                .launch(new OnCompressListener() { //设置回调

                    @Override
                    public void onStart() {
                        listener.onStart();
                        // TODO 压缩开始前调用，可以在方法内启动 loading UI
                    }

                    @Override
                    public void onSuccess(File file) {
                        // TODO 压缩成功后调用，返回压缩后的图片文件
                        listener.onSuccess(file.getAbsolutePath());
                    }

                    @Override
                    public void onError(Throwable e) {
                        // TODO 当压缩过去出现问题时调用
                        listener.onError(e);
                    }
                });    //启动压缩
    }

    /**
     * 压缩图片1档 FIRST_GEAR
     *
     * @param context  上下文对象
     * @param file     文件
     * @param listener 监听
     */
    public static void OneGearCompressImage(Context context, File file, final CompressListener listener) {
        Luban.compress(context, file)//传入的图片地址
                .putGear(Luban.FIRST_GEAR)      //设定压缩档次，默认1挡
                .launch(new OnCompressListener() { //设置回调

                    @Override
                    public void onStart() {
                        listener.onStart();
                        // TODO 压缩开始前调用，可以在方法内启动 loading UI
                    }

                    @Override
                    public void onSuccess(File file) {
                        // TODO 压缩成功后调用，返回压缩后的图片文件
                        listener.onSuccess(file.getAbsolutePath());
                    }

                    @Override
                    public void onError(Throwable e) {
                        // TODO 当压缩过去出现问题时调用
                        listener.onError(e);
                    }
                });    //启动压缩
    }

    /**
     * 压缩图片集合list THIRD_GEAR
     *
     * @param context
     * @param files
     * @param listener
     */
    public static void ThirdGearCompressListImage(Context context, List<File> files, final ListCompressListener listener) {
        Luban.compress(context, files)//传入的图片地址
                .putGear(Luban.THIRD_GEAR)      //设定压缩档次，默认3挡
                .launch(new OnMultiCompressListener() { //设置回调

                    @Override
                    public void onStart() {
                        listener.onStart();
                        // TODO 压缩开始前调用，可以在方法内启动 loading UI
                    }

                    @Override
                    public void onSuccess(List<File> fileList) {
                        // TODO 压缩成功后调用，返回压缩后的图片文件
                        listener.onListSuccess(fileList);
                    }

                    @Override
                    public void onError(Throwable e) {
                        // TODO 当压缩过去出现问题时调用
                        listener.onError(e);
                    }
                });    //启动压缩
    }

    /**
     * 压缩图片集合list FIRST_GEAR
     *
     * @param context
     * @param files
     * @param listener
     */
    public static void OneGearCompressListImage(Context context, List<File> files, final ListCompressListener listener) {
        Luban.compress(context, files)//传入的图片地址
                .putGear(Luban.FIRST_GEAR)      //设定压缩档次，默认1挡
                .launch(new OnMultiCompressListener() { //设置回调

                    @Override
                    public void onStart() {
                        listener.onStart();
                        // TODO 压缩开始前调用，可以在方法内启动 loading UI
                    }

                    @Override
                    public void onSuccess(List<File> fileList) {
                        // TODO 压缩成功后调用，返回压缩后的图片文件
                        listener.onListSuccess(fileList);
                    }

                    @Override
                    public void onError(Throwable e) {
                        // TODO 当压缩过去出现问题时调用
                        listener.onError(e);
                    }
                });    //启动压缩
    }

    /**
     * 压缩图片集合list CUSTOM_GEAR
     *
     * @param context
     * @param files
     * @param listener
     */
    public static void CustomGearCompressListImage(Context context, List<File> files, final ListCompressListener listener) {
        Luban.compress(context, files)//传入的图片地址
                .putGear(Luban.CUSTOM_GEAR)      //设定压缩档次，默认CUSTOM_GEAR挡
                .launch(new OnMultiCompressListener() { //设置回调

                    @Override
                    public void onStart() {
                        listener.onStart();
                        // TODO 压缩开始前调用，可以在方法内启动 loading UI
                    }

                    @Override
                    public void onSuccess(List<File> fileList) {
                        // TODO 压缩成功后调用，返回压缩后的图片文件
                        listener.onListSuccess(fileList);
                    }

                    @Override
                    public void onError(Throwable e) {
                        // TODO 当压缩过去出现问题时调用
                        listener.onError(e);
                    }
                });    //启动压缩
    }


    public interface CompressListener {
        void onStart();

        void onSuccess(String filePath);

        void onError(Throwable e);
    }

    /**
     * 集合上传成功的回调
     */
    public interface ListCompressListener {
        void onStart();

        void onListSuccess(List<File> files);

        void onError(Throwable e);
    }

}
