package com.example.user.utils.weight.numal;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.IdRes;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;

import com.example.user.utils.R;

/**
 * @author slj
 * @email 814326663@qq.com
 * Created by slj on 2017/4/16.
 * Role: 实现要求。圆弧显示进度，中间固定显示三行文字
 */
public class RoundProgressView extends View {

    private float density;


    //当前的进度
    private float progress = 0;

    private String first = "Healer自定义";
    private String sceond = "进度条";
    private String third = "80%";

    //字体大小
    private float textSize;

    //圆弧半径
    private float radius;
    private float radiusInside;

    //绘制图片的大小
    private RectF rectF;
    private RectF rectFInside;
    private RectF rectFprogress;

    //绘制文字的画笔
    private TextPaint textPaint;


    //固定的宽高
    private float width;
    private float height;

    private DashPathEffect dashPathEffect;//圆弧虚线效果

    private ValueAnimator outerProgressAnim;
    private long duration = 1000;
    private long progressDelay = 350;
    private float outerProgressValue = 0;
    private int textPointColor = getContext().getResources().getColor(R.color.black);//字体画笔颜色
    private int startAngletextColor = getContext().getResources().getColor(R.color.black);//虚线画笔颜色
    private int textColor = getContext().getResources().getColor(R.color.blue);//字体颜色
    private int progressColor = getContext().getResources().getColor(R.color.blue);//字体画笔颜色


    public RoundProgressView(Context context) {
        super(context, null);
    }

    public RoundProgressView(Context context, AttributeSet attrs) {
        super(context, attrs, 0);
        //默认情况下会执行两个参数的构造方法
        textPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG);//消除绘制时候的锯齿
        textPaint.setTextAlign(Paint.Align.CENTER);//设置绘制的文字水平居中

        rectF = new RectF();//外空心圆弧大小
        rectFInside = new RectF();//内空心虚线圆弧大小
        rectFprogress = new RectF();//进度条

        density = context.getResources().getDisplayMetrics().density;//获取屏幕密度
        dashPathEffect = new DashPathEffect(new float[]{density * 3, density * 3}, 1);
        //避免density获取失败导致绘制失败的异常

        initAnim();
        if (isInEditMode()) {
            return;
        }
    }

    public RoundProgressView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        textPaint.setStrokeWidth(0.0f);
        //获取固定的宽高
        //在onmeasure不进行复写的情况下，View的高度设定就返回确切高度或者是没有固定宽高的父容器的wrap_content或者是match_parent返回整屏
        width = getWidth();
        height = getHeight();

        textSize = height / 15;//设计字体大小
        radius = height / 9 * 4f;//半径上下相加不能超过height
        radiusInside = radius * 7 / 8f;//内圆的半径

        //设置字体画笔
        textPaint.setStyle(Paint.Style.STROKE);//空心
        textPaint.setTextSize(textSize);
        textPaint.setColor(textPointColor);

        //为绘制圆弧做准备工作，在指定范围内切出圆弧存在的范围（PS:圆弧就是一个圆不画完）

        progress = Float.valueOf(progress) / 100;//占总数的百分比
        progress = Math.min(progress, 1f);//最高就是100%，避免传递数据错误产生误差值，降低用户体验

        //根据当前公司给的切面自己计算切面
        final float startAngle = -210f;
        final float sweepAngle = 240f;


        //开始绘制圆弧
        //1.首先将canvas画布平移到最中心，便于观察，为了规范书写（避免该次操作画布影响后续操作，需要save以及最后的restore）
        //2.确认圆弧范围，画笔样式(每次样式变化的情况都要设计画笔设置重置等)
        //3.绘制相应文本内容
        //4.绘制虚线
        //5.绘制进度

        canvas.save();
        canvas.translate(width / 2f, height / 2f);

        rectF.set(-radius, -radius, radius, radius);//这里要注意平移之后上方依然保持和之前一样是负的坐标，这里要熟悉坐标系，和普通的Y轴是相反的
        rectFInside.set(-radiusInside, -radiusInside, radiusInside, radiusInside);
        rectFprogress.set(-(radius - (radius - radiusInside) / 2),
                -(radius - (radius - radiusInside) / 2), (radius - (radius - radiusInside) / 2), (radius - (radius - radiusInside) / 2));

        canvas.drawArc(rectF, startAngle, sweepAngle, false, textPaint);

        textPaint.setStyle(Paint.Style.FILL);
        textPaint.setColor(textColor);
        textPaint.setTextSize(textSize);

        canvas.drawText(first, 0, -textSize * 2, textPaint);
        textPaint.setTextSize(textSize * 1.1f);
        textPaint.setColor(textColor);
        canvas.drawText(sceond, 0, 0, textPaint);
        textPaint.setTextSize(textSize * 1.3f);
        textPaint.setColor(textColor);
        canvas.drawText(Math.round(progress * 100) + "%", 0, textSize * 2, textPaint);


        //设置绘制虚线
        textPaint.setStyle(Paint.Style.STROKE);
        textPaint.setColor(startAngletextColor);
        textPaint.setPathEffect(dashPathEffect);
        canvas.drawArc(rectFInside, startAngle, sweepAngle, false, textPaint);

        //绘制进度,范围依然是最外层的范围，绘制画笔的宽度就是外层-内层的宽度
        textPaint.setStrokeWidth(radius - radiusInside);
        textPaint.setPathEffect(null);
        textPaint.setColor(progressColor);
        canvas.drawArc(rectFprogress, startAngle, sweepAngle * progress, false, textPaint);


        canvas.restore();
    }


    //设置百分比进度，默认情况下，最高为100%
    public void setDataProgress(float progress, String first, String second, String third) {
        if (progress >= 0) {
            this.progress = progress;
            updateAnimValue(progress);
            invalidate();//重绘界面
        }
        if (first != null && !TextUtils.isEmpty(first)) {
            this.first = first;
        }

        if (second != null && !TextUtils.isEmpty(second)) {
            this.sceond = second;
        }

        if (third != null && !TextUtils.isEmpty(third)) {
            this.third = third;
        }
    }

    //更改进度
    public void changeProgress(float progress) {
        if (progress >= 0) {
            this.progress = progress;
            updateAnimValue(progress);
            invalidate();//重绘界面
        }
    }

    //添加展示动画效果

    /**
     * 初始化属性动画
     */
    private void initAnim() {
        outerProgressAnim = new ValueAnimator();
        outerProgressAnim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Float value = (Float) animation.getAnimatedValue();
                updateOuterProgressValue(value);
                outerProgressValue = value;
            }
        });
    }

    private void updateOuterProgressValue(float value) {
        setOuterAnimAngle(value);
    }

    public void setOuterAnimAngle(float value) {
        this.progress = value;
        invalidate();
    }


    private void updateAnimValue(float progress) {
        outerProgressAnim.setFloatValues(outerProgressValue, progress);//设置进度范围
        outerProgressAnim.setDuration(duration + progressDelay);//设置延时时间
        outerProgressAnim.start();

    }

    public void setPointColor(@IdRes int color) {
        this.textPointColor = color;
        invalidate();//重绘界面
    }

    public void setTextColor(@IdRes int color) {
        this.textColor = color;
        invalidate();//重绘界面
    }

    public void setProgressColor(@IdRes int color) {
        this.progressColor = color;
        invalidate();//重绘界面
    }
}