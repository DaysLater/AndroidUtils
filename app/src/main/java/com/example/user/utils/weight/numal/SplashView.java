package com.example.user.utils.weight.numal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;

import com.example.user.utils.R;


/**
 * com.wsq.study.widget
 * 公司:浙江答分奇网络科技有限公司
 * created by 吴世芊 on 2016/10/2 14:22.
 * updated by
 * 邮箱:apple9302@126.com
 * 此类功能:
 */

public class SplashView extends View {

    //大圆半径
    private float mRotationRadius = 90;
    //每个小圆的半径
    private float mCircleRadius = 18;
    //小圆圈的颜色列表
    private int[] mCircleColors;
    //大圆和小圆旋转的时间
    private long mRotationDuration = 1200;
    //第二部分动画的执行总时间(包括三个动画时间,各占1/3)
    private long mSplashDuration = 1200;
    //总体的背景颜色
    private int mSplasBgColor = Color.WHITE;

    /**
     * 参数，保存了一些绘制状态，会被动态的改变
     */
    //空心圆初始半径
    private float mHoleRadius = 0F;
    //当前大圆旋转的角度(弧度)
    private float mCurrentRotationAngle = 0F;
    //当前大圆的半径
    private float mCurrentRotationRadius = mRotationRadius;
    //画笔
    private Paint mPaint = new Paint();
    //绘制背景的画笔
    private Paint mBackgroundPaint = new Paint();

    //屏幕正中心的坐标
    private float mCenterX, mCenterY;
    //屏幕对角线一半
    private float mDiagonalDist;

    //保存当前动画状态---当前执行哪种动画
    private SplashState mState = null;

    private abstract class SplashState {
        public abstract void drawState(Canvas canvas);
    }

    public SplashView(Context context) {
        this(context, null);
    }

    public SplashView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SplashView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        //小圆颜色数组
        mCircleColors = context.getResources().getIntArray(R.array.colors);
        //画笔初始化
        mPaint.setAntiAlias(true);
        mBackgroundPaint.setAntiAlias(true);
        //设置样式----边框样式---描边--颜色
        mBackgroundPaint.setStyle(Paint.Style.STROKE);
        mBackgroundPaint.setColor(mSplasBgColor);

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        //中心点
        mCenterX = w / 2;
        mCenterY = h / 2;
        //对角线一半
        mDiagonalDist = (float) (Math.sqrt(w * w + h * h) );
        super.onSizeChanged(w, h, oldw, oldh);
    }

    //进入主界面，开启后面两个动画;
    public void splashAndDisapear() {
        if (mState!=null&&mState instanceof RotateState){
            RotateState state= (RotateState) mState;
            //取消旋转动画
            state.cancle();
            //进入下一个动画
            post(new Runnable() {
                @Override
                public void run() {
                    mState=new MergingState();

                }
            });
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //绘制小圆动画
        if (mState == null) {
            //第一次执行动画
            mState = new RotateState();
        }
        mState.drawState(canvas);

    }

    //旋转动画
    private class RotateState extends SplashState {
        private ValueAnimator mAnimator;

        public RotateState() {
            //小圆的坐标--->大圆的半径,大圆旋转了多少角度
            //属性动画--估值器 花了1200ms，计算某个时刻当前的角度是，0-2π之间的某个值
            mAnimator = ValueAnimator.ofFloat(0, (float) Math.PI * 2);
            //设置线性估值器----会平滑计算
            mAnimator.setInterpolator(new LinearInterpolator());
            mAnimator.setDuration(mRotationDuration);
            mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    //得到某个时间点的结果
                    //这个时间点，大圆旋转的而角度
                    mCurrentRotationAngle = (float) animation.getAnimatedValue();
                   //重绘---onDraw()
                    invalidate();
                }
            });
            //设置旋转次数----不限次数
            mAnimator.setRepeatCount(ValueAnimator.INFINITE);
            //开始计算
            mAnimator.start();

        }

        @Override
        public void drawState(Canvas canvas) {
            //绘制小圆的旋转动画
            //1.清空画板
            drawBackground(canvas);
            //2.绘制小圆
            drawCircles(canvas);

        }
        public void cancle(){
            mAnimator.cancel();
        }
    }

    //聚合动画
    private class MergingState extends SplashState {
        private ValueAnimator mAnimator;
        public MergingState() {
            //动画-->估值器,1200ms 某个时刻大圆的半径
            mAnimator = ValueAnimator.ofFloat(0, mRotationRadius);
            //设置线性估值器----会平滑计算
            mAnimator.setInterpolator(new OvershootInterpolator(10f));
            mAnimator.setDuration(mSplashDuration/2);
            mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    //得到某个时间点的结果
                    //这个时间点，大圆的半径
                    mCurrentRotationRadius = (float) animation.getAnimatedValue();
                    //重绘---onDraw()
                    invalidate();
                }
            });
            //监听动画执行完毕
            mAnimator.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    mState=new ExpandingState();
                }
            });
            mAnimator.reverse();

            //翻转后不能再调用start方法,否则就会恢复到原来的状态
//            mAnimator.start();

        }

        @Override
        public void drawState(Canvas canvas) {
            //绘制小圆的旋转动画
            //1.清空画板
            drawBackground(canvas);
            //2.绘制小圆
            drawCircles(canvas);
        }
    }

    //扩散动画,绘制空心圆
    private class ExpandingState extends SplashState {
        private ValueAnimator mAnimator;
        public ExpandingState() {
            //动画--估值器-->计算某个时刻空心圆的半径,0--到对角线的一半
            mAnimator = ValueAnimator.ofFloat(0, mDiagonalDist/2);
            //设置线性估值器----会平滑计算
//            mAnimator.setInterpolator(new OvershootInterpolator(10f));
            mAnimator.setDuration(mSplashDuration);
            mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    //得到某个时间点的结果
                    //这个时间点，大圆的半径
                    mHoleRadius = (float) animation.getAnimatedValue();
                    //重绘---onDraw()
                    invalidate();
                }
            });
//            mAnimator.reverse();
            //翻转后不能再调用start方法,否则就会恢复到原来的状态
            mAnimator.start();
        }

        @Override
        public void drawState(Canvas canvas) {
            //绘制空心圆的扩散动画
            drawBackground(canvas);

        }
    }

    /**
     * 清空画板
     * @param canvas
     */
    private void drawBackground(Canvas canvas) {
        if (mHoleRadius>0f){
            /**
             * 绘制白色的空心圆
             * 技巧：使用一个非常宽的画笔，不断减小画笔的的宽度
             */
        //设置画笔的宽度=对角线/2-空心圆的半径
            float strokeWidth=mDiagonalDist/2-mHoleRadius;
            mBackgroundPaint.setStrokeWidth(strokeWidth);
            float radius=mHoleRadius+strokeWidth/2;
            canvas.drawCircle(mCenterX,mCenterY,radius,mBackgroundPaint);
        }else {
            canvas.drawColor(mSplasBgColor);
        }
    }

    /**
     * 绘制小圆
     * @param canvas
     */
    private void drawCircles(Canvas canvas) {
        double rotationAngle=2*Math.PI/mCircleColors.length;

        for (int i = 0; i <mCircleColors.length ;i++) {
            double angle=i*rotationAngle+mCurrentRotationAngle;
            mPaint.setColor(mCircleColors[i]);
            float x= (float) (mCenterX+mCurrentRotationRadius*Math.cos( angle));
            float y= (float) (mCenterY+mCurrentRotationRadius*Math.sin( angle));
            canvas.drawCircle(x,y,mCircleRadius,mPaint);
        }
    }

}
