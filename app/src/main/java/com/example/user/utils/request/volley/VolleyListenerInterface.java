package com.example.user.utils.request.volley;

import android.content.Context;

import com.android.volley.Response;
import com.android.volley.VolleyError;

public abstract class VolleyListenerInterface {
    private Context mContext;
    private Response.Listener<String> mListener;
    private Response.ErrorListener mErrorListener;
    private VolleyListenerInterface volleyListenerInterface;

    /**
     * 初始化接口建议不要使用
     * @param context
     * @param listener
     * @param errorListener
     */
    public VolleyListenerInterface(Context context, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        this.mContext = context;
        this.mErrorListener = errorListener;
        this.mListener = listener;
    }

    /**
     * 初始化接口 不建议使用
     * @param context
     * @param listenerInterface
     */
    public VolleyListenerInterface(Context context, VolleyListenerInterface listenerInterface) {
        this.mContext = context;
        this.volleyListenerInterface = listenerInterface;
    }

    /**
     * 初始化接口,建议直接使用
     */
    public VolleyListenerInterface(){
        Response.Listener<String> listener;
        Response.ErrorListener errorListener;
    }

    // 请求成功时的回调函数
    public abstract void onMySuccess(String result);
    // 请求失败时的回调函数
    public abstract void onMyError(VolleyError error);

    // 创建请求的事件监听
    public Response.Listener<String> responseListener() {
        mListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                onMySuccess(s);
            }
        };
        return mListener;
    }
    // 创建请求失败的事件监听
    public Response.ErrorListener errorListener() {
        mErrorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                onMyError(volleyError);
            }
        };
        return mErrorListener;
    }

}