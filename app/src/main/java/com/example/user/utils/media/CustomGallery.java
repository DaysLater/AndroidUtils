package com.example.user.utils.media;

import java.io.Serializable;

/**
 * 项目名称：FileUploadAndImageText
 * 类描述：CustomGallery 描述: CustomGallery 图片地址获取实体类
 * 创建人：songlijie
 * 创建时间：2016/12/2 14:02
 * 邮箱:814326663@qq.com
 */
public class CustomGallery implements Serializable {
    public String sdcardPath;//SD卡的路径
    public String mPath; //图片路径
    public long mTime;//拍照时间
    public String mName;//图片名称
}
