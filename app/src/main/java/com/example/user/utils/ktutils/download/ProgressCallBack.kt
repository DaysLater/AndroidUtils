package com.example.user.utils.ktutils.download

/**
 * 项目名称：AndroidUtils
 * 类描述：ProgressCallBack 描述:
 * 创建人：songlijie
 * 创建时间：2018/9/21 17:17
 * 邮箱:814326663@qq.com
 */
interface ProgressCallBack {
    fun onResponseProgressCallBack(bytesRead: Long, contentLength: Long, progress: Int, done: Boolean, filePath: String?)
}