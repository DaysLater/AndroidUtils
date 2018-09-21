package com.example.user.utils.ktutils.bean

import android.icu.lang.UCharacter.GraphemeClusterBreak.T


/**
 * 项目名称：AndroidUtils
 * 类描述：BaseResult 描述: 基础数据格式
 * 创建人：songlijie
 * 创建时间：2018/9/21 17:00
 * 邮箱:814326663@qq.com
 */
class BaseResult<T> {

    /**
     * 错误码
     */
    private var code: Int = 0
    /**
     * 错误描述
     */
    private var msg: String? = null

    /**
     * 数据
     */
    private var data: T? = null

    fun getCode(): Int {
        return code
    }

    fun setCode(code: Int) {
        this.code = code
    }

    fun getMsg(): String? {
        return msg
    }

    fun setMsg(msg: String) {
        this.msg = msg
    }

    fun getData(): T? {
        return data
    }

    fun setData(data: T) {
        this.data = data
    }

    override fun toString(): String {
        return "BaseResult:{" +
                "code=" + code +
                ", msg='" + msg + '\''.toString() +
                ", data=" + data +
                '}'.toString()
    }
}