package com.example.user.utils.ktutils.interfaces

import io.reactivex.disposables.Disposable



/**
 * 项目名称：AndroidUtils
 * 类描述：ISubscriber 描述:
 * 创建人：songlijie
 * 创建时间：2018/9/21 15:31
 * 邮箱:814326663@qq.com
 */
interface ISubscriber<T> {
    /**
     * doOnSubscribe 回调
     *
     * @param d Disposable
     */
    fun doOnSubscribe(d: Disposable)

    /**
     * 错误回调
     *
     * @param errorMsg 错误信息
     */
    fun doOnError(errorMsg: String?)

    /**
     * 成功回调
     *
     * @param t 泛型
     */
    fun doOnNext(t: T)

    /**
     * 请求完成回调
     */
    fun doOnCompleted()

}