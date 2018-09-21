package com.example.user.utils.ktutils.base

import com.example.user.utils.ktutils.excertioncode.AllExcertion
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import okhttp3.ResponseBody

/**
 * 项目名称：AndroidUtils
 * 类描述：BaseDownLoadObserver 描述:
 * 创建人：songlijie
 * 创建时间：2018/9/21 17:07
 * 邮箱:814326663@qq.com
 */
abstract class BaseDownLoadObserver : Observer<ResponseBody> {
    override fun onComplete() {

    }

    override fun onSubscribe(d: Disposable) {
    }

    override fun onNext(t: ResponseBody) {
    }

    override fun onError(e: Throwable) {
        val message = AllExcertion().handleException(e).getErorMessage()
        setError(message)
    }

    /**
     * 失败回调
     *
     * @param errorMsg 错误信息
     */
    protected abstract fun doOnError(errorMsg: String?)

    private fun setError(errorMsg: String?) {
        doOnError(errorMsg)
    }

}