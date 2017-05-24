package com.example.user.utils.weight.numal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;

/**
 * 自定义带进度的Imagview
 */
public class ProcessImageView extends ImageView {

    private Paint mPaint;// 画笔
    Context context = null;
    int progress = 0;
    private boolean isfinished = false;

    public ProcessImageView(Context context) {
        super(context);
        // TODO Auto-generated constructor stub
    }

    public ProcessImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ProcessImageView(Context context, AttributeSet attrs,
                            int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        mPaint = new Paint();
    }

    @SuppressLint("DrawAllocation")
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (isfinished) {
            return;
        }
        mPaint.setAntiAlias(true); // 消除锯齿
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.parseColor("#70000000"));// 半透明
        canvas.drawRect(0, 0, getWidth(), getHeight() - getHeight() * progress
                / 100, mPaint);
        mPaint.setColor(Color.parseColor("#00000000"));// 全透明
        canvas.drawRect(0, getHeight() - getHeight() * progress / 100,
                getWidth(), getHeight(), mPaint);

        mPaint.setTextSize(30);
        mPaint.setColor(Color.parseColor("#FFFFFF"));
        mPaint.setStrokeWidth(2);
        Rect rect = new Rect();
        mPaint.getTextBounds("100%", 0, "100%".length(), rect);// 确定文字的宽度
        canvas.drawText(progress + "%", getWidth() / 2 - rect.width() / 2,
                getHeight() / 2, mPaint);

    }

    public void setProgress(int progress) {
        this.progress = progress;
        postInvalidate();
    }

    public void finish() {
        isfinished = true;
        postInvalidate();
    }
}