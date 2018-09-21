package com.example.user.utils.ktutils.base

import com.alibaba.fastjson.JSONObject
import com.example.user.utils.ktutils.bean.BaseResult
import com.example.user.utils.ktutils.excertioncode.AllExcertion
import com.example.user.utils.ktutils.interfaces.IBaseResultSubscriber
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

/**
 * 项目名称：AndroidUtils
 * 类描述：BaseBaseResultObserver 描述:
 * 创建人：songlijie
 * 创建时间：2018/9/21 16:06
 * 邮箱:814326663@qq.com
 */
abstract class BaseBaseResultObserver<T>: IBaseResultSubscriber<T>, Observer<BaseResult<T>> {

    /**
     * 是否隐藏toast
     *
     * @return
     */
    protected fun isHideToast(): Boolean {
        return false
    }

    override fun onComplete() {
        doOnCompleted()
    }


    override fun onSubscribe(d: Disposable) {
        doOnSubscribe(d)
    }

    override fun onNext(t: BaseResult<T>) {
        doOnNext(t)
    }

    override fun onError(e: Throwable) {
        showError(e)
    }

    private fun showError(e: Throwable?) {
        val message = AllExcertion().handleException(e).getErorMessage()
        doOnError(message)
    }
}