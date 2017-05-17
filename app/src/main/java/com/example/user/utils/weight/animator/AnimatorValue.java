package com.example.user.utils.weight.animator;

import com.nineoldandroids.animation.ObjectAnimator;

public interface AnimatorValue {
	public abstract ObjectAnimator getAnimator();
	public abstract ObjectAnimator getBeforeAnimator();
	public abstract void before(AnimatorValue beforeAnimatorValue);
}
