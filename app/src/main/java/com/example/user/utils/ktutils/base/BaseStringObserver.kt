package com.example.user.utils.ktutils.base

import com.example.user.utils.ktutils.excertioncode.AllExcertion
import com.example.user.utils.ktutils.interfaces.IStringSubscriber
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

/**
 * 项目名称：AndroidUtils
 * 类描述：BaseStringObserver 描述:
 * 创建人：songlijie
 * 创建时间：2018/9/21 16:56
 * 邮箱:814326663@qq.com
 */
abstract class BaseStringObserver : Observer<String>, IStringSubscriber {

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

    override fun onNext(t: String) {
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