package com.example.user.utils.weight.webView;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.webkit.WebView;

/**
 * 项目名称：QianShan
 * 类描述：ScrollWebView 可滑动的webview
 * 创建人：slj
 * 创建时间：2016-8-22 11:58
 * 修改人：slj
 * 修改时间：2016-8-22 11:58
 * 修改备注：
 * 邮箱:slj@bjlingzhuo.com
 */
public class ScrollWebView extends WebView {
	public OnScrollChangeListener listener;

	public ScrollWebView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	public ScrollWebView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public ScrollWebView(Context context) {
		super(context);
	}

	@Override
	protected void onScrollChanged(int l, int t, int oldl, int oldt) {

		super.onScrollChanged(l, t, oldl, oldt);

		float webcontent = getContentHeight() * getScale();// webview的高度
		float webnow = getHeight() + getScrollY();// 当前webview的高度
		Log.i("TAG1", "webview.getScrollY()====>>" + getScrollY());
		if (Math.abs(webcontent - webnow) < 1) {
			// 已经处于底端
			listener.onPageEnd(l, t, oldl, oldt);
		} else if (getScrollY() == 0) {
			// 已经处于顶端
			listener.onPageTop(l, t, oldl, oldt);
		} else {
			listener.onScrollChanged(l, t, oldl, oldt);
		}

	}

	public void setOnScrollChangeListener(OnScrollChangeListener listener) {

		this.listener = listener;

	}

	public interface OnScrollChangeListener {
		public void onPageEnd(int l, int t, int oldl, int oldt);
		public void onPageTop(int l, int t, int oldl, int oldt);
		public void onScrollChanged(int l, int t, int oldl, int oldt);

	}

}