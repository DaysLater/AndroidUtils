package com.example.user.utils.weight.webView;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.text.TextUtils;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * 项目名称：QianShan
 * 类描述：MyWebViewClient 帮助WebView处理各种通知、请求事件的(带dialog)
 * 创建人：slj
 * 创建时间：2016-8-22 11:58
 * 修改人：slj
 * 修改时间：2016-8-22 11:58
 * 修改备注：
 * 邮箱:slj@bjlingzhuo.com
 */
public class MyWebViewClient extends WebViewClient {
    private Context context;
    private ProgressDialog progressDialog;
    private String message = null ;//默认的是null
    public MyWebViewClient(Context context) {
        this.context=context;
    }
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) { //网页加载时的连接的网址
        view.loadUrl(url);
        return false;
    }

    /**
     * 设置展示的webview
     * @param view
     * @param url
     */
    @SuppressLint("JavascriptInterface")
    public void setWebView(WebView view , String url){
        onPageStarted(view,url,null);
        shouldOverrideUrlLoading(view,url);
        onPageFinished(view,url);
    }

    /**
     * 设置进度弹出框的显示文字
     * @param message
     */
    public void setMessage(String message){
        this.message = message;
    }
    /**
     * 设置进度弹出框的显示文字
     * @param message
     */
    public void setMessage(int message){
        this.message = context.getString(message);
    }
    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {//网页页面开始加载的时候
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(context);
            if (message == null || TextUtils.isEmpty(message))
                progressDialog.setMessage("正在加载,请稍候....");
            else
                progressDialog.setMessage(message);

            progressDialog.show();
            view.setEnabled(false);// 当加载网页的时候将网页进行隐藏
        }
        super.onPageStarted(view, url, favicon);
    }

    @Override
    public void onPageFinished(WebView view, String url) {//网页加载结束的时候
        //super.onPageFinished(view, url);
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
            progressDialog = null;
            view.setEnabled(true);
        }
        super.onPageFinished(view, url);
    }
    @Override
    public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
        //handler.cancel(); // Android默认的处理方式
        handler.proceed();  // 接受所有网站的证书
        //handleMessage(Message msg); // 进行其他处理
        super.onReceivedSslError(view, handler, error);
    }
}