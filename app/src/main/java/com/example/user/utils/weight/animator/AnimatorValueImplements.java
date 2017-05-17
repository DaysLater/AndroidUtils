package com.example.user.utils.weight.animator;

import android.view.View;
import com.nineoldandroids.animation.ObjectAnimator;
import com.nineoldandroids.animation.TypeEvaluator;

public class AnimatorValueImplements implements AnimatorValue{
	
	private ObjectAnimator objectAnimator;
	private AnimatorValue beforeAnimatorValue;
	
	public AnimatorValueImplements(View view, String proName, int... values){
		createProNameInt(view, proName,values);
	}
	
	public AnimatorValueImplements(View view, String proName, float... values){
		createProNameFloat(view, proName,values);
	}
	
	public AnimatorValueImplements(Object object, TypeEvaluator<Object> typeEvaluator, String proName, Object... values){
		createProNameObject(object, typeEvaluator, proName, values);
	}
	
	public ObjectAnimator createProNameInt(View view, String proName, int... values) {
		objectAnimator=ObjectAnimator.ofInt(view, proName, values);
		return objectAnimator;
	}

	public ObjectAnimator createProNameFloat(View view, String proName, float... values) {
		objectAnimator=ObjectAnimator.ofFloat(view, proName, values);
		return objectAnimator;
	}

	public ObjectAnimator createProNameObject(Object object, TypeEvaluator<Object> typeEvaluator, String proName, Object... values) {
		objectAnimator=ObjectAnimator.ofObject(object, proName, typeEvaluator, values);
		return objectAnimator;
	}
	
	@Override
	public void before(AnimatorValue beforeAnimatorValue){
		this.beforeAnimatorValue=beforeAnimatorValue;
	}

	@Override
	public ObjectAnimator getAnimator() {
		if(objectAnimator!=null){
			return objectAnimator;
		}else{
			return new ObjectAnimator();
		}

	}

	@Override
	public ObjectAnimator getBeforeAnimator() {
		if(beforeAnimatorValue!=null){
			return beforeAnimatorValue.getAnimator();
		}else{
			return null;
		}
	}

}
