package com.example.user.utils.request.volley;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.Gson;

import java.io.UnsupportedEncodingException;

/**
 * Gson方式请求类
 * @param <T>
 */
public class GsonRequest<T> extends Request<T> {
  
    private final Response.Listener<T> mListener;
  
    private Gson mGson;
  
    private Class<T> mClass;
  
    public GsonRequest(int method, String url, Class<T> clazz, Response.Listener<T> listener,
                       Response.ErrorListener errorListener) {
        super(method, url, errorListener);  
        mGson = new Gson();
        mClass = clazz;  
        mListener = listener;  
    }

    @Override
    public String getBodyContentType() {
        return super.getBodyContentType();
    }

    public GsonRequest(String url, Class<T> clazz, Response.Listener<T> listener,
                       Response.ErrorListener errorListener) {
        this(Method.GET, url, clazz, listener, errorListener);  
    }  
  
    @Override
    protected Response<T> parseNetworkResponse(NetworkResponse response) {
        try {  
            String jsonString = new String(response.data,
                    HttpHeaderParser.parseCharset(response.headers));
            return Response.success(mGson.fromJson(jsonString, mClass),  
                    HttpHeaderParser.parseCacheHeaders(response));  
        } catch (UnsupportedEncodingException e) {
            return Response.error(new ParseError(e));
        }  
    }  
  
    @Override
    protected void deliverResponse(T response) {  
        mListener.onResponse(response);  
    }  
  
}  