package com.example.user.utils.ktutils.download

import com.example.user.utils.ktutils.base.BaseDownLoadObserver

/**
 * 项目名称：AndroidUtils
 * 类描述：DownloadObserver 描述:
 * 创建人：songlijie
 * 创建时间：2018/9/21 17:21
 * 邮箱:814326663@qq.com
 */
abstract class DownloadObserver : BaseDownLoadObserver() {
    override fun doOnError(errorMsg: String?) {

    }
}