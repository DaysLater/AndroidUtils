package com.example.user.utils.string;

import android.view.View;
import com.example.user.utils.weight.animator.AnimationFactory;
import com.example.user.utils.weight.animator.AnimatorValue;
import com.example.user.utils.weight.animator.AnimatorValueImplements;
import com.nineoldandroids.animation.Animator;

/**
 * 项目名称：AndroidUtils
 * 类描述：AnimUtils 描述: 动画工具类
 * 创建人：songlijie
 * 创建时间：2017/5/17 14:19
 * 邮箱:814326663@qq.com
 */
public class AnimUtils {
    /**
     * 获取AnimatorValue对象
     *
     * @param animView 作用动画的view
     * @param proName  Alpha ScaleX
     * @param duration 时长
     * @param values   如 new AnimatorValueImplements(im_guide,"ScaleX",1.5f,1.4f,1.3f,1.2f,1.1f,1f);
     * @return
     */
    public static AnimatorValue getAnimatorValue(View animView, String proName, long duration, float... values) {
        AnimatorValue animatorValue = new AnimatorValueImplements(animView, proName, values);
        animatorValue.getAnimator().setDuration(duration);
        return animatorValue;
    }

    /**
     * 获取AnimatorValue对象
     *
     * @param animView 作用动画的view
     * @param proName  Alpha ScaleX
     * @param duration 时长
     * @param values   如 new AnimatorValueImplements(im_guide,"ScaleX",1.5f,1.4f,1.3f,1.2f,1.1f,1f);
     * @return
     */
    public static AnimatorValue getAnimatorValue(View animView, String proName, long duration, int... values) {
        AnimatorValue animatorValue = new AnimatorValueImplements(animView, proName, values);
        animatorValue.getAnimator().setDuration(duration);
        return animatorValue;
    }

    /**
     * 开启动画
     *
     * @param listener
     * @param animatorValues
     */
    public static void startAnimator(Animator.AnimatorListener listener, AnimatorValue... animatorValues) {
        AnimationFactory.getInstance().createEngine().startTogetherByLink(
                listener, animatorValues);
    }
}
