package com.example.user.utils.weight.numal;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * 自定义的欢迎动画  时光宝盒样式
 */
public class BoxLid extends LinearLayout implements View.OnClickListener {

    public interface OnBoxLidOpenedListener {
        public void onBoxLidOpened();
    }

    public interface OnBoxLidClosedListener {
        public void onBoxLidClosed();
    }

    //BoxLid的状态旗帜
    public static final int BOXLID_STATUS_CLOSED = 0;
    public static final int BOXLID_STATUS_CLOSING = 1;
    public static final int BOXLID_STATUS_OPENED = 2;
    public static final int BOXLID_STATUS_OPENING = 3;
    public static final int BOXLID_STATUS_LOADING = 4;
    public static final int BOXLID_STATUS_COMPLETED = 5;
    private int boxLidStatus = BOXLID_STATUS_CLOSED;

    //动画持续时间定义
    private static final long DURATION_LOADING = 2000;
    private static final long DURATION_OPEN = 800;
    private static final long DURATION_CLOSE = 800;
    //当BoxLid close后是否允许点击任意区域打开
    private static final boolean IS_CAN_CLICK_OPEN = true;
    //是否初始化完成的旗帜，用于loading open close操作判断
    private boolean isInitialized = false;
    //BoxLid打开和关闭的事件回调
    private OnBoxLidOpenedListener onBoxLidOpenedListener;
    private OnBoxLidClosedListener onBoxLidClosedListener;

    private LinearLayout vTopHalfContainer;
    private ImageView vTopHalfOrnamental;
    private TextView vTopHalfTitle;
    private ImageView vTopHalfCenterOrnamental;
    private ImageView vBottomHalfCenterOrnamental;
    private LinearLayout vBottomHalfContainer;
    private TextView vBottomHalfTitle;
    private ImageView vBottomHalfOrnamental;

    public BoxLid(Context context) {
        super(context);
        initBoxLid(context);
    }

    public BoxLid(Context context, AttributeSet attrs) {
        super(context, attrs);
        initBoxLid(context);
    }

    public BoxLid(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initBoxLid(context);
    }

    private void initBoxLid(Context context) {
        setOrientation(VERTICAL);
        LayoutParams layoutParams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        layoutParams.weight = 1;
        vTopHalfContainer = new LinearLayout(context);
        vTopHalfContainer.setOrientation(VERTICAL);
        vTopHalfContainer.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.BOTTOM);
        vTopHalfContainer.setLayoutParams(layoutParams);
        addView(vTopHalfContainer);

        LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

        vTopHalfOrnamental = new ImageView(context);
        vTopHalfOrnamental.setLayoutParams(params);
        vTopHalfContainer.addView(vTopHalfOrnamental);

        vTopHalfTitle = new TextView(context);
        vTopHalfTitle.setGravity(Gravity.CENTER_HORIZONTAL);
        vTopHalfTitle.setLayoutParams(params);
        vTopHalfTitle.setEms(1); //每行只显示一个字
        vTopHalfContainer.addView(vTopHalfTitle);

        vTopHalfCenterOrnamental = new ImageView(context);
        vTopHalfCenterOrnamental.setLayoutParams(params);
        vTopHalfContainer.addView(vTopHalfCenterOrnamental);
        //
        vBottomHalfContainer = new LinearLayout(context);
        vBottomHalfContainer.setOrientation(VERTICAL);
        vBottomHalfContainer.setGravity(Gravity.CENTER_HORIZONTAL);
        vBottomHalfContainer.setLayoutParams(layoutParams);
        addView(vBottomHalfContainer);

        vBottomHalfCenterOrnamental = new ImageView(context);
        vBottomHalfCenterOrnamental.setLayoutParams(params);
        vBottomHalfContainer.addView(vBottomHalfCenterOrnamental);

        vBottomHalfTitle = new TextView(context);
        vBottomHalfTitle.setGravity(Gravity.CENTER_HORIZONTAL);
        vBottomHalfTitle.setLayoutParams(params);
        vBottomHalfTitle.setEms(1);
        vBottomHalfContainer.addView(vBottomHalfTitle);

        vBottomHalfOrnamental = new ImageView(context);
        vBottomHalfOrnamental.setLayoutParams(params);
        vBottomHalfContainer.addView(vBottomHalfOrnamental);

        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                isInitialized = true;
                getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }
        });
    }

    public void setBoxLidColor(int boxLidColor) {
        vTopHalfContainer.setBackgroundColor(boxLidColor);
        vBottomHalfContainer.setBackgroundColor(boxLidColor);
    }

    public void setTopHalfOrnamental(int id) {
        setTopHalfOrnamental(getResources().getDrawable(id));
    }

    public void setTopHalfOrnamental(Drawable drawable) {
        vTopHalfOrnamental.setImageDrawable(drawable);
    }

    public void setBoxLidTitle(String title) {
        int titleLength = title.length();
        setTopHalfTitle(title.substring(0, titleLength / 2));
        setBottomHalfTitle(title.substring(titleLength / 2, titleLength));
    }

    public void setTopHalfTitle(String title) {
        vTopHalfTitle.setText(title);
    }

    public void setBottomHalfTitle(String title) {
        vBottomHalfTitle.setText(title);
    }

    public void setCenterOrnamental(int id) {
        setCenterOrnamental(getResources().getDrawable(id));
    }

    public void setCenterOrnamental(Drawable drawable) {
        vTopHalfCenterOrnamental.setImageDrawable(drawable);
        vBottomHalfCenterOrnamental.setImageDrawable(drawable);
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                vTopHalfCenterOrnamental.setY(vTopHalfCenterOrnamental.getY() + vTopHalfCenterOrnamental.getHeight() / 2);
                LayoutParams paramsTopHalf = new LayoutParams(vTopHalfCenterOrnamental.getWidth(), vTopHalfCenterOrnamental.getHeight());
                paramsTopHalf.setMargins(0, -vTopHalfCenterOrnamental.getHeight() / 2, 0, 0);
                vTopHalfCenterOrnamental.setLayoutParams(paramsTopHalf);
                //
                vBottomHalfCenterOrnamental.setY(vBottomHalfCenterOrnamental.getY() - vBottomHalfCenterOrnamental.getHeight() / 2);
                LayoutParams paramsBottomHalf = new LayoutParams(vBottomHalfCenterOrnamental.getWidth(), vBottomHalfCenterOrnamental.getHeight());
                paramsBottomHalf.setMargins(0, 0, 0, -vBottomHalfCenterOrnamental.getHeight() / 2);
                vBottomHalfCenterOrnamental.setLayoutParams(paramsBottomHalf);
                getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }
        });
    }

    public void setBottomHalfOrnamental(int id) {
        setBottomHalfOrnamental(getResources().getDrawable(id));
    }

    public void setBottomHalfOrnamental(Drawable drawable) {
        vBottomHalfOrnamental.setImageDrawable(drawable);
    }

    public void setBoxLidTitleColor(int color) {
        vTopHalfOrnamental.setColorFilter(color, PorterDuff.Mode.MULTIPLY);
        vTopHalfTitle.setTextColor(color);
        vTopHalfCenterOrnamental.setColorFilter(color, PorterDuff.Mode.MULTIPLY);
        vBottomHalfCenterOrnamental.setColorFilter(color, PorterDuff.Mode.MULTIPLY);
        vBottomHalfTitle.setTextColor(color);
        vBottomHalfOrnamental.setColorFilter(color, PorterDuff.Mode.MULTIPLY);
    }

    public void setBoxLidTitleTextSize(int id) {
        setBoxLidTitleTextSize(getResources().getDimension(id));
    }

    public void setBoxLidTitleTextSize(float dimension) {
        vTopHalfTitle.setTextSize(dimension);
        vBottomHalfTitle.setTextSize(dimension);
    }

    public void setOnBoxLidOpenedListener(OnBoxLidOpenedListener onBoxLidOpenedListener) {
        this.onBoxLidOpenedListener = onBoxLidOpenedListener;
    }

    public void setOnBoxLidClosedListener(OnBoxLidClosedListener onBoxLidClosedListener) {
        this.onBoxLidClosedListener = onBoxLidClosedListener;
    }

    public int getBoxLidStatus() {
        return boxLidStatus;
    }

    public void open() {
        if (isInitialized) {
            startOpenAnimation();
        } else {
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                @Override
                public void onGlobalLayout() {
                    startOpenAnimation();
                    getViewTreeObserver().removeGlobalOnLayoutListener(this);
                }
            });
        }
    }

    private void startOpenAnimation() {
        boxLidStatus = BOXLID_STATUS_OPENING;

        vTopHalfCenterOrnamental.clearAnimation();
        vBottomHalfCenterOrnamental.clearAnimation();
        //注意这里的四个参数都是相对于该View X,Y 坐标的差值
        TranslateAnimation topHalfAnim = new TranslateAnimation(0, 0, 0, -1 * vTopHalfContainer.getHeight());
        topHalfAnim.setInterpolator(new AccelerateInterpolator());
        topHalfAnim.setDuration(DURATION_OPEN);
        topHalfAnim.setFillAfter(true);
        //注意这里一定要用startAnimation,如果用setAnimation则有可能不被播放
        vTopHalfContainer.startAnimation(topHalfAnim);

        TranslateAnimation bottomHalfAnim = new TranslateAnimation(0, 0, 0, vBottomHalfContainer.getHeight());
        bottomHalfAnim.setInterpolator(new AccelerateInterpolator());
        bottomHalfAnim.setDuration(DURATION_OPEN);
        bottomHalfAnim.setFillAfter(true);
        vBottomHalfContainer.startAnimation(bottomHalfAnim);

        topHalfAnim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                boxLidStatus = BOXLID_STATUS_OPENED;
                if (null != onBoxLidOpenedListener)
                    onBoxLidOpenedListener.onBoxLidOpened();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public void loadingComplete() {
        vTopHalfCenterOrnamental.getAnimation().setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                boxLidStatus = BOXLID_STATUS_COMPLETED;

                vTopHalfCenterOrnamental.clearAnimation();
                vBottomHalfCenterOrnamental.clearAnimation();
            }
        });
    }

    public void loading() {
        if (isInitialized) {
            startLoadingAnimation();
        } else {
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                @Override
                public void onGlobalLayout() {
                    startLoadingAnimation();
                    getViewTreeObserver().removeGlobalOnLayoutListener(this);
                }
            });
        }
    }

    private void startLoadingAnimation() {
        boxLidStatus = BOXLID_STATUS_LOADING;

        RotateAnimation topRotateAnimation = new RotateAnimation(0, 360, vTopHalfCenterOrnamental.getWidth() / 2, vTopHalfCenterOrnamental.getHeight());
        topRotateAnimation.setDuration(DURATION_LOADING);
        topRotateAnimation.setInterpolator(new LinearInterpolator());
        topRotateAnimation.setRepeatMode(Animation.RESTART);
        topRotateAnimation.setRepeatCount(Animation.INFINITE);
        vTopHalfCenterOrnamental.startAnimation(topRotateAnimation);
        RotateAnimation rotateAnimation = new RotateAnimation(0, 360, vBottomHalfCenterOrnamental.getWidth() / 2, 0);
        rotateAnimation.setDuration(DURATION_LOADING);
        rotateAnimation.setInterpolator(new LinearInterpolator());
        rotateAnimation.setRepeatMode(Animation.RESTART);
        rotateAnimation.setRepeatCount(Animation.INFINITE);
        vBottomHalfCenterOrnamental.startAnimation(rotateAnimation);
    }

    public void close() {
        boxLidStatus = BOXLID_STATUS_CLOSING;

        vTopHalfContainer.clearAnimation();
        vBottomHalfContainer.clearAnimation();

        TranslateAnimation topHalfAnim = new TranslateAnimation(0, 0, -vTopHalfContainer.getHeight(), 0);
        topHalfAnim.setInterpolator(new DecelerateInterpolator());
        topHalfAnim.setDuration(DURATION_CLOSE);
        vTopHalfContainer.startAnimation(topHalfAnim);

        TranslateAnimation bottomHalfAnim = new TranslateAnimation(0, 0, vBottomHalfContainer.getHeight(), 0);
        bottomHalfAnim.setInterpolator(new DecelerateInterpolator());
        bottomHalfAnim.setDuration(DURATION_CLOSE);
        vBottomHalfContainer.startAnimation(bottomHalfAnim);
        topHalfAnim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                boxLidStatus = BOXLID_STATUS_CLOSED;
                if (null != onBoxLidClosedListener)
                    onBoxLidClosedListener.onBoxLidClosed();
                if (IS_CAN_CLICK_OPEN)
                    setOnClickListener(BoxLid.this);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    /**
     * 点击BoxLid任意区域打开
     */
    @Override
    public void onClick(View v) {
        open();
        setOnClickListener(null);
    }
}