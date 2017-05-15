package com.example.user.utils.file;

import android.util.Log;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Developer-X on 2016/7/5.
 *  计算文件大小
 */
public class FileSizeUtil {

    public static String getAutoFileOrFilesSize(String filePath) {
        File file = new File(filePath);
        return getAutoFileOrFilesSize(file);
    }
    public static String getAutoFileOrFilesSize(File file) {
        return FormetFileSize(getFileSizes(file));
    }



    /**
     * 获取指定文件夹
     *
     * @param f
     * @return
     * @throws Exception
     */
    private static long getFileSizes(File f) {
        if (!f.exists()) return 0;
        if(f.isFile()) return f.length();

        long size = 0;
        File flist[] = f.listFiles(new MyFilter());
        for (int i = 0; i < flist.length; i++) {
            if (flist[i].isDirectory()) {
                size = size + getFileSizes(flist[i]);
            } else {
                size = size + flist[i].length();
            }
        }
        return size;
    }

    /**
     * 转换文件大小
     *
     * @param fileS
     * @return
     */
    private static String FormetFileSize(long fileS) {
        DecimalFormat df = new DecimalFormat("#.00");
        String fileSizeString = "";
        String wrongSize = "0B";
        if (fileS == 0) {
            return wrongSize;
        }
        if (fileS < 1024) {
            fileSizeString = df.format((double) fileS) + "B";
        } else if (fileS < 1048576) {
            fileSizeString = df.format((double) fileS / 1024) + "KB";
        } else if (fileS < 1073741824) {
            fileSizeString = df.format((double) fileS / 1048576) + "MB";
        } else {
            fileSizeString = df.format((double) fileS / 1073741824) + "GB";
        }
        return fileSizeString;
    }

    public static class MyFilter implements FileFilter {

            @Override
            public boolean accept(File pathname) {
                return pathname.isDirectory() || pathname.getName().toLowerCase().endsWith(".dwg");
            }


    }

    //获取所有文件夹
    public static List<File> refilesearch(File dir) {
        File[] files = dir.listFiles(new MyFilter());
        List<File> list = Arrays.asList(files);
        //排序
        Collections.sort(list, new Comparator<File>() {
            @Override
            public int compare(File lhs, File rhs) {
                if (lhs.isDirectory() && rhs.isDirectory() || lhs.isFile() && rhs.isFile())
                    return 0;
                return lhs.isDirectory() ? -1 : 1;
            }
        });

        return list;
    }

}