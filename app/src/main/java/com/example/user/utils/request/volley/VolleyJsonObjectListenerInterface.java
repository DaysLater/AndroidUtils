package com.example.user.utils.request.volley;

import android.content.Context;

import com.android.volley.Response;
import com.android.volley.VolleyError;

/**
 * Created by Administrator on 2016/7/4.
 */
public abstract class VolleyJsonObjectListenerInterface {
    public Context mContext;
    public static Response.ErrorListener mErrorListener;
    public static Response.Listener<org.json.JSONObject> JSONObject;
    public static VolleyJsonObjectListenerInterface volleyJsonListenerInterface;
    public VolleyJsonObjectListenerInterface(){
        Response.Listener<org.json.JSONObject> responseObjListener;
        Response.ErrorListener errorObjListener;
    }
    public VolleyJsonObjectListenerInterface(Context context, VolleyJsonObjectListenerInterface volleyJsonListenerInterface) {
        this.mContext = context;
        this.volleyJsonListenerInterface = volleyJsonListenerInterface;
    }
    public VolleyJsonObjectListenerInterface(Context context, Response.Listener<org.json.JSONObject> responseObjListener, Response.ErrorListener errorObjListener) {
        this.mContext = context;
        this.mErrorListener = errorObjListener;
        this.JSONObject = responseObjListener;
    }
    // 请求成功时的回调函数
    public abstract void onMySuccessObj(org.json.JSONObject result);
    // 请求失败时的回调函数
    public abstract void onMyErrorObj(VolleyError error);
    // 创建请求的事件监听
    public Response.Listener<org.json.JSONObject> responseObjListener() {
        JSONObject = new Response.Listener<org.json.JSONObject>() {
            @Override
            public void onResponse(org.json.JSONObject s) {
                onMySuccessObj(s);
            }
        };
        return JSONObject;
    }
    // 创建请求失败的事件监听
    public Response.ErrorListener errorObjListener() {
        mErrorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                onMyErrorObj(volleyError);
            }
        };
        return mErrorListener;
    }
}
