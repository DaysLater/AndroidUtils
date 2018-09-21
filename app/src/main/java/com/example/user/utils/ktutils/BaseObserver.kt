package com.example.user.utils.ktutils

import com.example.user.utils.ktutils.excertioncode.AllExcertion
import com.example.user.utils.ktutils.interfaces.ISubscriber
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

/**
 * 项目名称：AndroidUtils
 * 类描述：BaseObserver 描述:
 * 创建人：songlijie
 * 创建时间：2018/9/21 15:23
 * 邮箱:814326663@qq.com
 */
abstract class BaseObserver<T> : Observer<T>, ISubscriber<T> {
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

    override fun onNext(t: T) {
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