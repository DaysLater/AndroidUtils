package com.example.user.utils.ktutils.excertioncode

import java.lang.Exception
import android.R.id.message
import android.net.ParseException
import com.alibaba.fastjson.JSONException
import com.google.gson.JsonSerializer
import com.google.gson.JsonSyntaxException
import com.google.gson.JsonParseException
import org.apache.http.conn.ConnectTimeoutException
import retrofit2.HttpException
import java.io.IOException
import java.io.NotSerializableException
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException


/**
 * 项目名称：AndroidUtils
 * 类描述：AllExcertion 描述:
 * 创建人：songlijie
 * 创建时间：2018/9/21 16:12
 * 邮箱:814326663@qq.com
 */
class AllExcertion : Exception() {
    private var errCode: Int? = null
    private var msg: String? = null

    fun getCode(): Int? {
        return errCode!!
    }

    fun getErorMessage(): String? {
        return msg!!
    }

    fun setCode(code: Int?) {
        this.errCode = code
    }

    fun AllExcertion(throwalble: Throwable?, code: Int?): AllExcertion {
        this.errCode = code
        this.msg = throwalble!!.message
        return this
    }

    fun setMessage(message: String?) {
        this.msg = message
    }

    fun handleException(e: Throwable?): AllExcertion {
        var ex: AllExcertion
        if (e == null) {
            ex = AllExcertion(e, ERROR.UNKNOWN)
            ex!!.setCode(ERROR.UNKNOWN)
            ex!!.setMessage("未知错误")
            return ex
        }
        if (e is HttpException) {
            val httpException = e as HttpException
            ex = AllExcertion(httpException, httpException.code())
            try {
                ex!!.setMessage(httpException.response().errorBody().string())
            } catch (e1: IOException) {
                e1.printStackTrace()
                ex!!.setCode(httpException.code())
                ex!!.setMessage(e1.message)
            }

            return ex
        } else if (e is SocketTimeoutException) {
            ex = AllExcertion(e, ERROR.TIMEOUT_ERROR)
            ex!!.setMessage("网络连接超时，请检查您的网络状态，稍后重试！")
            return ex
        } else if (e is ConnectException) {
            ex = AllExcertion(e, ERROR.TIMEOUT_ERROR)
            ex!!.setCode(ERROR.TIMEOUT_ERROR)
            ex!!.setMessage("网络连接异常，请检查您的网络状态，稍后重试！")
            return ex
        } else if (e is ConnectTimeoutException) {
            ex = AllExcertion(e, ERROR.TIMEOUT_ERROR)
            ex!!.setCode(ERROR.TIMEOUT_ERROR)
            ex!!.setMessage("网络连接超时，请检查您的网络状态，稍后重试！")
            return ex
        } else if (e is UnknownHostException) {
            ex = AllExcertion(e, ERROR.TIMEOUT_ERROR)
            ex!!.setCode(ERROR.TIMEOUT_ERROR)
            ex!!.setMessage("网络连接异常，请检查您的网络状态，稍后重试！")
            return ex
        } else if (e is NullPointerException) {
            ex = AllExcertion(e, ERROR.NULL_POINTER_EXCEPTION)
            ex!!.setCode(ERROR.NULL_POINTER_EXCEPTION)
            ex!!.setMessage("空指针异常")
            return ex
        } else if (e is javax.net.ssl.SSLHandshakeException) {
            ex = AllExcertion(e, ERROR.SSL_ERROR)
            ex!!.setCode(ERROR.SSL_ERROR)
            ex!!.setMessage("证书验证失败")
            return ex
        } else if (e is ClassCastException) {
            ex = AllExcertion(e, ERROR.CAST_ERROR)
            ex!!.setCode(ERROR.CAST_ERROR)
            ex!!.setMessage("类型转换错误")
            return ex
        } else if (e is JsonParseException
                || e is JSONException
                || e is JsonSyntaxException
                || e is JsonSerializer<*>
                || e is NotSerializableException
                || e is ParseException) {
            ex = AllExcertion(e, ERROR.PARSE_ERROR)
            ex!!.setCode(ERROR.PARSE_ERROR)
            ex!!.setMessage("解析错误")
            return ex
        } else if (e is IllegalStateException) {
            ex = AllExcertion(e, ERROR.ILLEGAL_STATE_ERROR)
            ex!!.setCode(ERROR.ILLEGAL_STATE_ERROR)
            ex!!.setMessage(e.message)
            return ex
        } else {
            ex = AllExcertion(e, ERROR.UNKNOWN)
            ex!!.setCode(ERROR.UNKNOWN)
            ex!!.setMessage("未知错误")
            return ex
        }
    }

    /**
     * 约定异常
     */
    object ERROR {
        /**
         * 未知错误
         */
        val UNKNOWN = 1000
        /**
         * 连接超时
         */
        val TIMEOUT_ERROR = 1001
        /**
         * 空指针错误
         */
        val NULL_POINTER_EXCEPTION = 1002

        /**
         * 证书出错
         */
        val SSL_ERROR = 1003

        /**
         * 类转换错误
         */
        val CAST_ERROR = 1004

        /**
         * 解析错误
         */
        val PARSE_ERROR = 1005

        /**
         * 非法数据异常
         */
        val ILLEGAL_STATE_ERROR = 1006

    }
}